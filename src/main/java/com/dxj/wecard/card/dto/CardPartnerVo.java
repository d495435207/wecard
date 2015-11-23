/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.card.dto;

/**
 * 类CardPanterVo.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年10月14日 下午1:48:43
 */
public class CardPartnerVo {
    /**
     * 卡劵id
     * @mbggenerated
     */
    private Integer id;
    /**
     * 微信appid
     * @mbggenerated
     */
    private String appId;
    /**
     * 微信返回cardid
     * @mbggenerated
     */
    private String cardId;
    /**
     * 卡劵分类
     * @mbggenerated
     */
    private String categories;
    /**
     * 卡劵状态，2 为下架、1为上架，3为无效
     * @mbggenerated
     */
    private Integer cardStatus;
    /**
     * 卡券现有库存的数量
     * @mbggenerated
     */
    private Integer quantity;
    /**
     * 卡券全部库存的数量
     * @mbggenerated
     */
    private Integer totalQuantity;
    /**
     * 单价金额（单位为分）
     * @mbggenerated
     */
    private Integer cost;
    /**
     * 卡券类型
     * @mbggenerated
     */
    private String cardType;
    /**
     * 卡券名
     * @mbggenerated
     */
    private String title;
    /**
     * 券名
     * @mbggenerated
     */
    private String subTitle;
    /**
     * 券颜色
     * @mbggenerated
     */
    private String color;
    /**
     * 使用日期，有效期的信息
     * @mbggenerated
     */
    private String dateInfo;
    /**
     * 领取数
     * @mbggenerated
     */
    private Integer receiveCnt;
    /**
     * 领取人数
     * @mbggenerated
     */
    private Integer receiveUser;
    /**
     * 核销数
     * @mbggenerated
     */
    private Integer verifyCnt;
    /**
     * 浏览数
     * @mbggenerated
     */
    private Integer viewCnt;
    /**
     * 每人可领券的数量限制,不填写默认为50。
     * @mbggenerated
     */
    private Integer getLimit;
    /**
     * 是否自定义Code码，0未非自定义，1为自定
     * @mbggenerated
     */
    private Integer isCustomCode;
    /**
     * 是否指定用户领取，0未非指定义，1为指定
     * @mbggenerated
     */
    private Integer isBindOpenid;
    /**
     * 卡券领取页面是否可分享，0不能分享，1能分享
     * @mbggenerated
     */
    private Integer isShare;
    /**
     * 卡券是否可转赠，0不能转赠，1能转赠
     * @mbggenerated
     */
    private Integer isGiveFriend;
    /**
     * 门店类型，0为全国门店适用、1为无指定门店，2为指定门店
     * @mbggenerated
     */
    private Integer branchType;
    /**
     * 有效期类型，0表示固定日期区间，1表示固定时长
     * @mbggenerated
     */
    private Integer dateType;
    /**
     * code展示类型
     * @mbggenerated
     */
    private String codeType;
    /**
     * 微信卡劵状态
     * @mbggenerated
     */
    private String status;
    /**
     * 第三方来源名
     * @mbggenerated
     */
    private String source;
    /**
     * 卡券来源，0为公众平台创建的卡券数据、1是API创建的卡券数据
     * @mbggenerated
     */
    private Integer condSource;
    /**
     * @mbggenerated
     * 
     */
    private Integer recordStatus;
    
    //分成比例
    private Integer shareRate;

    
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getAppId() {
        return appId;
    }

    
    public void setAppId(String appId) {
        this.appId = appId;
    }

    
    public String getCardId() {
        return cardId;
    }

    
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    
    public String getCategories() {
        return categories;
    }

    
    public void setCategories(String categories) {
        this.categories = categories;
    }

    
    public Integer getCardStatus() {
        return cardStatus;
    }

    
    public void setCardStatus(Integer cardStatus) {
        this.cardStatus = cardStatus;
    }

    
    public Integer getQuantity() {
        return quantity;
    }

    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    
    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    
    public Integer getCost() {
        return cost;
    }

    
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    
    public String getCardType() {
        return cardType;
    }

    
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    
    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getSubTitle() {
        return subTitle;
    }

    
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    
    public String getColor() {
        return color;
    }

    
    public void setColor(String color) {
        this.color = color;
    }

    
    public String getDateInfo() {
        return dateInfo;
    }

    
    public void setDateInfo(String dateInfo) {
        this.dateInfo = dateInfo;
    }

    
    public Integer getReceiveCnt() {
        return receiveCnt;
    }

    
    public void setReceiveCnt(Integer receiveCnt) {
        this.receiveCnt = receiveCnt;
    }

    
    public Integer getReceiveUser() {
        return receiveUser;
    }

    
    public void setReceiveUser(Integer receiveUser) {
        this.receiveUser = receiveUser;
    }

    
    public Integer getVerifyCnt() {
        return verifyCnt;
    }

    
    public void setVerifyCnt(Integer verifyCnt) {
        this.verifyCnt = verifyCnt;
    }

    
    public Integer getViewCnt() {
        return viewCnt;
    }

    
    public void setViewCnt(Integer viewCnt) {
        this.viewCnt = viewCnt;
    }

    
    public Integer getGetLimit() {
        return getLimit;
    }

    
    public void setGetLimit(Integer getLimit) {
        this.getLimit = getLimit;
    }

    
    public Integer getIsCustomCode() {
        return isCustomCode;
    }

    
    public void setIsCustomCode(Integer isCustomCode) {
        this.isCustomCode = isCustomCode;
    }

    
    public Integer getIsBindOpenid() {
        return isBindOpenid;
    }

    
    public void setIsBindOpenid(Integer isBindOpenid) {
        this.isBindOpenid = isBindOpenid;
    }

    
    public Integer getIsShare() {
        return isShare;
    }

    
    public void setIsShare(Integer isShare) {
        this.isShare = isShare;
    }

    
    public Integer getIsGiveFriend() {
        return isGiveFriend;
    }

    
    public void setIsGiveFriend(Integer isGiveFriend) {
        this.isGiveFriend = isGiveFriend;
    }

    
    public Integer getBranchType() {
        return branchType;
    }

    
    public void setBranchType(Integer branchType) {
        this.branchType = branchType;
    }

    
    public Integer getDateType() {
        return dateType;
    }

    
    public void setDateType(Integer dateType) {
        this.dateType = dateType;
    }

    
    public String getCodeType() {
        return codeType;
    }

    
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    
    public String getStatus() {
        return status;
    }

    
    public void setStatus(String status) {
        this.status = status;
    }

    
    public String getSource() {
        return source;
    }

    
    public void setSource(String source) {
        this.source = source;
    }

    
    public Integer getCondSource() {
        return condSource;
    }

    
    public void setCondSource(Integer condSource) {
        this.condSource = condSource;
    }

    
    public Integer getRecordStatus() {
        return recordStatus;
    }

    
    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    
    public Integer getShareRate() {
        return shareRate;
    }

    
    public void setShareRate(Integer shareRate) {
        this.shareRate = shareRate;
    }
    
}
