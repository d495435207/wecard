package com.dxj.wecard.model;

import java.io.Serializable;

public class Card implements Serializable {

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
	 * 卡劵状态，2为下架、1为上架，3为无效
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
	 * 同步微信卡劵时的卡logo url 默认使用app表中的公众号logo，而不是这个字段
	 * @mbggenerated
	 */
	private String wClogo;
	/**
	 * 同步微信卡劵时的卡的商户名称 默认使用app表中的公众号name，而不是这个字段
	 * @mbggenerated
	 */
	private String wCname;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of card.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id  the value for card.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return  the value of card.app_id
	 * @mbggenerated
	 */
	public String getAppId() {
		return appId;
	}


	/**
	 * @param appId  the value for card.app_id
	 * @mbggenerated
	 */
	public void setAppId(String appId) {
		this.appId = appId == null ? null : appId.trim();
	}


	/**
	 * @return  the value of card.card_id
	 * @mbggenerated
	 */
	public String getCardId() {
		return cardId;
	}


	/**
	 * @param cardId  the value for card.card_id
	 * @mbggenerated
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId == null ? null : cardId.trim();
	}


	/**
	 * @return  the value of card.categories
	 * @mbggenerated
	 */
	public String getCategories() {
		return categories;
	}


	/**
	 * @param categories  the value for card.categories
	 * @mbggenerated
	 */
	public void setCategories(String categories) {
		this.categories = categories == null ? null : categories.trim();
	}


	/**
	 * @return  the value of card.card_status
	 * @mbggenerated
	 */
	public Integer getCardStatus() {
		return cardStatus;
	}


	/**
	 * @param cardStatus  the value for card.card_status
	 * @mbggenerated
	 */
	public void setCardStatus(Integer cardStatus) {
		this.cardStatus = cardStatus;
	}


	/**
	 * @return  the value of card.quantity
	 * @mbggenerated
	 */
	public Integer getQuantity() {
		return quantity;
	}


	/**
	 * @param quantity  the value for card.quantity
	 * @mbggenerated
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	/**
	 * @return  the value of card.total_quantity
	 * @mbggenerated
	 */
	public Integer getTotalQuantity() {
		return totalQuantity;
	}


