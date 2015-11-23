package com.dxj.wecard.card.dto;

public class GiftVO {
	private BaseInfoVO base_info;	//基本的卡券数据
	private String gift;	//礼品名称
	
	public BaseInfoVO getBase_info() {
		return base_info;
	}
	public void setBase_info(BaseInfoVO base_info) {
		this.base_info = base_info;
	}
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}

}
