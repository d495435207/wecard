package com.dxj.wecard.card.dto;

import java.util.Date;

public class CardCoupon {
	private Long id;
	private Long mid;	//商户mid
	private String wClogo;
	private String wCname;
	private String cardId;	//卡券id（微信返回）
	private String cardType;	//卡券类型
	private String color;	//券颜色(微信定义)
	private String colorStr;	//券颜色
	private Integer discount;	//折扣额度
	private Integer reduceCost;	//减免金额
	private Integer leastCost;	//抵扣条件
	private String title;	//券标题
	private String subTitle;	//副标题
	private Integer dateType;	//有效期类型 1-固定日期区间	2-固定时长
	private Date beginTime;	//开始时间戳
	private Date endTime;	//结束时间戳
	private Integer fixedTerm;	//起效日期
	private Integer fixedBeginTerm;	//有效天数
	private Integer quantity;	//库存
	private Integer totalQuantity;
	private Integer used;		//使用数
	private Integer get;		//领取数
	private Integer getLimit;	//领券限制，每人最大领取次数
	private Integer isShare;	//可分享
	private Integer isGiveFriend;	//可转赠
	private String codeType;	//卡券消券code展示类型
	private String notice;	//操作提示
	private String detail;	//优惠详情
	private String description;	//使用须知
	private String servicePhone;	//客服电话
	private String locationIdList;	//门店
	private String notes;	//无门店缘由
	private String status;	//卡券状态 
	private String source;	//第三方来源名
	private String customUrlName;	//商 户 自 定 义 cell 名 称 ， 与	custom_url 字段共同使用
	private String customUrl;	//商户自定义 cell 跳转外链的地址链接,跳转页面内容需与自定义	cell 名称保持一致
	
	private String customUrlSubTitle;
	
	private String promotionUrlName;
	
	private String promotionUrl;
	
	private String promotionUrlSubTitle;
	
	private Date createTime;
	private Date modifyTime;
	private String timestamp;	//时间戳（秒数）
	private String signature;	//签名， 签名方式使用SHA1
	private String merchantLogo;//商家LOGO
	private String merchantName;//卡券商家名称
	private String appId;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getMid() {
        return mid;
    }
    
    public void setMid(Long mid) {
        this.mid = mid;
    }
    
    public String getCardId() {
        return cardId;
    }
    
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
    
    public String getCardType() {
        return cardType;
    }
    
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColorStr() {
        return colorStr;
    }
    
    public void setColorStr(String colorStr) {
        this.colorStr = colorStr;
    }
    
    public Integer getDiscount() {
        return discount;
    }
    
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
    
    public Integer getReduceCost() {
        return reduceCost;
    }
    
    public void setReduceCost(Integer reduceCost) {
        this.reduceCost = reduceCost;
    }
    
    public Integer getLeastCost() {
        return leastCost;
    }
    
    public void setLeastCost(Integer leastCost) {
        this.leastCost = leastCost;
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
    
    
    public Date getBeginTime() {
        return beginTime;
    }
    
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public Integer getFixedTerm() {
        return fixedTerm;
    }
    
    public void setFixedTerm(Integer fixedTerm) {
        this.fixedTerm = fixedTerm;
    }
    
    public Integer getFixedBeginTerm() {
        return fixedBeginTerm;
    }
    
    public void setFixedBeginTerm(Integer fixedBeginTerm) {
        this.fixedBeginTerm = fixedBeginTerm;
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
    
    public Integer getUsed() {
        return used;
    }
    
    public void setUsed(Integer used) {
        this.used = used;
    }
    
    public Integer getGet() {
        return get;
    }
    
    public void setGet(Integer get) {
        this.get = get;
    }
    
    public Integer getGetLimit() {
        return getLimit;
    }
    
    public void setGetLimit(Integer getLimit) {
        this.getLimit = getLimit;
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
    
    public String getCodeType() {
        return codeType;
    }
    
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }
    
    public String getNotice() {
        return notice;
    }
    
    public void setNotice(String notice) {
        this.notice = notice;
    }
    
    public String getDetail() {
        return detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getServicePhone() {
        return servicePhone;
    }
    
    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }
    
    public String getLocationIdList() {
        return locationIdList;
    }
    
    public void setLocationIdList(String locationIdList) {
        this.locationIdList = locationIdList;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public Integer getDateType() {
        return dateType;
    }

    
    public void setDateType(Integer dateType) {
        this.dateType = dateType;
    }

    public String getSource() {
        return source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    
    public String getCustomUrlName() {
        return customUrlName;
    }
    
    public void setCustomUrlName(String customUrlName) {
        this.customUrlName = customUrlName;
    }
    
    public String getCustomUrl() {
        return customUrl;
    }
    
    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }
    
    public String getCustomUrlSubTitle() {
        return customUrlSubTitle;
    }
    
    public void setCustomUrlSubTitle(String customUrlSubTitle) {
        this.customUrlSubTitle = customUrlSubTitle;
    }
    
    public String getPromotionUrlName() {
        return promotionUrlName;
    }
    
    public void setPromotionUrlName(String promotionUrlName) {
        this.promotionUrlName = promotionUrlName;
    }
    
    public String getPromotionUrl() {
        return promotionUrl;
    }
    
    public void setPromotionUrl(String promotionUrl) {
        this.promotionUrl = promotionUrl;
    }
    
    public String getPromotionUrlSubTitle() {
        return promotionUrlSubTitle;
    }
    
    public void setPromotionUrlSubTitle(String promotionUrlSubTitle) {
        this.promotionUrlSubTitle = promotionUrlSubTitle;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getModifyTime() {
        return modifyTime;
    }
    
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getSignature() {
        return signature;
    }
    
    public void setSignature(String signature) {
        this.signature = signature;
    }
    
    public String getMerchantLogo() {
        return merchantLogo;
    }
    
    public void setMerchantLogo(String merchantLogo) {
        this.merchantLogo = merchantLogo;
    }
    
    public String getMerchantName() {
        return merchantName;
    }
    
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
    
    public String getAppId() {
        return appId;
    }
    
    public void setAppId(String appId) {
        this.appId = appId;
    }

    
    public String getwClogo() {
        return wClogo;
    }

    
    public void setwClogo(String wClogo) {
        this.wClogo = wClogo;
    }

    
    public String getwCname() {
        return wCname;
    }

    
    public void setwCname(String wCname) {
        this.wCname = wCname;
    }
	
	
}
