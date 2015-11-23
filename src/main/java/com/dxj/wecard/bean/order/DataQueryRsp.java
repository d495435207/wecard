package com.dxj.wecard.bean.order;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = { "cardid", "w_appid", "w_name", "w_logo", "w_cardid", "title", "sub_title", "status", "quantity",
		"cost", "color", "date_info", "type" })
public class DataQueryRsp {
	private String cardid;
	private String w_appid;
	private String w_name;
	private String w_logo;
	private String w_cardid;
	private String title;
	private String sub_title;
	private String status;
	private String quantity;
	private String cost;
	private String color;
	private String date_info;
	private String type;

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getW_appid() {
		return w_appid;
	}

	public void setW_appid(String w_appid) {
		this.w_appid = w_appid;
	}

	public String getW_name() {
		return w_name;
	}

	public void setW_name(String w_name) {
		this.w_name = w_name;
	}

	public String getW_logo() {
		return w_logo;
	}

	public void setW_logo(String w_logo) {
		this.w_logo = w_logo;
	}

	public String getW_cardid() {
		return w_cardid;
	}

	public void setW_cardid(String w_cardid) {
		this.w_cardid = w_cardid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSub_title() {
		return sub_title;
	}

	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDate_info() {
		return date_info;
	}

	public void setDate_info(String date_info) {
		this.date_info = date_info;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
}