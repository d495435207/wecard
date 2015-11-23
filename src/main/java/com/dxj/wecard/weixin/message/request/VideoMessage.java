package com.dxj.wecard.weixin.message.request;

/**
 * 微信用户推送视频消息
 * 类VideoMessage.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年9月29日 上午10:31:18
 */
public class VideoMessage extends BaseMassage{
	private String MediaId;
	private String ThumbMediaId;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	
}
