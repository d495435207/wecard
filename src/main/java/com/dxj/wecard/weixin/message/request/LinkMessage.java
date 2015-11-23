package com.dxj.wecard.weixin.message.request;

/**
 * 微信用户推送链接消息
 * 类LinkMessage.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年9月29日 上午10:29:51
 */
public class LinkMessage extends BaseMassage {
	private String Title;
	private String Description;
	private String Url;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
}
