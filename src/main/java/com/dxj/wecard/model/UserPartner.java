package com.dxj.wecard.model;

import java.io.Serializable;

public class UserPartner implements Serializable {

	/**
	 * 用户名
	 * @mbggenerated
	 */
	private String userId;
	/**
	 * 合作伙伴id
	 * @mbggenerated
	 */
	private Integer partnerId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of user_partner.user_id
	 * @mbggenerated
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId  the value for user_partner.user_id
	 * @mbggenerated
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	/**
	 * @return  the value of user_partner.partner_id
	 * @mbggenerated
	 */
	public Integer getPartnerId() {
		return partnerId;
	}

	/**
	 * @param partnerId  the value for user_partner.partner_id
	 * @mbggenerated
	 */
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}UserPartner other=(UserPartner)that;return (this.getUserId() == null?other.getUserId() == null:this.getUserId().equals(other.getUserId())) && (this.getPartnerId() == null?other.getPartnerId() == null:this.getPartnerId().equals(other.getPartnerId()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getUserId() == null)?0:getUserId().hashCode());result=prime * result + ((getPartnerId() == null)?0:getPartnerId().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", userId=").append(userId);sb.append(", partnerId=").append(partnerId);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}