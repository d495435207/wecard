package com.dxj.wecard.card.dto;

/**
 * @author haiqing
 *
 */
public class GeneralCouponVO {
	private BaseInfoVO base_info;	//基本的卡券数据
	private String default_detail;	//描述文本
	
	public BaseInfoVO getBase_info() {
		return base_info;
	}
	public void setBase_info(BaseInfoVO base_info) {
		this.base_info = base_info;
	}
	public String getDefault_detail() {
		return default_detail;
	}
	public void setDefault_detail(String default_detail) {
		this.default_detail = default_detail;
	}
	
}
