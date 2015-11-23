/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the confidential and proprietary information
 * of danxiangjie.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with danxiangjie.com.
 */
package com.dxj.wecard.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxj.wecard.model.AuthorizationToken;
import com.dxj.wecard.model.AuthorizerInfo;
import com.dxj.wecard.weixin.component.model.ComponentAccessToken;

import net.sf.json.JSONObject;

/**
 * 第三方平台相关接口 类ComponentWeixinService.java的实现描述：TODO 类实现描述
 * 
 * @author lizhihui 2015年9月23日 下午1:42:05
 */
public interface WeixinComponentService {
    
    /**
     * 处理微信公众号的消息事件
     * 卡券审核通过，领取，核销，删除
     * @param resultMap
     * @author liulihai 2015年10月13日 下午2:34:41
     */
    public void doWeixinBizPushEvent(Map<String, String> resultMap);
    /**
     * 处理微信微卡券平台授权事件 
     * 
     * 授权事件，取消授权事件，以及每十分钟的ticket
     * @param resultMap
     * @author liulihai 2015年10月13日 下午2:26:31
     */
    public void doComponentPushEvent(Map<String, String> resultMap);
    /**
     * 验证微信推送消息 校验作用
     * @param request
     * @param response
     * @return
     * @author liulihai 2015年10月13日 下午2:23:27
     */
    public boolean checkSignature(HttpServletRequest request, HttpServletResponse response);

    /**
     * 獲得第三方平台AccessToken
     * 
     * @param componentAppid 第三方平臺appid
     * @param componentAppsecret 第三方平臺Appsecret
     * @param omponentVerifyTicket 微信每十分推送的ticket
     * @return
     * @author lizhihui 2015年9月23日 下午1:51:38
     */
    public ComponentAccessToken getConponentAccessToken();

    /**
     * 获取预授权码 该API用于获取预授权码。预授权码用于公众号授权时的第三方平台方安全验证。
     * 
     * @param componentAppid
     * @param componentAccessToken
     * @return
     * @author lizhihui 2015年9月23日 下午2:01:27
     */
    public String getPreauthCode(String componentAppid, String componentAccessToken);

    /**
     * 使用授权码换取公众号的授权信息 该API用于使用授权码换取授权公众号的授权信息， 并换取authorizer_access_token和authorizer_refresh_token。
     * 授权码的获取，需要在用户在第三方平台授权页中完成授权流程后， 在回调URI中通过URL参数提供给第三方平台方。
     * 
     * @param componentAppid
     * @param authorizationCode 授权code,会在授权成功时返回给第三方平台，详见第三方平台授权流程说明
     * @return
     * @author lizhihui 2015年9月23日 下午2:10:26
     */
    public AuthorizerInfo getAuthInfo(String authorizationCode, String componentAccessToken);

    /**
     * 获取（刷新）授权公众号的令牌
     * 
     * @param authorizerAppid 授权方appid
     * @return
     * @author lizhihui 2015年9月23日 下午2:15:10
     */
    public AuthorizationToken refreshAuthorizationToken(String authorizerAppid);

    /**
     * 获取授权方的账户信息
     * 
     * @param component_appid 第三方平台appid
     * @param auth_appid_value 授权方appid
     * @return
     * @author lizhihui 2015年9月23日 下午2:18:16
     */
    public AuthorizerInfo getAuthorizerInfoDetail(String component_appid, String auth_appid_value,
                                                  String componentAccessToken);

    /**
     * 保存componentVerifyTicket
     * 
     * @param resultMap 解密后封装的Map
     * @return
     * @author lizhihui 2015年9月23日 下午2:22:40
     */
    public void updateComponentVerifyTicket(Map<String, String> resultMap);

    /**
     * 授权方取消授权通知
     * 
     * @param resultMap
     * @author liulihai 2015年10月8日 上午9:59:53
     */
    public void doUnauthorizedEvent(Map<String, String> resultMap);

    /**
     * HTTPS 請求，调微信接口使用
     * 
     * @param requestUrl
     * @param requestMethod
     * @param outputStr
     * @return
     * @author liulihai 2015年10月8日 上午11:25:39
     */
    public JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr);
    
    /**
     * 授权公众号AccessToken，调用接口的需要使用
     * @param authorizerAppid   授权方appid
     * @return
     * @author liulihai 2015年10月8日 上午11:28:11
     */
    public String getAuthorizerdAccessToken(String authorizerAppid);

}
