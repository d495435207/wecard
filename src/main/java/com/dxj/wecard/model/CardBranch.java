package com.dxj.wecard.model;

import java.io.Serializable;

public class CardBranch implements Serializable {

	/**
	 * 门店id
	 * @mbggenerated
	 */
	private Integer branchId;
	/**
	 * @mbggenerated
	 */
	private Integer cardId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of card_branch.branch_id
	 * @mbggenerated
	 */
	public Integer getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId  the value for card_branch.branch_id
	 * @mbggenerated
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return  the value of card_branch.card_id
	 * @mbggenerated
	 */
	public Integer getCardId() {
		return cardId;
	}

	/**
	 * @param cardId  the value for card_branch.card_id
	 * @mbggenerated
	 */
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}CardBranch other=(CardBranch)that;return (this.getBranchId() == null?other.getBranchId() == null:this.getBranchId().equals(other.getBranchId())) && (this.getCardId() == null?other.getCardId() == null:this.getCardId().equals(other.getCardId()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getBranchId() == null)?0:getBranchId().hashCode());result=prime * result + ((getCardId() == null)?0:getCardId().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", branchId=").append(branchId);sb.append(", cardId=").append(cardId);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}