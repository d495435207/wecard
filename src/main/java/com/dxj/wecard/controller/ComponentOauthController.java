/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.model.AuthorizerInfo;
import com.dxj.wecard.model.Partner;
import com.dxj.wecard.model.User;
import com.dxj.wecard.model.WeixinApp;
import com.dxj.wecard.service.ReceiveService;
import com.dxj.wecard.service.TopicSendService;
import com.dxj.wecard.service.UserPartnerService;
import com.dxj.wecard.service.UserService;
import com.dxj.wecard.service.VerifyService;
import com.dxj.wecard.service.WeixinAppService;
import com.dxj.wecard.service.WeixinComponentService;
import com.dxj.wecard.weixin.component.model.ComponentAccessToken;
import com.dxj.wecard.weixin.qq.aes.WXBizMsgCrypt;
import com.dxj.wecard.weixin.util.WeixinConstant;
import com.dxj.wecard.weixin.util.WeixinMessageParse;
import com.dxj.wecard.weixin.util.WeixinXmlUtils;

/**
 * 类ConponentOauthController.java的实现描述：TODO 类实现描述 
 * @author lizhihui 2015年9月23日 上午10:45:58
 */
@Controller
@RequestMapping("/")
public class ComponentOauthController extends BaseController{
    static final Logger logger = LogManager.getLogger(ComponentOauthController.class);
    
