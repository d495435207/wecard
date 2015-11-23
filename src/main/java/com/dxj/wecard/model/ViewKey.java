package com.dxj.wecard.model;

import java.io.Serializable;

public class ViewKey implements Serializable {

	/**
	 * 微信用户在该公众号下的openid
	 * @mbggenerated
	 */
	private String openId;
	/**
	 * 卡劵id
	 * @mbggenerated
	 */
	private Integer cardId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of view.open_id
	 * @mbggenerated
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId  the value for view.open_id
	 * @mbggenerated
	 */
	public void setOpenId(String openId) {
		this.openId = openId == null ? null : openId.trim();
	}

	/**
	 * @return  the value of view.card_id
	 * @mbggenerated
	 */
	public Integer getCardId() {
		return cardId;
	}

	/**
	 * @param cardId  the value for view.card_id
	 * @mbggenerated
	 */
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}ViewKey other=(ViewKey)that;return (this.getOpenId() == null?other.getOpenId() == null:this.getOpenId().equals(other.getOpenId())) && (this.getCardId() == null?other.getCardId() == null:this.getCardId().equals(other.getCardId()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getOpenId() == null)?0:getOpenId().hashCode());result=prime * result + ((getCardId() == null)?0:getCardId().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", openId=").append(openId);sb.append(", cardId=").append(cardId);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}