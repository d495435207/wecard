package com.dxj.wecard.card.dto;

public class DiscountVO {
	private BaseInfoVO base_info;	//基本的卡券数据
	private String discount;	//打折额度（百分比）,填 30 就是七折
	
	public BaseInfoVO getBase_info() {
		return base_info;
	}
	public void setBase_info(BaseInfoVO base_info) {
		this.base_info = base_info;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}

}
