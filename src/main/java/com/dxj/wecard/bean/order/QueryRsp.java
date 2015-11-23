package com.dxj.wecard.bean.order;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = { "code", "data" })
public class QueryRsp {
	private String code;
	private List<DataQueryRsp> data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<DataQueryRsp> getData() {
		return data;
	}

	public void setData(List<DataQueryRsp> data) {
		this.data = data;
	}
}