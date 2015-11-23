package com.dxj.wecard.model;

import java.io.Serializable;
import java.util.Date;

public class Fund implements Serializable {

	/**
	 * 资金id
	 * 
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * 合作伙伴id
	 * 
	 * @mbggenerated
	 */
	private Integer partnerId;
	/**
	 * 充值时间
	 * 
	 * @mbggenerated
	 */
	private Date atTime;
	/**
	 * 资金来源/去向渠道 -可填银行、渠道流水号
	 * 
	 * @mbggenerated
	 */
	private String source;
	/**
	 * 资金来源/去向渠道 -可填银行、渠道名称
	 * 
	 * @mbggenerated
	 */
	private String bankName;
	/**
	 * 资金来源/去向渠道 -可填银行、渠道账号
	 * 
	 * @mbggenerated
	 */
	private String bankAccount;
	/**
	 * 收款方
	 * 
	 * @mbggenerated
	 */
	private String payee;
	/**
	 * 开户行名称
	 * 
	 * @mbggenerated
	 */
	private String openingBankName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return the value of fund.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the value for fund.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the value of fund.partner_id
	 * @mbggenerated
	 */
	public Integer getPartnerId() {
		return partnerId;
	}

	/**
	 * @param partnerId
	 *            the value for fund.partner_id
	 * @mbggenerated
	 */
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @return the value of fund.at_time
	 * @mbggenerated
	 */
	public Date getAtTime() {
		return atTime;
	}

	/**
	 * @param atTime
	 *            the value for fund.at_time
	 * @mbggenerated
	 */
	public void setAtTime(Date atTime) {
		this.atTime = atTime;
	}

	/**
	 * @return the value of fund.debit_amount
	 * @mbggenerated
	 */
	public Integer getDebitAmount() {
		return debitAmount;
	}

	/**
	 * @param debitAmount
	 *            the value for fund.debit_amount
	 * @mbggenerated
	 */
	public void setDebitAmount(Integer debitAmount) {
		this.debitAmount = debitAmount;
	}

	/**
	 * @return the value of fund.credit_amount
	 * @mbggenerated
	 */
	public Integer getCreditAmount() {
		return creditAmount;
	}

	/**
	 * @param creditAmount
	 *            the value for fund.credit_amount
	 * @mbggenerated
	 */
	public void setCreditAmount(Integer creditAmount) {
		this.creditAmount = creditAmount;
	}

	/**
	 * @return the value of fund.source
	 * @mbggenerated
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source
	 *            the value for fund.source
	 * @mbggenerated
	 */
	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}

	/**
	 * @return the value of fund.bank_name
	 * @mbggenerated
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName
	 *            the value for fund.bank_name
	 * @mbggenerated
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName == null ? null : bankName.trim();
	}

	/**
	 * @return the value of fund.bank_account
	 * @mbggenerated
	 */
	public String getBankAccount() {
		return bankAccount;
	}

	/**
	 * @param bankAccount
	 *            the value for fund.bank_account
	 * @mbggenerated
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount == null ? null : bankAccount.trim();
	}

	/**
	 * @return the value of fund.payee
	 * @mbggenerated
	 */
	public String getPayee() {
		return payee;
	}

	/**
	 * @param payee
	 *            the value for fund.payee
	 * @mbggenerated
	 */
	public void setPayee(String payee) {
		this.payee = payee == null ? null : payee.trim();
	}

	/**
	 * @return the value of fund.opening_bank_name
	 * @mbggenerated
	 */
	public String getOpeningBankName() {
		return openingBankName;
	}

	/**
	 * @param openingBankName
	 *            the value for fund.opening_bank_name
	 * @mbggenerated
	 */
	public void setOpeningBankName(String openingBankName) {
		this.openingBankName = openingBankName == null ? null : openingBankName.trim();
	}

	/**
	 * @mbggenerated
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Fund other = (Fund) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getPartnerId() == null ? other.getPartnerId() == null
						: this.getPartnerId().equals(other.getPartnerId()))
				&& (this.getAtTime() == null ? other.getAtTime() == null : this.getAtTime().equals(other.getAtTime()))
				&& (this.getDebitAmount() == null ? other.getDebitAmount() == null
						: this.getDebitAmount().equals(other.getDebitAmount()))
				&& (this.getCreditAmount() == null ? other.getCreditAmount() == null
						: this.getCreditAmount().equals(other.getCreditAmount()))
				&& (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
				&& (this.getBankName() == null ? other.getBankName() == null
						: this.getBankName().equals(other.getBankName()))
				&& (this.getBankAccount() == null ? other.getBankAccount() == null
						: this.getBankAccount().equals(other.getBankAccount()))
				&& (this.getPayee() == null ? other.getPayee() == null : this.getPayee().equals(other.getPayee()))
				&& (this.getOpeningBankName() == null ? other.getOpeningBankName() == null
						: this.getOpeningBankName().equals(other.getOpeningBankName()));
	}

	/**
	 * @mbggenerated
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
		result = prime * result + ((getAtTime() == null) ? 0 : getAtTime().hashCode());
		result = prime * result + ((getDebitAmount() == null) ? 0 : getDebitAmount().hashCode());
		result = prime * result + ((getCreditAmount() == null) ? 0 : getCreditAmount().hashCode());
		result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
		result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
		result = prime * result + ((getBankAccount() == null) ? 0 : getBankAccount().hashCode());
		result = prime * result + ((getPayee() == null) ? 0 : getPayee().hashCode());
		result = prime * result + ((getOpeningBankName() == null) ? 0 : getOpeningBankName().hashCode());
		return result;
	}

	/**
	 * @mbggenerated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", partnerId=").append(partnerId);
		sb.append(", atTime=").append(atTime);
		sb.append(", debitAmount=").append(debitAmount);
		sb.append(", creditAmount=").append(creditAmount);
		sb.append(", source=").append(source);
		sb.append(", bankName=").append(bankName);
		sb.append(", bankAccount=").append(bankAccount);
		sb.append(", payee=").append(payee);
		sb.append(", openingBankName=").append(openingBankName);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}

	/**
	 * 借方金额（单位为分）
	 */
	private Integer debitAmount = 0;
	/**
	 * 贷方金额（单位为分）
	 */
	private Integer creditAmount = 0;
}