package com.dxj.wecard.model;

import java.io.Serializable;

public class Partner implements Serializable {

	/**
	 * 合作伙伴id
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * 合作伙伴角色，0为卡劵发行商，1为卡劵承销商
	 * @mbggenerated
	 */
	private Integer role;
	/**
	 * 承销商开发id
	 * @mbggenerated
	 */
	private String devId;
	/**
	 * 承销商开发secret
	 * @mbggenerated
	 */
	private String devSecret;
	/**
	 * 分成比例（百分比）
	 * @mbggenerated
	 */
	private Integer shareRate;
	/**
	 * 银行名称
	 * @mbggenerated
	 */
	private String bankName;
	/**
	 * 收款方
	 * @mbggenerated
	 */
	private String payee;
	/**
	 * 开户行名称
	 * @mbggenerated
	 */
	private String openingBankName;
	/**
	 * 银行账号
	 * @mbggenerated
	 */
	private String bankAccount;
	/**
	 * 商户所在公司名称
	 * @mbggenerated
	 */
	private String company;
	/**
	 * 联系人
	 * @mbggenerated
	 */
	private String contacts;
	/**
	 * 联系电话
	 * @mbggenerated
	 */
	private String phone;
	/**
	 * 联系邮箱
	 * @mbggenerated
	 */
	private String mail;
	/**
	 * 国家
	 * @mbggenerated
	 */
	private String country;
	/**
	 * 省
	 * @mbggenerated
	 */
	private String province;
	/**
	 * 城市
	 * @mbggenerated
	 */
	private String city;
	/**
	 * 区
	 * @mbggenerated
	 */
	private String district;
	/**
	 * 地址
	 * @mbggenerated
	 */
	private String address;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of partner.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id  the value for partner.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return  the value of partner.role
	 * @mbggenerated
	 */
	public Integer getRole() {
		return role;
	}

	/**
	 * @param role  the value for partner.role
	 * @mbggenerated
	 */
	public void setRole(Integer role) {
		this.role = role;
	}

	/**
	 * @return  the value of partner.dev_id
	 * @mbggenerated
	 */
	public String getDevId() {
		return devId;
	}

	/**
	 * @param devId  the value for partner.dev_id
	 * @mbggenerated
	 */
	public void setDevId(String devId) {
		this.devId = devId == null ? null : devId.trim();
	}

	/**
	 * @return  the value of partner.dev_secret
	 * @mbggenerated
	 */
	public String getDevSecret() {
		return devSecret;
	}

	/**
	 * @param devSecret  the value for partner.dev_secret
	 * @mbggenerated
	 */
	public void setDevSecret(String devSecret) {
		this.devSecret = devSecret == null ? null : devSecret.trim();
	}

	/**
	 * @return  the value of partner.share_rate
	 * @mbggenerated
	 */
	public Integer getShareRate() {
		return shareRate;
	}

	/**
	 * @param shareRate  the value for partner.share_rate
	 * @mbggenerated
	 */
	public void setShareRate(Integer shareRate) {
		this.shareRate = shareRate;
	}

	/**
	 * @return  the value of partner.bank_name
	 * @mbggenerated
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName  the value for partner.bank_name
	 * @mbggenerated
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName == null ? null : bankName.trim();
	}

	/**
	 * @return  the value of partner.payee
	 * @mbggenerated
	 */
	public String getPayee() {
		return payee;
	}

	/**
	 * @param payee  the value for partner.payee
	 * @mbggenerated
	 */
	public void setPayee(String payee) {
		this.payee = payee == null ? null : payee.trim();
	}

	/**
	 * @return  the value of partner.opening_bank_name
	 * @mbggenerated
	 */
	public String getOpeningBankName() {
		return openingBankName;
	}

	/**
	 * @param openingBankName  the value for partner.opening_bank_name
	 * @mbggenerated
	 */
	public void setOpeningBankName(String openingBankName) {
		this.openingBankName = openingBankName == null ? null : openingBankName.trim();
	}

	/**
	 * @return  the value of partner.bank_account
	 * @mbggenerated
	 */
	public String getBankAccount() {
		return bankAccount;
	}

	/**
	 * @param bankAccount  the value for partner.bank_account
	 * @mbggenerated
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount == null ? null : bankAccount.trim();
	}

	/**
	 * @return  the value of partner.company
	 * @mbggenerated
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company  the value for partner.company
	 * @mbggenerated
	 */
	public void setCompany(String company) {
		this.company = company == null ? null : company.trim();
	}

	/**
	 * @return  the value of partner.contacts
	 * @mbggenerated
	 */
	public String getContacts() {
		return contacts;
	}

	/**
	 * @param contacts  the value for partner.contacts
	 * @mbggenerated
	 */
	public void setContacts(String contacts) {
		this.contacts = contacts == null ? null : contacts.trim();
	}

