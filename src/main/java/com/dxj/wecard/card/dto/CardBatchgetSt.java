package com.dxj.wecard.card.dto;

import com.alibaba.fastjson.JSONArray;

public class CardBatchgetSt {
	private int offset;
	private int count;
	private JSONArray status_list;

	public CardBatchgetSt() {
		super();
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public JSONArray getStatus_list() {
		return status_list;
	}

	public void setStatus_list(JSONArray status_list) {
		this.status_list = status_list;
	}
}
