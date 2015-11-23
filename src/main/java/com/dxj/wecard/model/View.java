package com.dxj.wecard.model;

import java.io.Serializable;
import java.util.Date;

public class View extends ViewKey implements Serializable {

	/**
	 * 浏览时间
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
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of view.at_time
	 * @mbggenerated
	 */
	public Date getAtTime() {
		return atTime;
	}

	/**
	 * @param atTime  the value for view.at_time
	 * @mbggenerated
	 */
	public void setAtTime(Date atTime) {
		this.atTime = atTime;
	}

	/**
	 * @return  the value of view.offset_type
	 * @mbggenerated
	 */
	public Integer getOffsetType() {
		return offsetType;
	}

	/**
	 * @param offsetType  the value for view.offset_type
	 * @mbggenerated
	 */
	public void setOffsetType(Integer offsetType) {
		this.offsetType = offsetType;
	}

	/**
	 * @return  the value of view.longitude
	 * @mbggenerated
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude  the value for view.longitude
	 * @mbggenerated
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude == null ? null : longitude.trim();
	}

	/**
	 * @return  the value of view.latitude
	 * @mbggenerated
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude  the value for view.latitude
	 * @mbggenerated
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude == null ? null : latitude.trim();
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}View other=(View)that;return (this.getOpenId() == null?other.getOpenId() == null:this.getOpenId().equals(other.getOpenId())) && (this.getCardId() == null?other.getCardId() == null:this.getCardId().equals(other.getCardId())) && (this.getAtTime() == null?other.getAtTime() == null:this.getAtTime().equals(other.getAtTime())) && (this.getOffsetType() == null?other.getOffsetType() == null:this.getOffsetType().equals(other.getOffsetType())) && (this.getLongitude() == null?other.getLongitude() == null:this.getLongitude().equals(other.getLongitude())) && (this.getLatitude() == null?other.getLatitude() == null:this.getLatitude().equals(other.getLatitude()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getOpenId() == null)?0:getOpenId().hashCode());result=prime * result + ((getCardId() == null)?0:getCardId().hashCode());result=prime * result + ((getAtTime() == null)?0:getAtTime().hashCode());result=prime * result + ((getOffsetType() == null)?0:getOffsetType().hashCode());result=prime * result + ((getLongitude() == null)?0:getLongitude().hashCode());result=prime * result + ((getLatitude() == null)?0:getLatitude().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", atTime=").append(atTime);sb.append(", offsetType=").append(offsetType);sb.append(", longitude=").append(longitude);sb.append(", latitude=").append(latitude);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}