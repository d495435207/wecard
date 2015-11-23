package com.dxj.wecard.card.dto;

public class DateInfo {
	private Integer type;//使用时间的类型1：固定日期区间，2：固定时长（自领取后按天算）
	private Long begin_timestamp;
	private Long end_timestamp;
	private Integer fixed_term;//固定时长专用，表示自领取后多少天内有效。（单位为天）领取后当天有效填写0
	private Integer fixed_begin_term;//固定时长专用，表示自领取后多少天开始生效。（单位为天）
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
