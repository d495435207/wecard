package com.dxj.wecard.weixin.message.request;
/**
 * 
 * 微信用户推送图片消息
 * @author liulihai
 *
 */
public class ImageMessage extends BaseMassage {
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String PicUrl) {
		this.PicUrl = PicUrl;
	}

}
