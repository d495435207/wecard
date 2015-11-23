package com.dxj.wecard.weixin.message.response;

public class TextMessage extends BaseMessage {
	//消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String Content) {
		this.Content = Content;
	}
}