	/**
	 * @return  the value of partner.phone
	 * @mbggenerated
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone  the value for partner.phone
	 * @mbggenerated
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	/**
	 * @return  the value of partner.mail
	 * @mbggenerated
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail  the value for partner.mail
	 * @mbggenerated
	 */
	public void setMail(String mail) {
		this.mail = mail == null ? null : mail.trim();
	}

	/**
	 * @return  the value of partner.country
	 * @mbggenerated
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country  the value for partner.country
	 * @mbggenerated
	 */
	public void setCountry(String country) {
		this.country = country == null ? null : country.trim();
	}

	/**
	 * @return  the value of partner.province
	 * @mbggenerated
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province  the value for partner.province
	 * @mbggenerated
	 */
	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	/**
	 * @return  the value of partner.city
	 * @mbggenerated
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city  the value for partner.city
	 * @mbggenerated
	 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	/**
	 * @return  the value of partner.district
	 * @mbggenerated
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district  the value for partner.district
	 * @mbggenerated
	 */
	public void setDistrict(String district) {
		this.district = district == null ? null : district.trim();
	}

	/**
	 * @return  the value of partner.address
	 * @mbggenerated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address  the value for partner.address
	 * @mbggenerated
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}Partner other=(Partner)that;return (this.getId() == null?other.getId() == null:this.getId().equals(other.getId())) && (this.getRole() == null?other.getRole() == null:this.getRole().equals(other.getRole())) && (this.getDevId() == null?other.getDevId() == null:this.getDevId().equals(other.getDevId())) && (this.getDevSecret() == null?other.getDevSecret() == null:this.getDevSecret().equals(other.getDevSecret())) && (this.getShareRate() == null?other.getShareRate() == null:this.getShareRate().equals(other.getShareRate())) && (this.getBankName() == null?other.getBankName() == null:this.getBankName().equals(other.getBankName())) && (this.getPayee() == null?other.getPayee() == null:this.getPayee().equals(other.getPayee())) && (this.getOpeningBankName() == null?other.getOpeningBankName() == null:this.getOpeningBankName().equals(other.getOpeningBankName())) && (this.getBankAccount() == null?other.getBankAccount() == null:this.getBankAccount().equals(other.getBankAccount())) && (this.getCompany() == null?other.getCompany() == null:this.getCompany().equals(other.getCompany())) && (this.getContacts() == null?other.getContacts() == null:this.getContacts().equals(other.getContacts())) && (this.getPhone() == null?other.getPhone() == null:this.getPhone().equals(other.getPhone())) && (this.getMail() == null?other.getMail() == null:this.getMail().equals(other.getMail())) && (this.getCountry() == null?other.getCountry() == null:this.getCountry().equals(other.getCountry())) && (this.getProvince() == null?other.getProvince() == null:this.getProvince().equals(other.getProvince())) && (this.getCity() == null?other.getCity() == null:this.getCity().equals(other.getCity())) && (this.getDistrict() == null?other.getDistrict() == null:this.getDistrict().equals(other.getDistrict())) && (this.getAddress() == null?other.getAddress() == null:this.getAddress().equals(other.getAddress()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getId() == null)?0:getId().hashCode());result=prime * result + ((getRole() == null)?0:getRole().hashCode());result=prime * result + ((getDevId() == null)?0:getDevId().hashCode());result=prime * result + ((getDevSecret() == null)?0:getDevSecret().hashCode());result=prime * result + ((getShareRate() == null)?0:getShareRate().hashCode());result=prime * result + ((getBankName() == null)?0:getBankName().hashCode());result=prime * result + ((getPayee() == null)?0:getPayee().hashCode());result=prime * result + ((getOpeningBankName() == null)?0:getOpeningBankName().hashCode());result=prime * result + ((getBankAccount() == null)?0:getBankAccount().hashCode());result=prime * result + ((getCompany() == null)?0:getCompany().hashCode());result=prime * result + ((getContacts() == null)?0:getContacts().hashCode());result=prime * result + ((getPhone() == null)?0:getPhone().hashCode());result=prime * result + ((getMail() == null)?0:getMail().hashCode());result=prime * result + ((getCountry() == null)?0:getCountry().hashCode());result=prime * result + ((getProvince() == null)?0:getProvince().hashCode());result=prime * result + ((getCity() == null)?0:getCity().hashCode());result=prime * result + ((getDistrict() == null)?0:getDistrict().hashCode());result=prime * result + ((getAddress() == null)?0:getAddress().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", id=").append(id);sb.append(", role=").append(role);sb.append(", devId=").append(devId);sb.append(", devSecret=").append(devSecret);sb.append(", shareRate=").append(shareRate);sb.append(", bankName=").append(bankName);sb.append(", payee=").append(payee);sb.append(", openingBankName=").append(openingBankName);sb.append(", bankAccount=").append(bankAccount);sb.append(", company=").append(company);sb.append(", contacts=").append(contacts);sb.append(", phone=").append(phone);sb.append(", mail=").append(mail);sb.append(", country=").append(country);sb.append(", province=").append(province);sb.append(", city=").append(city);sb.append(", district=").append(district);sb.append(", address=").append(address);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}