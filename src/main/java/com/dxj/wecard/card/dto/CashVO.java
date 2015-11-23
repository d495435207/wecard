package com.dxj.wecard.card.dto;

public class CashVO {
	private BaseInfoVO base_info;	//基本的卡券数据
	private String least_cost;	//起用金额（单位为分）
	private String reduce_cost;	//减免金额（单位为分）
	
	public BaseInfoVO getBase_info() {
		return base_info;
	}
	public void setBase_info(BaseInfoVO base_info) {
		this.base_info = base_info;
	}
	public String getLeast_cost() {
		return least_cost;
	}
	public void setLeast_cost(String least_cost) {
		this.least_cost = least_cost;
	}
	public String getReduce_cost() {
		return reduce_cost;
	}
	public void setReduce_cost(String reduce_cost) {
		this.reduce_cost = reduce_cost;
	}

}
