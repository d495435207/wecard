package com.dxj.wecard.model;

import java.io.Serializable;

public class ReceiveKey implements Serializable {

	/**
	 * 卡劵id
	 * @mbggenerated
	 */
	private Integer cardId;
	/**
	 * 消费id=微信返回的卡劵code
	 * @mbggenerated
	 */
	private String code;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of receive.card_id
	 * @mbggenerated
	 */
	public Integer getCardId() {
		return cardId;
	}

	/**
	 * @param cardId  the value for receive.card_id
	 * @mbggenerated
	 */
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return  the value of receive.code
	 * @mbggenerated
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code  the value for receive.code
	 * @mbggenerated
	 */
	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}ReceiveKey other=(ReceiveKey)that;return (this.getCardId() == null?other.getCardId() == null:this.getCardId().equals(other.getCardId())) && (this.getCode() == null?other.getCode() == null:this.getCode().equals(other.getCode()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getCardId() == null)?0:getCardId().hashCode());result=prime * result + ((getCode() == null)?0:getCode().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", cardId=").append(cardId);sb.append(", code=").append(code);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}