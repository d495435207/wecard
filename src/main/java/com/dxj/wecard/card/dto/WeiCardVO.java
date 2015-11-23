package com.dxj.wecard.card.dto;

public class WeiCardVO {
	private String card_id;
	private CardExtVO card_ext;	//卡券的唯一性信息
	
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public CardExtVO getCard_ext() {
		return card_ext;
	}
	public void setCard_ext(CardExtVO card_ext) {
		this.card_ext = card_ext;
	}
	
	
}
