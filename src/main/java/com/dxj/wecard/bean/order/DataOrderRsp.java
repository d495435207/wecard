package com.dxj.wecard.bean.order;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = { "cardid", "outerid" })
public class DataOrderRsp {
	private String cardid;
	private String outerid;

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getOuterid() {
		return outerid;
	}

	public void setOuterid(String outerid) {
		this.outerid = outerid;
	}
}