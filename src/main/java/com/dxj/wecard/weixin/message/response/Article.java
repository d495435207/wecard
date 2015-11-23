package com.dxj.wecard.weixin.message.response;

/**
 * 图文消息model
 * 类Article.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年9月29日 上午10:32:37
 */
public class Article {
	private String Title;
	private String Description;
	private String PicUrl;
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
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	//图文消息跳转连接
	private String Url;
	
}
