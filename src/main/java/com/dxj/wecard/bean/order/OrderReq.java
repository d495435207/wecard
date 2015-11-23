package com.dxj.wecard.bean.order;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = { "head", "body" })
public class OrderReq {
	private HeadReq head;
	private BodyReq body;

	public HeadReq getHead() {
		return head;
	}

	public void setHead(HeadReq head) {
		this.head = head;
	}

	public BodyReq getBody() {
		return body;
	}

	public void setBody(BodyReq body) {
		this.body = body;
	}
}