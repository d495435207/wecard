/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the confidential and proprietary information
 * of danxiangjie.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with danxiangjie.com.
 */
package com.dxj.wecard.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.dao.AuthorizationTokenMapper;
import com.dxj.wecard.dao.AuthorizerInfoMapper;
import com.dxj.wecard.model.AuthorizationToken;
import com.dxj.wecard.model.AuthorizerInfo;
import com.dxj.wecard.model.WeixinApp;
import com.dxj.wecard.service.WeixinAppService;
import com.dxj.wecard.service.WeixinComponentService;
import com.dxj.wecard.weixin.component.model.AuthorizerInfoDetail;
import com.dxj.wecard.weixin.component.model.AuthorizerInfoSimple;
import com.dxj.wecard.weixin.component.model.ComponentAccessToken;
import com.dxj.wecard.weixin.component.model.Funcion;
import com.dxj.wecard.weixin.util.TrustAnyTrustManager;
import com.dxj.wecard.weixin.util.WeiXinMessageEncrypt;
import com.dxj.wecard.weixin.util.WeixinConstant;
import com.dxj.wecard.weixin.util.WeixinXmlUtils;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

@Service("weixinComponentService")
public class WeixinComponentServiceImpl implements WeixinComponentService {

    static final Logger                         logger = LogManager.getLogger(WeixinComponentServiceImpl.class);
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    private WeixinAppService         weixinAppService;
    @Autowired
    private AuthorizationTokenMapper authorizationInfoMapper;

    @Autowired
    private AuthorizerInfoMapper componentAuthorizerInfoMapper;

