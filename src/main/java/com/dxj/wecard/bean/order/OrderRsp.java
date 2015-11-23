package com.dxj.wecard.bean.order;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = { "code", "data" })
public class OrderRsp {
	private String code;
	private DataOrderRsp data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DataOrderRsp getData() {
		return data;
	}

	public void setData(DataOrderRsp data) {
		this.data = data;
	}
}