/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.weixin.component.model;

import java.sql.Timestamp;

/**
 * 类ComponentAuthorizerEvent.java的实现描述：TODO 类实现描述 
 * @author lizhihui 2015年9月23日 上午10:28:02
 */
public class AuthorizerEvent {
    //第三方平台appid
    private String appid;
    //时间戳
    private Timestamp createTime;
    private String infoType;
    //取消授权的公众号
    private String authorizerAppid;
    
    public String getAppid() {
        return appid;
    }
    
    public void setAppid(String appid) {
        this.appid = appid;
    }
    
    public Timestamp getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    
    public String getInfoType() {
        return infoType;
    }
    
    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }
    
    public String getAuthorizerAppid() {
        return authorizerAppid;
    }
    
    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }
    
}
