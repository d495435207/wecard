package com.dxj.wecard.weixin.message.request;

/**
 * 微信推送消息baseMessage
 * 类BaseMassage.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年9月29日 上午10:26:27
 */
public class BaseMassage {
	//开发者微信号
	private String ToUserName;
	//微信用户号
	private String FromUserName;
	private Long CreateTime;
	private String MsgType;
	private Long MsgId;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public Long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public Long getMsgId() {
		return MsgId;
	}
	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}

}
