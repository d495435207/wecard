package com.dxj.wecard.model;

import java.io.Serializable;
import java.util.Date;

public class CardMore implements Serializable {

	/**
	 * 卡劵id
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * 有效期起用时间
	 * @mbggenerated
	 */
	private Date beginTime;
	/**
	 * 有效期结束时间
	 * @mbggenerated
	 */
	private Date endTime;
	/**
	 * 自领取后多少天内有效
	 * @mbggenerated
	 */
	private Integer fixedTerm;
	/**
	 * 自领取后多少天开始生效
	 * @mbggenerated
	 */
	private Integer fixedBeginTerm;
	/**
	 * 代金券专用，表示起用金额（单位为分）
	 * @mbggenerated
	 */
	private Integer leastCost;
	/**
	 * 代金券专用，表示减免金额（单位为分）
	 * @mbggenerated
	 */
	private Integer reduceCost;
	/**
	 * 折扣券专用，表示打折额度（百分比）
	 * @mbggenerated
	 */
	private Integer discount;
	/**
	 * 使用提醒
	 * @mbggenerated
	 */
	private String notice;
	/**
	 * 客服电话
	 * @mbggenerated
	 */
	private String servicePhone;
	/**
	 * 自定义跳转外链的入口名字
	 * @mbggenerated
	 */
	private String customUrlName;
	/**
	 * 自定义跳转的URL
	 * @mbggenerated
	 */
	private String customUrl;
	/**
	 * 显示在入口右侧的提示语
	 * @mbggenerated
	 */
	private String customUrlSubTitle;
	/**
	 * 营销场景的自定义入口名称
	 * @mbggenerated
	 */
	private String promotionUrlName;
	/**
	 * 入口跳转外链的地址链接
	 * @mbggenerated
	 */
	private String promotionUrl;
	/**
	 * 显示在营销入口右侧的提示语
	 * @mbggenerated
	 */
	private String promotionUrlSubTitle;
	/**
	 * 卡券使用说明
	 * @mbggenerated
	 */
	private String description;
	/**
	 * 优惠详情
	 * @mbggenerated
	 */
	private String detail;
	/**
	 * location_id_list
	 */
	private String locationIdList;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of card_more.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id  the value for card_more.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return  the value of card_more.begin_time
	 * @mbggenerated
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * @param beginTime  the value for card_more.begin_time
	 * @mbggenerated
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * @return  the value of card_more.end_time
	 * @mbggenerated
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime  the value for card_more.end_time
	 * @mbggenerated
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return  the value of card_more.fixed_term
	 * @mbggenerated
	 */
	public Integer getFixedTerm() {
		return fixedTerm;
	}

	/**
	 * @param fixedTerm  the value for card_more.fixed_term
	 * @mbggenerated
	 */
	public void setFixedTerm(Integer fixedTerm) {
		this.fixedTerm = fixedTerm;
	}

	/**
	 * @return  the value of card_more.fixed_begin_term
	 * @mbggenerated
	 */
	public Integer getFixedBeginTerm() {
		return fixedBeginTerm;
	}

	/**
	 * @param fixedBeginTerm  the value for card_more.fixed_begin_term
	 * @mbggenerated
	 */
	public void setFixedBeginTerm(Integer fixedBeginTerm) {
		this.fixedBeginTerm = fixedBeginTerm;
	}

	/**
	 * @return  the value of card_more.least_cost
	 * @mbggenerated
	 */
	public Integer getLeastCost() {
		return leastCost;
	}

	/**
	 * @param leastCost  the value for card_more.least_cost
	 * @mbggenerated
	 */
	public void setLeastCost(Integer leastCost) {
		this.leastCost = leastCost;
	}

	/**
	 * @return  the value of card_more.reduce_cost
	 * @mbggenerated
	 */
	public Integer getReduceCost() {
		return reduceCost;
	}

	/**
	 * @param reduceCost  the value for card_more.reduce_cost
	 * @mbggenerated
	 */
	public void setReduceCost(Integer reduceCost) {
		this.reduceCost = reduceCost;
	}

	/**
	 * @return  the value of card_more.discount
	 * @mbggenerated
	 */
	public Integer getDiscount() {
		return discount;
	}

	/**
	 * @param discount  the value for card_more.discount
	 * @mbggenerated
	 */
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	/**
	 * @return  the value of card_more.notice
	 * @mbggenerated
	 */
	public String getNotice() {
		return notice;
	}

