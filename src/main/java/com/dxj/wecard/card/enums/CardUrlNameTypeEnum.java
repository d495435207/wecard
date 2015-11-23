package com.dxj.wecard.card.enums;

/** 商户自定义 cell 名称
 * @author haiqing
 *
 */
public enum CardUrlNameTypeEnum {
	/**
	 * 外卖
	 */
	URL_NAME_TYPE_TAKE_AWAY("URL_NAME_TYPE_TAKE_AWAY", "外卖"),
	/**
	 * 在线预订
	 */
	URL_NAME_TYPE_RESERVATION("URL_NAME_TYPE_RESERVATION", "在线预订"),
	/**
	 * 立即使用
	 */
	URL_NAME_TYPE_USE_IMMEDIATELY("URL_NAME_TYPE_USE_IMMEDIATELY", "立即使用"),
	/**
	 * 在线预约
	 */
	URL_NAME_TYPE_APPOINTMENT("URL_NAME_TYPE_APPOINTMENT", "在线预约"),
	/**
	 * 在线兑换
	 */
	URL_NAME_TYPE_EXCHANGE("URL_NAME_TYPE_EXCHANGE", "在线兑换"),
	/**
	 * 会 员 服 务(仅会员卡类型可用)
	 */
	URL_NAME_TYPE_VIP_SERVICE("URL_NAME_TYPE_VIP_SERVICE","会 员 服 务(仅会员卡类型可用)");
	
	private String value;
	private String description;
	
	CardUrlNameTypeEnum(String value, String description){
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
