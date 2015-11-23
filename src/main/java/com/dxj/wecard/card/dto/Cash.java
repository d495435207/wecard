package com.dxj.wecard.card.dto;

public class Cash {
	private Integer least_cost;
	private Integer reduce_cost;
	private BaseInfo base_info;
	public Integer getLeast_cost() {
		return least_cost;
	}

	public void setLeast_cost(Integer least_cost) {
		this.least_cost = least_cost;
	}

	public Integer getReduce_cost() {
		return reduce_cost;
	}

	public void setReduce_cost(Integer reduce_cost) {
		this.reduce_cost = reduce_cost;
	}

	public BaseInfo getBase_info() {
		return base_info;
	}

	public void setBase_info(BaseInfo base_info) {
		this.base_info = base_info;
	}

}
