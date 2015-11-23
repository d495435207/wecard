package com.dxj.wecard.model;

import java.io.Serializable;
import java.util.Date;

public class Receive extends ReceiveKey implements Serializable {

	/**
	 * 微信用户在该公众号下的openid
	 * @mbggenerated
	 */
	private String openId;
	/**
	 * 领取场景值
	 * @mbggenerated
	 */
	private String outerId;
	/**
	 * 消费时间
	 * @mbggenerated
	 */
	private Date atTime;
	/**
	 * 消费金额（单位为分）
	 * @mbggenerated
	 */
	private Integer cost;
	/**
	 * 承销商分成金额（单位为分）
	 * @mbggenerated
	 */
	private Integer costProfit;
	/**
	 * 坐标类型，1 为火星坐标（目前只能选1）
	 * @mbggenerated
	 */
	private Integer offsetType;
	/**
	 * 地理位置的经度
	 * @mbggenerated
	 */
	private String longitude;
	/**
	 * 地理位置的纬度
	 * @mbggenerated
	 */
	private String latitude;
	/**
	 * 是否为转赠，0代表否，1代表是
	 * @mbggenerated
	 */
	private Integer isGiveFriend;
	/**
	 * 转赠前的code序列号
	 * @mbggenerated
	 */
	private String oldCode;
	/**
	 * 赠送方openid
	 * @mbggenerated
	 */
	private String friendOpenId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of receive.open_id
	 * @mbggenerated
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId  the value for receive.open_id
	 * @mbggenerated
	 */
	public void setOpenId(String openId) {
		this.openId = openId == null ? null : openId.trim();
	}

	/**
	 * @return  the value of receive.outer_id
	 * @mbggenerated
	 */
	public String getOuterId() {
		return outerId;
	}

	/**
	 * @param outerId  the value for receive.outer_id
	 * @mbggenerated
	 */
	public void setOuterId(String outerId) {
		this.outerId = outerId == null ? null : outerId.trim();
	}

	/**
	 * @return  the value of receive.at_time
	 * @mbggenerated
	 */
	public Date getAtTime() {
		return atTime;
	}

	/**
	 * @param atTime  the value for receive.at_time
	 * @mbggenerated
	 */
	public void setAtTime(Date atTime) {
		this.atTime = atTime;
	}

	/**
	 * @return  the value of receive.cost
	 * @mbggenerated
	 */
	public Integer getCost() {
		return cost;
	}

	/**
	 * @param cost  the value for receive.cost
	 * @mbggenerated
	 */
	public void setCost(Integer cost) {
		this.cost = cost;
	}

	/**
	 * @return  the value of receive.cost_profit
	 * @mbggenerated
	 */
	public Integer getCostProfit() {
		return costProfit;
	}

	/**
	 * @param costProfit  the value for receive.cost_profit
	 * @mbggenerated
	 */
	public void setCostProfit(Integer costProfit) {
		this.costProfit = costProfit;
	}

	/**
	 * @return  the value of receive.offset_type
	 * @mbggenerated
	 */
	public Integer getOffsetType() {
		return offsetType;
	}

	/**
	 * @param offsetType  the value for receive.offset_type
	 * @mbggenerated
	 */
	public void setOffsetType(Integer offsetType) {
		this.offsetType = offsetType;
	}

	/**
	 * @return  the value of receive.longitude
	 * @mbggenerated
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude  the value for receive.longitude
	 * @mbggenerated
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude == null ? null : longitude.trim();
	}

	/**
	 * @return  the value of receive.latitude
	 * @mbggenerated
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude  the value for receive.latitude
	 * @mbggenerated
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude == null ? null : latitude.trim();
	}

	/**
	 * @return  the value of receive.is_give_friend
	 * @mbggenerated
	 */
	public Integer getIsGiveFriend() {
		return isGiveFriend;
	}

