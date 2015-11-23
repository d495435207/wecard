package com.dxj.wecard.bean.order;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = { "ecid", "pw" })
public class HeadReq {
	private String ecid;
	private String pw;

	public String getEcid() {
		return ecid;
	}

	public void setEcid(String ecid) {
		this.ecid = ecid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}