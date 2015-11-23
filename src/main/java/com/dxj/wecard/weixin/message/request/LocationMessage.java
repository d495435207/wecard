package com.dxj.wecard.weixin.message.request;
/**
 * 微信用户推送位置消息
 * 类LocationMessage.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年9月29日 上午10:30:37
 */
public class LocationMessage extends BaseMassage {
	private String Location_X;
	private String Location_Y;
	//缩放大小
	private String Scale;
	//地理位置信息
	private String Label;
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String locationX) {
		Location_X = locationX;
	}
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String locationY) {
		Location_Y = locationY;
	}
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
}