	/**
	 * @param isGiveFriend  the value for receive.is_give_friend
	 * @mbggenerated
	 */
	public void setIsGiveFriend(Integer isGiveFriend) {
		this.isGiveFriend = isGiveFriend;
	}

	/**
	 * @return  the value of receive.old_code
	 * @mbggenerated
	 */
	public String getOldCode() {
		return oldCode;
	}

	/**
	 * @param oldCode  the value for receive.old_code
	 * @mbggenerated
	 */
	public void setOldCode(String oldCode) {
		this.oldCode = oldCode == null ? null : oldCode.trim();
	}

	/**
	 * @return  the value of receive.friend_open_id
	 * @mbggenerated
	 */
	public String getFriendOpenId() {
		return friendOpenId;
	}

	/**
	 * @param friendOpenId  the value for receive.friend_open_id
	 * @mbggenerated
	 */
	public void setFriendOpenId(String friendOpenId) {
		this.friendOpenId = friendOpenId == null ? null : friendOpenId.trim();
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}Receive other=(Receive)that;return (this.getCardId() == null?other.getCardId() == null:this.getCardId().equals(other.getCardId())) && (this.getCode() == null?other.getCode() == null:this.getCode().equals(other.getCode())) && (this.getOpenId() == null?other.getOpenId() == null:this.getOpenId().equals(other.getOpenId())) && (this.getOuterId() == null?other.getOuterId() == null:this.getOuterId().equals(other.getOuterId())) && (this.getAtTime() == null?other.getAtTime() == null:this.getAtTime().equals(other.getAtTime())) && (this.getCost() == null?other.getCost() == null:this.getCost().equals(other.getCost())) && (this.getCostProfit() == null?other.getCostProfit() == null:this.getCostProfit().equals(other.getCostProfit())) && (this.getOffsetType() == null?other.getOffsetType() == null:this.getOffsetType().equals(other.getOffsetType())) && (this.getLongitude() == null?other.getLongitude() == null:this.getLongitude().equals(other.getLongitude())) && (this.getLatitude() == null?other.getLatitude() == null:this.getLatitude().equals(other.getLatitude())) && (this.getIsGiveFriend() == null?other.getIsGiveFriend() == null:this.getIsGiveFriend().equals(other.getIsGiveFriend())) && (this.getOldCode() == null?other.getOldCode() == null:this.getOldCode().equals(other.getOldCode())) && (this.getFriendOpenId() == null?other.getFriendOpenId() == null:this.getFriendOpenId().equals(other.getFriendOpenId()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getCardId() == null)?0:getCardId().hashCode());result=prime * result + ((getCode() == null)?0:getCode().hashCode());result=prime * result + ((getOpenId() == null)?0:getOpenId().hashCode());result=prime * result + ((getOuterId() == null)?0:getOuterId().hashCode());result=prime * result + ((getAtTime() == null)?0:getAtTime().hashCode());result=prime * result + ((getCost() == null)?0:getCost().hashCode());result=prime * result + ((getCostProfit() == null)?0:getCostProfit().hashCode());result=prime * result + ((getOffsetType() == null)?0:getOffsetType().hashCode());result=prime * result + ((getLongitude() == null)?0:getLongitude().hashCode());result=prime * result + ((getLatitude() == null)?0:getLatitude().hashCode());result=prime * result + ((getIsGiveFriend() == null)?0:getIsGiveFriend().hashCode());result=prime * result + ((getOldCode() == null)?0:getOldCode().hashCode());result=prime * result + ((getFriendOpenId() == null)?0:getFriendOpenId().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", openId=").append(openId);sb.append(", outerId=").append(outerId);sb.append(", atTime=").append(atTime);sb.append(", cost=").append(cost);sb.append(", costProfit=").append(costProfit);sb.append(", offsetType=").append(offsetType);sb.append(", longitude=").append(longitude);sb.append(", latitude=").append(latitude);sb.append(", isGiveFriend=").append(isGiveFriend);sb.append(", oldCode=").append(oldCode);sb.append(", friendOpenId=").append(friendOpenId);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}