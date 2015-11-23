package com.dxj.wecard.card.enums;

/** 卡券类型
 * @author haiqing
 *
 */
public enum CardCouponTypeEnum {
	/**
	 * 通用券
	 */
	GENERAL_COUPON("GENERAL_COUPON", "5"),
	/**
	 * 团购券
	 */
	GROUPON("GROUPON", "3"),
	/**
	 * 折扣券
	 */
	DISCOUNT("DISCOUNT", "4"),
	/**
	 * 礼品券
	 */
	GIFT("GIFT", "1"),
	/**
	 * 代金券
	 */
	CASH("CASH", "2"),

	MEMBER_CARD("MEMBER_CARD", "会员卡"),

	SCENIC_TICKET("SCENIC_TICKET", "景点门票"),

	MOVIE_TICKET("MOVIE_TICKET", "电影票"),
	
	BOARDING_PASS("BOARDING_PASS", "飞机票"),

	LUCKY_MONEY("LUCKY_MONEY", "红包"),

	MEETING_TICKET("meeting_ticket", "会议门票")	;
	
	private String value;
	private String description;
	
	CardCouponTypeEnum(String value, String description){
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