    @Override
    public ComponentAccessToken getConponentAccessToken() {
        try {
            ComponentAccessToken accessToken = new ComponentAccessToken();
            // 先从缓存获取,取不到值就重新调取微信接口获取
            String token = (String) redisTemplate.opsForValue().get("component_access_token");
            if (!StringUtils.isBlank(token)) {
                accessToken.setComponentAccessToken(token);
                return accessToken;
            }
            // 缓存没有调取API获取，在保存缓存
            String component_access_token = requestComToken(accessToken);
            // 设置component_access_token 缓存时间7000秒
            redisTemplate.opsForValue().set("component_access_token", component_access_token, 7000, TimeUnit.SECONDS);
            logger.info("缓存的中的accessToken" + redisTemplate.opsForValue().get("component_access_token"));
            return accessToken;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public String getAuthorizerdAccessToken(String authorizerAppid) {
        String ticket = (String) redisTemplate.opsForValue().get(WeixinConstant.AUTHTOKENPREFIX + authorizerAppid);
        if (!StringUtils.isBlank(ticket)) {
            return ticket;
        }
        AuthorizationToken authToken = refreshAuthorizationToken(authorizerAppid);
        if (authToken == null) return null;
        redisTemplate.opsForValue().set(WeixinConstant.AUTHTOKENPREFIX + authorizerAppid,
                                        authToken.getAuthorizerAccessToken(), 7000, TimeUnit.SECONDS);
        ;
        return authToken.getAuthorizerAccessToken();
    }

    @Override
    public void doWeixinBizPushEvent(Map<String, String> resultMap) {
        // 只接收处理事件消息
        String eventType = resultMap.get("Event");
        if (StringUtils.isBlank(eventType)) return;
        if (WeixinConstant.USEGETCARD.equalsIgnoreCase(eventType)) {

        }
        if (WeixinConstant.USECONSUMECARD.equalsIgnoreCase(eventType)) {

        }
    }

    @Override
    public void doComponentPushEvent(Map<String, String> resultMap) {
        if (resultMap.containsKey(WeixinConstant.VERIFYTICKET)) {
            updateComponentVerifyTicket(resultMap);
        }
        if (resultMap.containsKey("InfoType")
            && resultMap.get("InfoType").equalsIgnoreCase(WeixinConstant.UNAUTHORIZED)) {
            doUnauthorizedEvent(resultMap);
        }
    }

    @Override
    public String getPreauthCode(String componentAppid, String componentAccessToken) {
        String url = WeixinConstant.PREAUTHCODE.replace("ACCESSTOKEN", componentAccessToken);
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("component_appid", componentAppid);
            String parames = JSON.toJSONString(paramMap);
            JSONObject jsonObject = httpsRequest(url, "POST", parames);
            String precode = "";
            if (jsonObject != null) {
                // 取得预授权码
                precode = jsonObject.getString("pre_auth_code");
            }
            return precode;
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public AuthorizerInfo getAuthInfo(String authorizationCode, String componentAccessToken) {
        try {
            String url = WeixinConstant.AUTHINOAPI.replace("ACCESSTOKEN", componentAccessToken);
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("component_appid", WeixinConstant.COMPONENTAPPID);
            paramMap.put("authorization_code", authorizationCode);
            String parames = JSON.toJSONString(paramMap);
            JSONObject jsonObject = httpsRequest(url, "POST", parames);
            AuthorizerInfoSimple infoSimple = null;
            AuthorizationToken info = null;
            if (jsonObject != null) {
                infoSimple = new Gson().fromJson(jsonObject.toString(), AuthorizerInfoSimple.class);
                logger.error("获取公众平台授权信息成功 " + infoSimple.toString() + "其中"
                             + infoSimple.getAuthorization_info().getAuthorizer_access_token());
                authorizationInfoMapper.delete(infoSimple.getAuthorization_info().getAuthorizer_appid());
                if (infoSimple != null) {
                    info = setAuthorizer(infoSimple, info);
                    authorizationInfoMapper.insert(info);
                }
                // 保存授权详细信息
                AuthorizerInfo infoDetail = getAuthorizerInfoDetail(WeixinConstant.COMPONENTAPPID,
                                                                    infoSimple.getAuthorization_info().getAuthorizer_appid(),
                                                                    componentAccessToken);
                return infoDetail;
            } else {
                logger.error("获取公众平台授权信息失败");
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return null;

    }

    /**
     * @param infoSimple
     * @param info
     * @author liulihai 2015年10月13日 上午11:38:28
     */
    private AuthorizationToken setAuthorizer(AuthorizerInfoSimple infoSimple, AuthorizationToken info) {
        if (info == null) {
            info = new AuthorizationToken();
        }
        info.setAuthorizerAccessToken(infoSimple.getAuthorization_info().getAuthorizer_access_token());
        info.setAuthorizerAppid(infoSimple.getAuthorization_info().getAuthorizer_appid());
        info.setAuthorizerRefreshToken(infoSimple.getAuthorization_info().getAuthorizer_refresh_token());
        info.setExpiresIn(infoSimple.getAuthorization_info().getExpires_in());
        StringBuffer sb = parseFuncion(infoSimple.getAuthorization_info().getFunc_info());
        info.setFuncInfo(sb.toString());
        return info;
    }

    @Override
    public AuthorizationToken refreshAuthorizationToken(String authorizerAppid) {
        AuthorizationToken token = authorizationInfoMapper.selectByPrimaryKey(authorizerAppid);
        if (token == null) return null;
        ComponentAccessToken componentToken = getConponentAccessToken();
        String url = WeixinConstant.REFRESHTOKENAPI.replace("ACCESSTOKEN", componentToken.getComponentAccessToken());
        String refreshToken = token.getAuthorizerRefreshToken();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("component_appid", WeixinConstant.COMPONENTAPPID);
        paramMap.put("authorizer_appid", authorizerAppid);
        paramMap.put("authorizer_refresh_token", refreshToken);
        String parames = JSON.toJSONString(paramMap);
        JSONObject jsonObject = httpsRequest(url, "POST", parames);
        if (jsonObject != null) {
            String authorizer_access_token = (String) jsonObject.get("authorizer_access_token");
            String authorizer_refresh_token = (String) jsonObject.get("authorizer_refresh_token");
            token.setAuthorizerAccessToken(authorizer_access_token);
            token.setAuthorizerRefreshToken(authorizer_refresh_token);
            authorizationInfoMapper.update(token);
            return token;
        }
        return null;
    }

    @Override
    public AuthorizerInfo getAuthorizerInfoDetail(String component_appid, String auth_appid_value,
                                                  String componentAccessToken) {
        AuthorizerInfo authorizerInfo = new AuthorizerInfo();
        try {
            String url = WeixinConstant.GETAUTHORIZERINFO.replace("ACCESSTOKEN", componentAccessToken);
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("component_appid", component_appid);
            paramMap.put("authorizer_appid", auth_appid_value);
            String parames = JSON.toJSONString(paramMap);
            JSONObject jsonObject = httpsRequest(url, "POST", parames);
            AuthorizerInfoDetail detail = null;
            if (jsonObject != null) {
                // 解析微信返回的授权公众号详细信息
                detail = new Gson().fromJson(jsonObject.toString(), AuthorizerInfoDetail.class);
            }
            // 保存授权信息
            authorizerInfo = saveAuthorizerInfo(authorizerInfo, detail);
        } catch (Exception e) {
            logger.error(e);
        }
        return authorizerInfo;
    }

    // 保存首授权详细信息
    private AuthorizerInfo saveAuthorizerInfo(AuthorizerInfo authorizerInfo,
                                              AuthorizerInfoDetail authorizerInfoDetail) {

        componentAuthorizerInfoMapper.deleteByAppid(authorizerInfoDetail.getAuthorization_info().getAuthorizer_appid());
        try {
            authorizerInfo = setAuthorizerInfo(authorizerInfo, authorizerInfoDetail);
            componentAuthorizerInfoMapper.insert(authorizerInfo);
        } catch (Exception e) {
            logger.error(e);
        }
        return authorizerInfo;
    }

    /**
     * @param authorizerInfo
     * @param authorizerInfoDetail
     * @author liulihai 2015年10月13日 上午11:46:59
     */
    private AuthorizerInfo setAuthorizerInfo(AuthorizerInfo authorizerInfo, AuthorizerInfoDetail authorizerInfoDetail) {
        if (authorizerInfo == null) authorizerInfo = new AuthorizerInfo();
        // 可能为null
        Timestamp current = new Timestamp(System.currentTimeMillis());
        authorizerInfo.setAlisa(authorizerInfoDetail.getAuthorizer_info().getAlias() == null ? "" : authorizerInfoDetail.getAuthorizer_info().getAlias());
        authorizerInfo.setAppId(authorizerInfoDetail.getAuthorization_info().getAuthorizer_appid());
        List<Funcion> function = authorizerInfoDetail.getAuthorization_info().getFunc_info();
        StringBuffer sb = parseFuncion(function);
        authorizerInfo.setFuncInfo(sb.toString());
        authorizerInfo.setOpenCard(authorizerInfoDetail.getAuthorizer_info().getBusiness_info().getOpen_card());
        authorizerInfo.setOpenPay(authorizerInfoDetail.getAuthorizer_info().getBusiness_info().getOpen_pay());
        authorizerInfo.setOpenScan(authorizerInfoDetail.getAuthorizer_info().getBusiness_info().getOpen_scan());
        authorizerInfo.setOpenShake(authorizerInfoDetail.getAuthorizer_info().getBusiness_info().getOpen_shake());
        authorizerInfo.setOpenStore(authorizerInfoDetail.getAuthorizer_info().getBusiness_info().getOpen_store());
        authorizerInfo.setHeadImg(authorizerInfoDetail.getAuthorizer_info().getHead_img());
        authorizerInfo.setNickName(authorizerInfoDetail.getAuthorizer_info().getNick_name());
        authorizerInfo.setQrcodeUrl(authorizerInfoDetail.getAuthorizer_info().getQrcode_url());
        authorizerInfo.setServiceTypeInfo(authorizerInfoDetail.getAuthorizer_info().getVerify_type_info().getId() == null ? null : authorizerInfoDetail.getAuthorizer_info().getVerify_type_info().getId());
        authorizerInfo.setVerifyTypeInfo(authorizerInfoDetail.getAuthorizer_info().getVerify_type_info().getId() == null ? null : authorizerInfoDetail.getAuthorizer_info().getVerify_type_info().getId());
        authorizerInfo.setUserName(authorizerInfoDetail.getAuthorizer_info().getUser_name());
        authorizerInfo.setAuthorizedTime(current);
        authorizerInfo.setRecordStatus(0);
        return authorizerInfo;
    }

    @Override
    public void updateComponentVerifyTicket(Map<String, String> resultMap) {
        // 每十分钟推送的ComponentVerifyTicket 暂时先放在缓存
        // String appid = resultMap.get("AppId");
        // String createTime = resultMap.get("CreateTime");
        // String infoType = resultMap.get("InfoType");
        String componentVerifyTicket = resultMap.get(WeixinConstant.VERIFYTICKET);
        try {
            if (!StringUtils.isBlank(componentVerifyTicket))
                redisTemplate.opsForValue().set("component_verify_ticket", componentVerifyTicket, 12, TimeUnit.MINUTES);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void doUnauthorizedEvent(Map<String, String> resultMap) {
        String infoType = resultMap.get("InfoType");
        String authorizerAppid = resultMap.get("AuthorizerAppid");
        // 如果是取消授权
        if (infoType.equalsIgnoreCase(WeixinConstant.UNAUTHORIZED)) {
            // 删除授权Token表信息
            authorizationInfoMapper.delete(authorizerAppid);
            // 更新取消授权时间，并且将当前记录recordstatus设1为不可用
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("unauthorizedTime", new Timestamp(System.currentTimeMillis()));
            map.put("unauthorizerAppid", authorizerAppid);
            componentAuthorizerInfoMapper.updateUnauthorizerEvent(map);
            weixinAppService.unAuthorizerUpdate(authorizerAppid);
            // 清空缓存中的授权accessToken
            redisTemplate.opsForValue().set(WeixinConstant.AUTHTOKENPREFIX + authorizerAppid, null, 1,
                                            TimeUnit.MILLISECONDS);
            // TODO 用户进行取消授权，系统通知收到后，相应的注册用户功能也被停止
        }
    }

    /**
     * @param function
     * @return
     * @author lizhihui 2015年9月24日 下午2:42:31
     */
    private StringBuffer parseFuncion(List<Funcion> function) {
        StringBuffer sb = new StringBuffer();
        if (function != null) {
            for (Funcion f : function) {
                sb.append(f.getFuncscope_category().getId() + ",");
            }
        }
        return sb;
    }

    @Override
    public boolean checkSignature(HttpServletRequest request, HttpServletResponse response) {
        // 加密signature
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随即字符串
        String nonce = request.getParameter("nonce");
        String[] tmpArr = { WeixinConstant.TOKEN, timestamp, nonce };
        // 字典排序
        Arrays.sort(tmpArr);
        String tmpStr = WeiXinMessageEncrypt.ArrayToString(tmpArr);
        // SHA1解密
        tmpStr = WeiXinMessageEncrypt.SHA1Encode(tmpStr);
        if (tmpStr.equalsIgnoreCase(signature)) {
            logger.info("checkSignature method is successful!");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        try {
            // 创建SSLContext 对象，并且使用我们指定的任务管理初始化
            TrustManager[] tm = { new TrustAnyTrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext 对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            logger.info("请求URL:   " + requestUrl);
            logger.info("urlInfo:   " + url.getPath());
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);

            // conn.setDoOutput(true);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方法
            conn.setRequestMethod(requestMethod);
            if (!StringUtils.isBlank(outputStr)) {
                logger.error("请求参数 " + outputStr);
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();
            }
            logger.info("请求到输入流");
            // 从输入流读取数据
            InputStream is = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            logger.info("请求返回值" + buffer);
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            is.close();
            conn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (Exception e) {
            logger.error(e);
        }
        return jsonObject;
    }

    /**
     * 重新请求第三方平台AccessToken
     * 
     * @param accessToken
     * @return
     * @author lizhihui 2015年9月28日 下午4:13:38
     */
    private String requestComToken(ComponentAccessToken accessToken) {
        String ticket = (String) redisTemplate.opsForValue().get("component_verify_ticket");
        String url = WeixinConstant.COMPONENTACCESSTOKENURL;
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("component_appid", WeixinConstant.COMPONENTAPPID);
        paramMap.put("component_appsecret", WeixinConstant.COMPONENTAPPSECRET);
        paramMap.put("component_verify_ticket", ticket);
        String parames = JSON.toJSONString(paramMap);
        JSONObject jsonObject = httpsRequest(url, "POST", parames);
        String component_access_token = jsonObject.getString("component_access_token");
        accessToken.setComponentAccessToken(component_access_token);
        return component_access_token;
    }
}
