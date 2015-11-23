/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.weixin.component.model;


/**
 * 
 * 类AuthorizerRefreshToken.java的实现描述：TODO 类实现描述 
 * @author lizhihui 2015年9月23日 上午10:02:28
 */
public class AuthorizerRefreshToken {
    
    //第三方平台appid
    private String component_appid;
    
    //授权方appid
    private String authorizer_appid;
    
    //授权方的刷新令牌，刷新令牌主要用于公众号第三方平台获取和刷新已授权用户的access_token，
    //只会在授权时刻提供，请妥善保存。 一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌
    private String authorizer_refresh_token;

    
    public String getComponent_appid() {
        return component_appid;
    }

    
    public void setComponent_appid(String component_appid) {
        this.component_appid = component_appid;
    }

    
    public String getAuthorizer_appid() {
        return authorizer_appid;
    }

    
    public void setAuthorizer_appid(String authorizer_appid) {
        this.authorizer_appid = authorizer_appid;
    }

    
    public String getAuthorizer_refresh_token() {
        return authorizer_refresh_token;
    }

    
    public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
        this.authorizer_refresh_token = authorizer_refresh_token;
    }
    
}
