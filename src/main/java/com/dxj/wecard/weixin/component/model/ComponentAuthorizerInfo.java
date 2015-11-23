/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.weixin.component.model;

import java.io.Serializable;

/**
 * 类ComponentAuthorizerInfoDetail.java的实现描述：TODO 类实现描述 
 * @author lizhihui 2015年9月23日 上午10:11:39
 */
public class ComponentAuthorizerInfo implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String nickName;
    
    private String headImg;
    
    //授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
    private Integer serviceTypeInfo;
    
    //授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，
    //2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，
    //4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，
    //5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
    private Integer verifyTypeInfo;
    
    //授权方公众号的原始ID
    private String userName;
    
    //授权方公众号所设置的微信号，可能为空
    private String alias;
    
    //  二维码图片的URL，开发者最好自行也进行保存
    private String  qrcodeUrl;
    
    //授权方appid
    private String appId;
    
    //公众号授权给开发者的权限集列表
    private String funcInfo;

    
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getNickName() {
        return nickName;
    }

    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    
    public String getHeadImg() {
        return headImg;
    }

    
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    
    public Integer getServiceTypeInfo() {
        return serviceTypeInfo;
    }

    
    public void setServiceTypeInfo(Integer serviceTypeInfo) {
        this.serviceTypeInfo = serviceTypeInfo;
    }

    
    public Integer getVerifyTypeInfo() {
        return verifyTypeInfo;
    }

    
    public void setVerifyTypeInfo(Integer verifyTypeInfo) {
        this.verifyTypeInfo = verifyTypeInfo;
    }

    
    public String getUserName() {
        return userName;
    }

    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    public String getAlias() {
        return alias;
    }

    
    public void setAlias(String alias) {
        this.alias = alias;
    }

    
    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    
    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    
    public String getAppId() {
        return appId;
    }

    
    public void setAppId(String appId) {
        this.appId = appId;
    }

    
    public String getFuncInfo() {
        return funcInfo;
    }

    
    public void setFuncInfo(String funcInfo) {
        this.funcInfo = funcInfo;
    }

    
}
