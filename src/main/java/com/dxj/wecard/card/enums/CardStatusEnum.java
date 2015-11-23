package com.dxj.wecard.card.enums;

public enum CardStatusEnum {
	/**
	 * 审核中
	 */
	ON_CHECK("ON_CHECK", "审核中"),
	/**
	 * 未通过
	 */
	FAIL("FAIL", "未通过"),
	/**
	 * 待投放
	 */
	WAIT_THROW("WAIT_THROW", "待投放"),
	/**
	 * 已投放
	 */
	ON_THROW("ON_THROW", "已投放"),
	/**
	 * 已过期
	 */
	OUT_OF_DATE("OUT_OF_DATE", "已过期"),
	/**
	 * 已删除
	 */
	N("N", "已删除");
	
	private String value;
	private String description;
	
	CardStatusEnum(String value, String description){
        this.value = value;
        this.description = description;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    @Override
    public String toString() {
        return value;
    }

}
