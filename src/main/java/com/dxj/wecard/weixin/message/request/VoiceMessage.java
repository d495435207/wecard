package com.dxj.wecard.weixin.message.request;

/**
 * 微信用户推送语音消息
 * 类VoiceMessage.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年9月29日 上午10:32:14
 */
public class VoiceMessage extends BaseMassage {
	private String MediaId;
	private String Format;
	private String Recognition;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getRecognition() {
		return Recognition;
	}
	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
	
}
