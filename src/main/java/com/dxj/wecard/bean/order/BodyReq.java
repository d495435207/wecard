package com.dxj.wecard.bean.order;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = { "cardid" })
public class BodyReq {
	private String cardid;

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
}