package com.dxj.wecard.weixin.message.request;

/**
 * 微信用户推送文本消息
 * 类TextMessage.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年9月29日 上午10:30:54
 */
public class TextMessage extends BaseMassage {
	//消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String Content) {
		this.Content = Content;
	}
}
