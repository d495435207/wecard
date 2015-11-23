package com.dxj.wecard.card.dto;

public class CardExtVO {
	private String code;	//use_custom_code 字段为 true 的卡券必须填写
	private String openid;	//bind_openid 字段为 true 的卡券必须填写
	private String timestamp;	//时间戳（秒数）
	private String signature;	//签名， 签名方式使用SHA1
	private String outer_id;	//场景参数值
	private String balance;	//红包余额，以分为单位。红包类型必填（LUCKY_MONEY），其他卡券类型不填
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getOuter_id() {
		return outer_id;
	}
	public void setOuter_id(String outer_id) {
		this.outer_id = outer_id;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "code:" + code + ",openid:" + openid
				+ ",timestamp:" + timestamp + ",signature:" + signature
				+ ",outer_id:" + outer_id + ",balance:" + balance;
	}
	
}
