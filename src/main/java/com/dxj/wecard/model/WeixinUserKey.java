package com.dxj.wecard.model;

import java.io.Serializable;

public class WeixinUserKey implements Serializable {

	/**
	 * 微信appid
	 * @mbggenerated
	 */
	private String appId;
	/**
	 * 微信用户在该公众号下的openid
	 * @mbggenerated
	 */
	private String openId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of weixin_user.app_id
	 * @mbggenerated
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @param appId  the value for weixin_user.app_id
	 * @mbggenerated
	 */
	public void setAppId(String appId) {
		this.appId = appId == null ? null : appId.trim();
	}

	/**
	 * @return  the value of weixin_user.open_id
	 * @mbggenerated
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId  the value for weixin_user.open_id
	 * @mbggenerated
	 */
	public void setOpenId(String openId) {
		this.openId = openId == null ? null : openId.trim();
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}WeixinUserKey other=(WeixinUserKey)that;return (this.getAppId() == null?other.getAppId() == null:this.getAppId().equals(other.getAppId())) && (this.getOpenId() == null?other.getOpenId() == null:this.getOpenId().equals(other.getOpenId()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getAppId() == null)?0:getAppId().hashCode());result=prime * result + ((getOpenId() == null)?0:getOpenId().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", appId=").append(appId);sb.append(", openId=").append(openId);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}