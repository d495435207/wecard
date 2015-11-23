package com.dxj.wecard.card.dto;


public class WxGiftCard {
	private String card_type;
	private Gift gift;
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public Gift getGift() {
		return gift;
	}
	public void setGift(Gift gift) {
		this.gift = gift;
	}
}