	/**
	 * @param notice  the value for card_more.notice
	 * @mbggenerated
	 */
	public void setNotice(String notice) {
		this.notice = notice == null ? null : notice.trim();
	}

	/**
	 * @return  the value of card_more.service_phone
	 * @mbggenerated
	 */
	public String getServicePhone() {
		return servicePhone;
	}

	/**
	 * @param servicePhone  the value for card_more.service_phone
	 * @mbggenerated
	 */
	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone == null ? null : servicePhone.trim();
	}

	/**
	 * @return  the value of card_more.custom_url_name
	 * @mbggenerated
	 */
	public String getCustomUrlName() {
		return customUrlName;
	}

	/**
	 * @param customUrlName  the value for card_more.custom_url_name
	 * @mbggenerated
	 */
	public void setCustomUrlName(String customUrlName) {
		this.customUrlName = customUrlName == null ? null : customUrlName.trim();
	}

	/**
	 * @return  the value of card_more.custom_url
	 * @mbggenerated
	 */
	public String getCustomUrl() {
		return customUrl;
	}

	/**
	 * @param customUrl  the value for card_more.custom_url
	 * @mbggenerated
	 */
	public void setCustomUrl(String customUrl) {
		this.customUrl = customUrl == null ? null : customUrl.trim();
	}

	/**
	 * @return  the value of card_more.custom_url_sub_title
	 * @mbggenerated
	 */
	public String getCustomUrlSubTitle() {
		return customUrlSubTitle;
	}

	/**
	 * @param customUrlSubTitle  the value for card_more.custom_url_sub_title
	 * @mbggenerated
	 */
	public void setCustomUrlSubTitle(String customUrlSubTitle) {
		this.customUrlSubTitle = customUrlSubTitle == null ? null : customUrlSubTitle.trim();
	}

	/**
	 * @return  the value of card_more.promotion_url_name
	 * @mbggenerated
	 */
	public String getPromotionUrlName() {
		return promotionUrlName;
	}

	/**
	 * @param promotionUrlName  the value for card_more.promotion_url_name
	 * @mbggenerated
	 */
	public void setPromotionUrlName(String promotionUrlName) {
		this.promotionUrlName = promotionUrlName == null ? null : promotionUrlName.trim();
	}

	/**
	 * @return  the value of card_more.promotion_url
	 * @mbggenerated
	 */
	public String getPromotionUrl() {
		return promotionUrl;
	}

	/**
	 * @param promotionUrl  the value for card_more.promotion_url
	 * @mbggenerated
	 */
	public void setPromotionUrl(String promotionUrl) {
		this.promotionUrl = promotionUrl == null ? null : promotionUrl.trim();
	}

	/**
	 * @return  the value of card_more.promotion_url_sub_title
	 * @mbggenerated
	 */
	public String getPromotionUrlSubTitle() {
		return promotionUrlSubTitle;
	}

	/**
	 * @param promotionUrlSubTitle  the value for card_more.promotion_url_sub_title
	 * @mbggenerated
	 */
	public void setPromotionUrlSubTitle(String promotionUrlSubTitle) {
		this.promotionUrlSubTitle = promotionUrlSubTitle == null ? null : promotionUrlSubTitle.trim();
	}

	/**
	 * @return  the value of card_more.description
	 * @mbggenerated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description  the value for card_more.description
	 * @mbggenerated
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * @return  the value of card_more.detail
	 * @mbggenerated
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail  the value for card_more.detail
	 * @mbggenerated
	 */
	public void setDetail(String detail) {
		this.detail = detail == null ? null : detail.trim();
	}

	
    public String getLocationIdList() {
        return locationIdList;
    }

    
    public void setLocationIdList(String locationIdList) {
        this.locationIdList = locationIdList;
    }

    /**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}CardMore other=(CardMore)that;return (this.getId() == null?other.getId() == null:this.getId().equals(other.getId())) && (this.getBeginTime() == null?other.getBeginTime() == null:this.getBeginTime().equals(other.getBeginTime())) && (this.getEndTime() == null?other.getEndTime() == null:this.getEndTime().equals(other.getEndTime())) && (this.getFixedTerm() == null?other.getFixedTerm() == null:this.getFixedTerm().equals(other.getFixedTerm())) && (this.getFixedBeginTerm() == null?other.getFixedBeginTerm() == null:this.getFixedBeginTerm().equals(other.getFixedBeginTerm())) && (this.getLeastCost() == null?other.getLeastCost() == null:this.getLeastCost().equals(other.getLeastCost())) && (this.getReduceCost() == null?other.getReduceCost() == null:this.getReduceCost().equals(other.getReduceCost())) && (this.getDiscount() == null?other.getDiscount() == null:this.getDiscount().equals(other.getDiscount())) && (this.getNotice() == null?other.getNotice() == null:this.getNotice().equals(other.getNotice())) && (this.getServicePhone() == null?other.getServicePhone() == null:this.getServicePhone().equals(other.getServicePhone())) && (this.getCustomUrlName() == null?other.getCustomUrlName() == null:this.getCustomUrlName().equals(other.getCustomUrlName())) && (this.getCustomUrl() == null?other.getCustomUrl() == null:this.getCustomUrl().equals(other.getCustomUrl())) && (this.getCustomUrlSubTitle() == null?other.getCustomUrlSubTitle() == null:this.getCustomUrlSubTitle().equals(other.getCustomUrlSubTitle())) && (this.getPromotionUrlName() == null?other.getPromotionUrlName() == null:this.getPromotionUrlName().equals(other.getPromotionUrlName())) && (this.getPromotionUrl() == null?other.getPromotionUrl() == null:this.getPromotionUrl().equals(other.getPromotionUrl())) && (this.getPromotionUrlSubTitle() == null?other.getPromotionUrlSubTitle() == null:this.getPromotionUrlSubTitle().equals(other.getPromotionUrlSubTitle())) && (this.getDescription() == null?other.getDescription() == null:this.getDescription().equals(other.getDescription())) && (this.getDetail() == null?other.getDetail() == null:this.getDetail().equals(other.getDetail()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getId() == null)?0:getId().hashCode());result=prime * result + ((getBeginTime() == null)?0:getBeginTime().hashCode());result=prime * result + ((getEndTime() == null)?0:getEndTime().hashCode());result=prime * result + ((getFixedTerm() == null)?0:getFixedTerm().hashCode());result=prime * result + ((getFixedBeginTerm() == null)?0:getFixedBeginTerm().hashCode());result=prime * result + ((getLeastCost() == null)?0:getLeastCost().hashCode());result=prime * result + ((getReduceCost() == null)?0:getReduceCost().hashCode());result=prime * result + ((getDiscount() == null)?0:getDiscount().hashCode());result=prime * result + ((getNotice() == null)?0:getNotice().hashCode());result=prime * result + ((getServicePhone() == null)?0:getServicePhone().hashCode());result=prime * result + ((getCustomUrlName() == null)?0:getCustomUrlName().hashCode());result=prime * result + ((getCustomUrl() == null)?0:getCustomUrl().hashCode());result=prime * result + ((getCustomUrlSubTitle() == null)?0:getCustomUrlSubTitle().hashCode());result=prime * result + ((getPromotionUrlName() == null)?0:getPromotionUrlName().hashCode());result=prime * result + ((getPromotionUrl() == null)?0:getPromotionUrl().hashCode());result=prime * result + ((getPromotionUrlSubTitle() == null)?0:getPromotionUrlSubTitle().hashCode());result=prime * result + ((getDescription() == null)?0:getDescription().hashCode());result=prime * result + ((getDetail() == null)?0:getDetail().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", id=").append(id);sb.append(", beginTime=").append(beginTime);sb.append(", endTime=").append(endTime);sb.append(", fixedTerm=").append(fixedTerm);sb.append(", fixedBeginTerm=").append(fixedBeginTerm);sb.append(", leastCost=").append(leastCost);sb.append(", reduceCost=").append(reduceCost);sb.append(", discount=").append(discount);sb.append(", notice=").append(notice);sb.append(", servicePhone=").append(servicePhone);sb.append(", customUrlName=").append(customUrlName);sb.append(", customUrl=").append(customUrl);sb.append(", customUrlSubTitle=").append(customUrlSubTitle);sb.append(", promotionUrlName=").append(promotionUrlName);sb.append(", promotionUrl=").append(promotionUrl);sb.append(", promotionUrlSubTitle=").append(promotionUrlSubTitle);sb.append(", description=").append(description);sb.append(", detail=").append(detail);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}