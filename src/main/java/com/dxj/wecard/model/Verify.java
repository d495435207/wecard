package com.dxj.wecard.model;

import java.io.Serializable;
import java.util.Date;

public class Verify extends VerifyKey implements Serializable {

	/**
	 * 微信用户在该公众号下的openid
	 * @mbggenerated
	 */
	private String openId;
	/**
	 * 消费时间
	 * @mbggenerated
	 */
	private Date atTime;
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
	 * 是否为删除，0代表否，1代表是
	 * @mbggenerated
	 */
	private Integer isDel;
	/**
	 * 核销员的openid
	 * @mbggenerated
	 */
	private String staffOpenId;
	/**
	 * 门店名称
	 * @mbggenerated
	 */
	private String branchName;
	/**
	 * 核销来源
	 * @mbggenerated
	 */
	private String source;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of verify.open_id
	 * @mbggenerated
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId  the value for verify.open_id
	 * @mbggenerated
	 */
	public void setOpenId(String openId) {
		this.openId = openId == null ? null : openId.trim();
	}

	/**
	 * @return  the value of verify.at_time
	 * @mbggenerated
	 */
	public Date getAtTime() {
		return atTime;
	}

	/**
	 * @param atTime  the value for verify.at_time
	 * @mbggenerated
	 */
	public void setAtTime(Date atTime) {
		this.atTime = atTime;
	}

	/**
	 * @return  the value of verify.offset_type
	 * @mbggenerated
	 */
	public Integer getOffsetType() {
		return offsetType;
	}

	/**
	 * @param offsetType  the value for verify.offset_type
	 * @mbggenerated
	 */
	public void setOffsetType(Integer offsetType) {
		this.offsetType = offsetType;
	}

	/**
	 * @return  the value of verify.longitude
	 * @mbggenerated
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude  the value for verify.longitude
	 * @mbggenerated
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude == null ? null : longitude.trim();
	}

	/**
	 * @return  the value of verify.latitude
	 * @mbggenerated
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude  the value for verify.latitude
	 * @mbggenerated
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude == null ? null : latitude.trim();
	}

	/**
	 * @return  the value of verify.is_del
	 * @mbggenerated
	 */
	public Integer getIsDel() {
		return isDel;
	}

	/**
	 * @param isDel  the value for verify.is_del
	 * @mbggenerated
	 */
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	/**
	 * @return  the value of verify.staff_open_id
	 * @mbggenerated
	 */
	public String getStaffOpenId() {
		return staffOpenId;
	}

	/**
	 * @param staffOpenId  the value for verify.staff_open_id
	 * @mbggenerated
	 */
	public void setStaffOpenId(String staffOpenId) {
		this.staffOpenId = staffOpenId == null ? null : staffOpenId.trim();
	}

	/**
	 * @return  the value of verify.branch_name
	 * @mbggenerated
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName  the value for verify.branch_name
	 * @mbggenerated
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName == null ? null : branchName.trim();
	}

	/**
	 * @return  the value of verify.source
	 * @mbggenerated
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source  the value for verify.source
	 * @mbggenerated
	 */
	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}Verify other=(Verify)that;return (this.getCode() == null?other.getCode() == null:this.getCode().equals(other.getCode())) && (this.getCardId() == null?other.getCardId() == null:this.getCardId().equals(other.getCardId())) && (this.getOpenId() == null?other.getOpenId() == null:this.getOpenId().equals(other.getOpenId())) && (this.getAtTime() == null?other.getAtTime() == null:this.getAtTime().equals(other.getAtTime())) && (this.getOffsetType() == null?other.getOffsetType() == null:this.getOffsetType().equals(other.getOffsetType())) && (this.getLongitude() == null?other.getLongitude() == null:this.getLongitude().equals(other.getLongitude())) && (this.getLatitude() == null?other.getLatitude() == null:this.getLatitude().equals(other.getLatitude())) && (this.getIsDel() == null?other.getIsDel() == null:this.getIsDel().equals(other.getIsDel())) && (this.getStaffOpenId() == null?other.getStaffOpenId() == null:this.getStaffOpenId().equals(other.getStaffOpenId())) && (this.getBranchName() == null?other.getBranchName() == null:this.getBranchName().equals(other.getBranchName())) && (this.getSource() == null?other.getSource() == null:this.getSource().equals(other.getSource()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getCode() == null)?0:getCode().hashCode());result=prime * result + ((getCardId() == null)?0:getCardId().hashCode());result=prime * result + ((getOpenId() == null)?0:getOpenId().hashCode());result=prime * result + ((getAtTime() == null)?0:getAtTime().hashCode());result=prime * result + ((getOffsetType() == null)?0:getOffsetType().hashCode());result=prime * result + ((getLongitude() == null)?0:getLongitude().hashCode());result=prime * result + ((getLatitude() == null)?0:getLatitude().hashCode());result=prime * result + ((getIsDel() == null)?0:getIsDel().hashCode());result=prime * result + ((getStaffOpenId() == null)?0:getStaffOpenId().hashCode());result=prime * result + ((getBranchName() == null)?0:getBranchName().hashCode());result=prime * result + ((getSource() == null)?0:getSource().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", openId=").append(openId);sb.append(", atTime=").append(atTime);sb.append(", offsetType=").append(offsetType);sb.append(", longitude=").append(longitude);sb.append(", latitude=").append(latitude);sb.append(", isDel=").append(isDel);sb.append(", staffOpenId=").append(staffOpenId);sb.append(", branchName=").append(branchName);sb.append(", source=").append(source);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}