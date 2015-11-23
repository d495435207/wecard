/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.weixin.util;


/**
 * 存放接口地址和全局变量
 * @author lizhihui 2015年9月23日 下午3:11:39
 */
public class WeixinConstant {
    public static String TOKEN="5BVUPvEvc8";
    
    public static String KEY="nTpqSFE5KPpXLKv8IrEh2oITf9Tqv5TP8BgWPperoCM";
    /**
     * 第三方平台appid 常量
     */
    public  static String COMPONENTAPPID="wxda2fb37cdf205a8c";
    /**
     * 第三方平台appidsecret 常量
     */
    public  static String COMPONENTAPPSECRET="0c79e1fa963cd80cc0be99b20a18faeb";
    
    /**
     * 每十分钟推送ticket事件名称
     */
    public static String VERIFYTICKET ="ComponentVerifyTicket";
    
    /**
     * 用户领取卡券
     */
    public static String USEGETCARD="user_get_card";
    /**
     * 用户删除卡券
     */
    public static String USEDELCARD="user_del_card";
    /**
     * 用户核销卡券
     */
    public static String USECONSUMECARD="user_consume_card";
    /**
     * 公众号取消授权事件名称
     */
    public static String UNAUTHORIZED="unauthorized";
    
    public static String USEGETCARDQUENENAME="getcardtopic_";
    
    public static String USECONSUMECARDQUENENAME="consumecardtopic_";
    /**
     * Redis保存授权公众号AccessToken  key 前缀
     */
    public static String AUTHTOKENPREFIX="authorized_token_";
    /**
     * 该API用于获取第三方平台令牌（component_access_token）
     */
    public  static String COMPONENTACCESSTOKENURL="https://api.weixin.qq.com/cgi-bin/component/api_component_token";
    
    /**
     * 该API用于获取预授权码。预授权码用于公众号授权时的第三方平台方安全验证。
     */
    public  static String PREAUTHCODE="https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=ACCESSTOKEN";
    
    /**
     * 使用授权码换取公众号的授权信息
     */
    public  static String AUTHINOAPI="https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=ACCESSTOKEN";
    
    /**
     * 获取（刷新）授权公众号的令牌
     * 该API用于在授权方令牌（authorizer_access_token）失效时，
     * 可用刷新令牌（authorizer_refresh_token）获取新的令牌。
     */
    public  static String REFRESHTOKENAPI="https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=ACCESSTOKEN";
    
    /**
     * 获取授权方的账户信息
     * 该API用于获取授权方的公众号基本信息，包括头像、昵称、帐号类型、认证类型、微信号、原始ID和二维码图片URL。
     */
    public  static String GETAUTHORIZERINFO="https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token=ACCESSTOKEN";
    /**
     * 获取门店信息（老接口）
     */
    public static String BATCHPOIGET = "https://api.weixin.qq.com/card/location/batchget?access_token=ACCESSTOKEN";
    
    public static String GETPOILIST="https://api.weixin.qq.com/cgi-bin/poi/getpoilist?access_token=ACCESSTOKEN";
}

