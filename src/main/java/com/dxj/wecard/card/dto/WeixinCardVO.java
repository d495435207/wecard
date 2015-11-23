package com.dxj.wecard.card.dto;

import com.dxj.wecard.card.enums.CardCouponTypeEnum;

public class WeixinCardVO {
	private String card_type;
	private GeneralCouponVO general_coupon;
	private GrouponVO groupon;
	private GiftVO gift;
	private CashVO cash;
	private DiscountVO discount;
	
	
    public String getCard_type() {
        return card_type;
    }
    
    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }
    public GeneralCouponVO getGeneral_coupon() {
		return general_coupon;
	}
	public void setGeneral_coupon(GeneralCouponVO general_coupon) {
		this.general_coupon = general_coupon;
	}
	public GrouponVO getGroupon() {
		return groupon;
	}
	public void setGroupon(GrouponVO groupon) {
		this.groupon = groupon;
	}
	public GiftVO getGift() {
		return gift;
	}
	public void setGift(GiftVO gift) {
		this.gift = gift;
	}
	public CashVO getCash() {
		return cash;
	}
	public void setCash(CashVO cash) {
		this.cash = cash;
	}
	public DiscountVO getDiscount() {
		return discount;
	}
	public void setDiscount(DiscountVO discount) {
		this.discount = discount;
	}
	
}
