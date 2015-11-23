package com.dxj.wecard.card.dto;

public class GrouponVO {
	private BaseInfoVO base_info;	//基本的卡券数据
	private String deal_detail;	//团购详情
	
	public BaseInfoVO getBase_info() {
		return base_info;
	}
	public void setBase_info(BaseInfoVO base_info) {
		this.base_info = base_info;
	}
	public String getDeal_detail() {
		return deal_detail;
	}
	public void setDeal_detail(String deal_detail) {
		this.deal_detail = deal_detail;
	}

}
