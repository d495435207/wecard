/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the confidential and proprietary information
 * of danxiangjie.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with danxiangjie.com.
 */
package com.dxj.wecard.weixin.component.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 类ComponentVerifyTicket.java
 * 
 * 
 *  推送component_verify_ticket协议
    在公众号第三方平台创建审核通过后，
    微信服务器会向其“授权事件接收URL”每隔10分钟定时推送component_verify_ticket。
    第三方平台方在收到ticket推送后也需进行解密（详细请见【消息加解密接入指引】），
    接收到后必须直接返回字符串success。
 * 
 * @author lizhihui 2015年9月23日 上午9:37:11
 */
public class ComponentVerifyTicket implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Integer   id;
    // 第三方平台appid
    private String    appid;
    // Ticket内容     可以类似之前的accessToken
    private String    componentVerifyTicket;
    //时间戳
    private Timestamp createTime;
    //推送消息内容component_verify_ticket
    private String    infoType;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getAppid() {
        return appid;
    }
    
    public void setAppid(String appid) {
        this.appid = appid;
    }
    
    public String getComponentVerifyTicket() {
        return componentVerifyTicket;
    }
    
    public void setComponentVerifyTicket(String componentVerifyTicket) {
        this.componentVerifyTicket = componentVerifyTicket;
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
    
}