    @Autowired
    private WeixinComponentService weixinComponentService;
    @Autowired
    private UserPartnerService userPartnerService;
    @Autowired
    private WeixinAppService weixinAppService;
    @Autowired
    private UserService userService;
    @Autowired
    private VerifyService verifyService;
    @Autowired
    private ReceiveService receiveService;
    @Autowired
    private TopicSendService topicSendService;
    /**
     * 网页授权跳转入口页
     * @param request
     * @param response
     * @return
     * @author liulihai 2015年9月30日 下午2:32:49
     */
    @RequestMapping(value = "/wechatOAuth", method = { RequestMethod.GET })
    public ModelAndView wechatOAuth(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        ComponentAccessToken access =weixinComponentService.getConponentAccessToken();
        String  preoauthcode=weixinComponentService.getPreauthCode(WeixinConstant.COMPONENTAPPID, access.getComponentAccessToken());
        HttpSession session = request.getSession();
        String userId=(String)session.getAttribute("userId");
        logger.info("precode" + preoauthcode);
        String url = "";
        if (!StringUtils.isBlank(preoauthcode)) {
            url = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=wxda2fb37cdf205a8c&pre_auth_code="
                  + preoauthcode + "&redirect_uri=http%3A%2F%2Fwecard-test.chaolink.com%2FwechatOAuthRe.html?userId="+userId+"";
        }
        
        return new ModelAndView(new RedirectView(url));
    }
    /**
     * 授权成功会进入回调页面，返回授权码
     * @param request
     * @param response
     * @return
     * @author liulihai 2015年10月8日 下午5:29:49
     */
    @RequestMapping(value = "/wechatOAuthRe", method = { RequestMethod.GET })
    public String wechatOAuthRe(HttpServletRequest request, HttpServletResponse response) {
        String authCode = request.getParameter("auth_code");
        ComponentAccessToken access = weixinComponentService.getConponentAccessToken();
        AuthorizerInfo token = null;
        if (!StringUtils.isBlank(authCode)) {
            token = weixinComponentService.getAuthInfo(authCode, access.getComponentAccessToken());
        }
        String userId=request.getParameter("userId");
        User user = userService.getById(userId);
        if (user == null) return "redirect:/login.do";
        Partner partner=null;
        if(user.getIsAdmin() == 0) {
            partner= userPartnerService.getPartnerByUser(user.getId());
        }
        WeixinApp weixinuser = weixinAppService.getById(token.getAppId());
        logger.info("weixinapp" + weixinuser);
        if (weixinuser == null && token!=null) {
            weixinAppService.saveAuth(token,partner);
        } else {
            weixinuser.setIsAuth(1);
            // 1 代表已经授权
            weixinAppService.update(weixinuser);
        }
        return "redirect:/publisher/index.do";
    }
    /**
     * 授权消息事件
     * @param request
     * @param response
     * @throws Exception
     * @author lizhihui 2015年9月25日 上午9:15:35
     */
    @RequestMapping(value = "/wechatRe", method = { RequestMethod.POST })
    public void wechatRe(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
//        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String msgSingature=request.getParameter("msg_signature");
        try {
            //微信加密加密
            WXBizMsgCrypt pc = new WXBizMsgCrypt(WeixinConstant.TOKEN, WeixinConstant.KEY, WeixinConstant.COMPONENTAPPID);
            String encrxml=WeixinXmlUtils.getStrFromInputSteam(request.getInputStream());
            String reqult=pc.decryptMsg(msgSingature, timestamp, nonce, encrxml);
            logger.info("解密后的Result"+reqult);
            Map<String, String> resultMap=WeixinXmlUtils.parseXmlFromStr(reqult);
            weixinComponentService.doComponentPushEvent(resultMap);
            out.print("success");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 公众号消息与事件接收URL：
     * 该URL用于接收已授权公众号的消息和事件，消息内容、消息格式、签名方式、加密方式与普通公众号接收的一致，
     * 唯一区别在于签名token和加密symmetric_key使用的是服务方申请时所填写的信息。
     * 由于消息具体内容不会变更，故根据消息内容里的ToUserName，服务方是可以区分出具体消息所属的公众号。
     * 另外，考虑到服务需要接收大量的授权公众号的消息，为了便于做业务分流和业务隔离，
     * 必须提供如下形式的url：www.abc.com/aaa/$APPID$/bbb/cgi，
     * 其中$APPID$在实际推送时会替换成所属的已授权公众号的appid。
     * 
     * http://yun-test.chaolink.com/callback.html?appid=/$APPID$
     * @param request
     * @param response
     * @return
     * @author lizhihui 2015年9月25日 上午9:16:06
     * @throws Exception 
     */
    @RequestMapping(value = "/callback", method = { RequestMethod.POST })
    public void callback(HttpServletRequest request, HttpServletResponse response) throws Exception {
       // http://yun-test.chaolink.com/callback.html?appid=/$APPID$
        String appid=request.getParameter("appid");
        appid= appid.replace("/", "");
        logger.info("公众号消息与事件接收来自appid："+appid);
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
//        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String msgSingature=request.getParameter("msg_signature");
        try {
            WXBizMsgCrypt pc = new WXBizMsgCrypt(WeixinConstant.TOKEN, WeixinConstant.KEY, WeixinConstant.COMPONENTAPPID);
            String encrxml=WeixinXmlUtils.getStrFromInputSteam(request.getInputStream());
            String reqult=pc.decryptMsg(msgSingature, timestamp, nonce, encrxml);
            logger.info("WechatManager解密后的Result"+reqult);
            sendMessage(request, response, appid, out, reqult);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
    /**
     * @param request
     * @param response
     * @param appid
     * @param out
     * @param reqult
     * @throws Exception
     * @author liulihai 2015年10月13日 下午3:45:33
     */
    private void sendMessage(HttpServletRequest request, HttpServletResponse response, String appid, PrintWriter out,
                             String reqult) throws Exception {
        if (weixinComponentService.checkSignature(request, response)) {
            //将消息解析成JSON
            Map<String, String> requestMap = WeixinXmlUtils.parseXmlFromStr(reqult);
            //识别是谁的公众号
            requestMap.put("appid", appid);
            String eventType = requestMap.get("Event");
            //用户领取卡券-发送消息
            if(WeixinConstant.USEGETCARD.equalsIgnoreCase(eventType)){
                topicSendService.send(WeixinConstant.USEGETCARDQUENENAME+appid, JSON.toJSONString(requestMap));
                receiveService.userGetCardSave(requestMap);
            }
            //用户核销卡券-发送消息
            if(WeixinConstant.USECONSUMECARD.equalsIgnoreCase(eventType)){
                topicSendService.send(WeixinConstant.USECONSUMECARDQUENENAME+appid,JSON.toJSONString(requestMap));
                verifyService.userConsumeCard(requestMap);
            }
            if(WeixinConstant.USEDELCARD.equalsIgnoreCase(eventType)){
                verifyService.userConsumeCard(requestMap);
            }
            //给微信返回回应success
            out.print("success");
        }
    }
    
}
