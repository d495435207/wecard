package com.dxj.wecard.model;

import java.io.Serializable;

public class Channel implements Serializable {

	/**
	 * 卡劵承销渠道id=卡劵投放、领用时的outerid
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * 合作伙伴id
	 * @mbggenerated
	 */
	private Integer partnerId;
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
	 * @return  the value of channel.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id  the value for channel.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return  the value of channel.partner_id
	 * @mbggenerated
	 */
	public Integer getPartnerId() {
		return partnerId;
	}

	/**
	 * @param partnerId  the value for channel.partner_id
	 * @mbggenerated
	 */
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @return  the value of channel.card_id
	 * @mbggenerated
	 */
	public Integer getCardId() {
		return cardId;
	}

	/**
	 * @param cardId  the value for channel.card_id
	 * @mbggenerated
	 */
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}Channel other=(Channel)that;return (this.getId() == null?other.getId() == null:this.getId().equals(other.getId())) && (this.getPartnerId() == null?other.getPartnerId() == null:this.getPartnerId().equals(other.getPartnerId())) && (this.getCardId() == null?other.getCardId() == null:this.getCardId().equals(other.getCardId()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getId() == null)?0:getId().hashCode());result=prime * result + ((getPartnerId() == null)?0:getPartnerId().hashCode());result=prime * result + ((getCardId() == null)?0:getCardId().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", id=").append(id);sb.append(", partnerId=").append(partnerId);sb.append(", cardId=").append(cardId);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}