	/**
	 * @param totalQuantity  the value for card.total_quantity
	 * @mbggenerated
	 */
	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}


	/**
	 * @return  the value of card.cost
	 * @mbggenerated
	 */
	public Integer getCost() {
		return cost;
	}


	/**
	 * @param cost  the value for card.cost
	 * @mbggenerated
	 */
	public void setCost(Integer cost) {
		this.cost = cost;
	}


	/**
	 * @return  the value of card.card_type
	 * @mbggenerated
	 */
	public String getCardType() {
		return cardType;
	}


	/**
	 * @param cardType  the value for card.card_type
	 * @mbggenerated
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType == null ? null : cardType.trim();
	}


	/**
	 * @return  the value of card.title
	 * @mbggenerated
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title  the value for card.title
	 * @mbggenerated
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}


	/**
	 * @return  the value of card.sub_title
	 * @mbggenerated
	 */
	public String getSubTitle() {
		return subTitle;
	}


	/**
	 * @param subTitle  the value for card.sub_title
	 * @mbggenerated
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle == null ? null : subTitle.trim();
	}


	/**
	 * @return  the value of card.color
	 * @mbggenerated
	 */
	public String getColor() {
		return color;
	}


	/**
	 * @param color  the value for card.color
	 * @mbggenerated
	 */
	public void setColor(String color) {
		this.color = color == null ? null : color.trim();
	}


	/**
	 * @return  the value of card.date_info
	 * @mbggenerated
	 */
	public String getDateInfo() {
		return dateInfo;
	}


	/**
	 * @param dateInfo  the value for card.date_info
	 * @mbggenerated
	 */
	public void setDateInfo(String dateInfo) {
		this.dateInfo = dateInfo == null ? null : dateInfo.trim();
	}


	/**
	 * @return  the value of card.receive_cnt
	 * @mbggenerated
	 */
	public Integer getReceiveCnt() {
		return receiveCnt;
	}


	/**
	 * @param receiveCnt  the value for card.receive_cnt
	 * @mbggenerated
	 */
	public void setReceiveCnt(Integer receiveCnt) {
		this.receiveCnt = receiveCnt;
	}


	/**
	 * @return  the value of card.receive_user
	 * @mbggenerated
	 */
	public Integer getReceiveUser() {
		return receiveUser;
	}


	/**
	 * @param receiveUser  the value for card.receive_user
	 * @mbggenerated
	 */
	public void setReceiveUser(Integer receiveUser) {
		this.receiveUser = receiveUser;
	}


	/**
	 * @return  the value of card.verify_cnt
	 * @mbggenerated
	 */
	public Integer getVerifyCnt() {
		return verifyCnt;
	}


	/**
	 * @param verifyCnt  the value for card.verify_cnt
	 * @mbggenerated
	 */
	public void setVerifyCnt(Integer verifyCnt) {
		this.verifyCnt = verifyCnt;
	}


	/**
	 * @return  the value of card.view_cnt
	 * @mbggenerated
	 */
	public Integer getViewCnt() {
		return viewCnt;
	}


	/**
	 * @param viewCnt  the value for card.view_cnt
	 * @mbggenerated
	 */
	public void setViewCnt(Integer viewCnt) {
		this.viewCnt = viewCnt;
	}


	/**
	 * @return  the value of card.get_limit
	 * @mbggenerated
	 */
	public Integer getGetLimit() {
		return getLimit;
	}


	/**
	 * @param getLimit  the value for card.get_limit
	 * @mbggenerated
	 */
	public void setGetLimit(Integer getLimit) {
		this.getLimit = getLimit;
	}


	/**
	 * @return  the value of card.is_custom_code
	 * @mbggenerated
	 */
	public Integer getIsCustomCode() {
		return isCustomCode;
	}


	/**
	 * @param isCustomCode  the value for card.is_custom_code
	 * @mbggenerated
	 */
	public void setIsCustomCode(Integer isCustomCode) {
		this.isCustomCode = isCustomCode;
	}


	/**
	 * @return  the value of card.is_bind_openid
	 * @mbggenerated
	 */
	public Integer getIsBindOpenid() {
		return isBindOpenid;
	}


	/**
	 * @param isBindOpenid  the value for card.is_bind_openid
	 * @mbggenerated
	 */
	public void setIsBindOpenid(Integer isBindOpenid) {
		this.isBindOpenid = isBindOpenid;
	}


	/**
	 * @return  the value of card.is_share
	 * @mbggenerated
	 */
	public Integer getIsShare() {
		return isShare;
	}


	/**
	 * @param isShare  the value for card.is_share
	 * @mbggenerated
	 */
	public void setIsShare(Integer isShare) {
		this.isShare = isShare;
	}


	/**
	 * @return  the value of card.is_give_friend
	 * @mbggenerated
	 */
	public Integer getIsGiveFriend() {
		return isGiveFriend;
	}


	/**
	 * @param isGiveFriend  the value for card.is_give_friend
	 * @mbggenerated
	 */
	public void setIsGiveFriend(Integer isGiveFriend) {
		this.isGiveFriend = isGiveFriend;
	}


	/**
	 * @return  the value of card.branch_type
	 * @mbggenerated
	 */
	public Integer getBranchType() {
		return branchType;
	}


	/**
	 * @param branchType  the value for card.branch_type
	 * @mbggenerated
	 */
	public void setBranchType(Integer branchType) {
		this.branchType = branchType;
	}


	/**
	 * @return  the value of card.date_type
	 * @mbggenerated
	 */
	public Integer getDateType() {
		return dateType;
	}


	/**
	 * @param dateType  the value for card.date_type
	 * @mbggenerated
	 */
	public void setDateType(Integer dateType) {
		this.dateType = dateType;
	}


	/**
	 * @return  the value of card.code_type
	 * @mbggenerated
	 */
	public String getCodeType() {
		return codeType;
	}


	/**
	 * @param codeType  the value for card.code_type
	 * @mbggenerated
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType == null ? null : codeType.trim();
	}


	/**
	 * @return  the value of card.status
	 * @mbggenerated
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status  the value for card.status
	 * @mbggenerated
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}


	/**
	 * @return  the value of card.source
	 * @mbggenerated
	 */
	public String getSource() {
		return source;
	}


	/**
	 * @param source  the value for card.source
	 * @mbggenerated
	 */
	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}


	/**
	 * @return  the value of card.cond_source
	 * @mbggenerated
	 */
	public Integer getCondSource() {
		return condSource;
	}


	/**
	 * @param condSource  the value for card.cond_source
	 * @mbggenerated
	 */
	public void setCondSource(Integer condSource) {
		this.condSource = condSource;
	}


	/**
	 * @return  the value of card.w_clogo
	 * @mbggenerated
	 */
	public String getwClogo() {
		return wClogo;
	}


	/**
	 * @param wClogo  the value for card.w_clogo
	 * @mbggenerated
	 */
	public void setwClogo(String wClogo) {
		this.wClogo = wClogo == null ? null : wClogo.trim();
	}


	/**
	 * @return  the value of card.w_cname
	 * @mbggenerated
	 */
	public String getwCname() {
		return wCname;
	}


	/**
	 * @param wCname  the value for card.w_cname
	 * @mbggenerated
	 */
	public void setwCname(String wCname) {
		this.wCname = wCname == null ? null : wCname.trim();
	}


	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}Card other=(Card)that;return (this.getId() == null?other.getId() == null:this.getId().equals(other.getId())) && (this.getAppId() == null?other.getAppId() == null:this.getAppId().equals(other.getAppId())) && (this.getCardId() == null?other.getCardId() == null:this.getCardId().equals(other.getCardId())) && (this.getCategories() == null?other.getCategories() == null:this.getCategories().equals(other.getCategories())) && (this.getCardStatus() == null?other.getCardStatus() == null:this.getCardStatus().equals(other.getCardStatus())) && (this.getQuantity() == null?other.getQuantity() == null:this.getQuantity().equals(other.getQuantity())) && (this.getTotalQuantity() == null?other.getTotalQuantity() == null:this.getTotalQuantity().equals(other.getTotalQuantity())) && (this.getCost() == null?other.getCost() == null:this.getCost().equals(other.getCost())) && (this.getCardType() == null?other.getCardType() == null:this.getCardType().equals(other.getCardType())) && (this.getTitle() == null?other.getTitle() == null:this.getTitle().equals(other.getTitle())) && (this.getSubTitle() == null?other.getSubTitle() == null:this.getSubTitle().equals(other.getSubTitle())) && (this.getColor() == null?other.getColor() == null:this.getColor().equals(other.getColor())) && (this.getDateInfo() == null?other.getDateInfo() == null:this.getDateInfo().equals(other.getDateInfo())) && (this.getReceiveCnt() == null?other.getReceiveCnt() == null:this.getReceiveCnt().equals(other.getReceiveCnt())) && (this.getReceiveUser() == null?other.getReceiveUser() == null:this.getReceiveUser().equals(other.getReceiveUser())) && (this.getVerifyCnt() == null?other.getVerifyCnt() == null:this.getVerifyCnt().equals(other.getVerifyCnt())) && (this.getViewCnt() == null?other.getViewCnt() == null:this.getViewCnt().equals(other.getViewCnt())) && (this.getGetLimit() == null?other.getGetLimit() == null:this.getGetLimit().equals(other.getGetLimit())) && (this.getIsCustomCode() == null?other.getIsCustomCode() == null:this.getIsCustomCode().equals(other.getIsCustomCode())) && (this.getIsBindOpenid() == null?other.getIsBindOpenid() == null:this.getIsBindOpenid().equals(other.getIsBindOpenid())) && (this.getIsShare() == null?other.getIsShare() == null:this.getIsShare().equals(other.getIsShare())) && (this.getIsGiveFriend() == null?other.getIsGiveFriend() == null:this.getIsGiveFriend().equals(other.getIsGiveFriend())) && (this.getBranchType() == null?other.getBranchType() == null:this.getBranchType().equals(other.getBranchType())) && (this.getDateType() == null?other.getDateType() == null:this.getDateType().equals(other.getDateType())) && (this.getCodeType() == null?other.getCodeType() == null:this.getCodeType().equals(other.getCodeType())) && (this.getStatus() == null?other.getStatus() == null:this.getStatus().equals(other.getStatus())) && (this.getSource() == null?other.getSource() == null:this.getSource().equals(other.getSource())) && (this.getCondSource() == null?other.getCondSource() == null:this.getCondSource().equals(other.getCondSource())) && (this.getwClogo() == null?other.getwClogo() == null:this.getwClogo().equals(other.getwClogo())) && (this.getwCname() == null?other.getwCname() == null:this.getwCname().equals(other.getwCname()));}


	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getId() == null)?0:getId().hashCode());result=prime * result + ((getAppId() == null)?0:getAppId().hashCode());result=prime * result + ((getCardId() == null)?0:getCardId().hashCode());result=prime * result + ((getCategories() == null)?0:getCategories().hashCode());result=prime * result + ((getCardStatus() == null)?0:getCardStatus().hashCode());result=prime * result + ((getQuantity() == null)?0:getQuantity().hashCode());result=prime * result + ((getTotalQuantity() == null)?0:getTotalQuantity().hashCode());result=prime * result + ((getCost() == null)?0:getCost().hashCode());result=prime * result + ((getCardType() == null)?0:getCardType().hashCode());result=prime * result + ((getTitle() == null)?0:getTitle().hashCode());result=prime * result + ((getSubTitle() == null)?0:getSubTitle().hashCode());result=prime * result + ((getColor() == null)?0:getColor().hashCode());result=prime * result + ((getDateInfo() == null)?0:getDateInfo().hashCode());result=prime * result + ((getReceiveCnt() == null)?0:getReceiveCnt().hashCode());result=prime * result + ((getReceiveUser() == null)?0:getReceiveUser().hashCode());result=prime * result + ((getVerifyCnt() == null)?0:getVerifyCnt().hashCode());result=prime * result + ((getViewCnt() == null)?0:getViewCnt().hashCode());result=prime * result + ((getGetLimit() == null)?0:getGetLimit().hashCode());result=prime * result + ((getIsCustomCode() == null)?0:getIsCustomCode().hashCode());result=prime * result + ((getIsBindOpenid() == null)?0:getIsBindOpenid().hashCode());result=prime * result + ((getIsShare() == null)?0:getIsShare().hashCode());result=prime * result + ((getIsGiveFriend() == null)?0:getIsGiveFriend().hashCode());result=prime * result + ((getBranchType() == null)?0:getBranchType().hashCode());result=prime * result + ((getDateType() == null)?0:getDateType().hashCode());result=prime * result + ((getCodeType() == null)?0:getCodeType().hashCode());result=prime * result + ((getStatus() == null)?0:getStatus().hashCode());result=prime * result + ((getSource() == null)?0:getSource().hashCode());result=prime * result + ((getCondSource() == null)?0:getCondSource().hashCode());result=prime * result + ((getwClogo() == null)?0:getwClogo().hashCode());result=prime * result + ((getwCname() == null)?0:getwCname().hashCode());return result;}


	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", id=").append(id);sb.append(", appId=").append(appId);sb.append(", cardId=").append(cardId);sb.append(", categories=").append(categories);sb.append(", cardStatus=").append(cardStatus);sb.append(", quantity=").append(quantity);sb.append(", totalQuantity=").append(totalQuantity);sb.append(", cost=").append(cost);sb.append(", cardType=").append(cardType);sb.append(", title=").append(title);sb.append(", subTitle=").append(subTitle);sb.append(", color=").append(color);sb.append(", dateInfo=").append(dateInfo);sb.append(", receiveCnt=").append(receiveCnt);sb.append(", receiveUser=").append(receiveUser);sb.append(", verifyCnt=").append(verifyCnt);sb.append(", viewCnt=").append(viewCnt);sb.append(", getLimit=").append(getLimit);sb.append(", isCustomCode=").append(isCustomCode);sb.append(", isBindOpenid=").append(isBindOpenid);sb.append(", isShare=").append(isShare);sb.append(", isGiveFriend=").append(isGiveFriend);sb.append(", branchType=").append(branchType);sb.append(", dateType=").append(dateType);sb.append(", codeType=").append(codeType);sb.append(", status=").append(status);sb.append(", source=").append(source);sb.append(", condSource=").append(condSource);sb.append(", wClogo=").append(wClogo);sb.append(", wCname=").append(wCname);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}