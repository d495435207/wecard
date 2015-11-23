/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 类ComponentAuthorizerInfoDetail.java的实现描述：TODO 类实现描述 
 * @author lizhihui 2015年9月23日 上午10:11:39
 */
public class AuthorizerInfo implements Serializable{

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
    private String alisa;
    
    //  二维码图片的URL，开发者最好自行也进行保存
    private String  qrcodeUrl;
    
    //授权方appid
    private String appId;
    
    //公众号授权给开发者的权限集列表
    private String funcInfo;
    
    //授权时间
    private Timestamp authorizedTime;
    
    //取消授权时间
    private Timestamp unauthorizedTime;
    
    //开通微信功能0为未开通1已开通
    private Integer openPay;
    private Integer openShake;
    private Integer openScan;
    private Integer openCard;
    private Integer openStore;
    
    
    
    //记录有效标示0有效，1无效
    private Integer recordStatus;
    
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


    
    
    public String getAlisa() {
        return alisa;
    }


    
    public void setAlisa(String alisa) {
        this.alisa = alisa;
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


    
    public Timestamp getAuthorizedTime() {
        return authorizedTime;
    }


    
    public void setAuthorizedTime(Timestamp authorizedTime) {
        this.authorizedTime = authorizedTime;
    }


    
    public Timestamp getUnauthorizedTime() {
        return unauthorizedTime;
    }


    
    public void setUnauthorizedTime(Timestamp unauthorizedTime) {
        this.unauthorizedTime = unauthorizedTime;
    }


    
    public Integer getRecordStatus() {
        return recordStatus;
    }


    
    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }


    
    public Integer getOpenPay() {
        return openPay;
    }


    
    public void setOpenPay(Integer openPay) {
        this.openPay = openPay;
    }


    
    public Integer getOpenShake() {
        return openShake;
    }


    
    public void setOpenShake(Integer openShake) {
        this.openShake = openShake;
    }


    
    public Integer getOpenScan() {
        return openScan;
    }


    
    public void setOpenScan(Integer openScan) {
        this.openScan = openScan;
    }


    
    public Integer getOpenCard() {
        return openCard;
    }


    
    public void setOpenCard(Integer openCard) {
        this.openCard = openCard;
    }


    
    public Integer getOpenStore() {
        return openStore;
    }


    
    public void setOpenStore(Integer openStore) {
        this.openStore = openStore;
    }


    
   
    
}
