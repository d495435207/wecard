package com.dxj.wecard.card.dto;

public class DateInfoVO {
	private Integer type;	//有效期类型 1-固定日期区间	2-固定时长
	private Long begin_timestamp;	//开始时间戳
	private Long end_timestamp;	//结束时间戳
	private Integer fixed_term;	//有效天数
	private Integer fixed_begin_term;	//起效日期
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getBegin_timestamp() {
		return begin_timestamp;
	}
	public void setBegin_timestamp(Long begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}
	public Long getEnd_timestamp() {
		return end_timestamp;
	}
	public void setEnd_timestamp(Long end_timestamp) {
		this.end_timestamp = end_timestamp;
	}
	public Integer getFixed_term() {
		return fixed_term;
	}
	public void setFixed_term(Integer fixed_term) {
		this.fixed_term = fixed_term;
	}
	public Integer getFixed_begin_term() {
		return fixed_begin_term;
	}
	public void setFixed_begin_term(Integer fixed_begin_term) {
		this.fixed_begin_term = fixed_begin_term;
	}
	
}
