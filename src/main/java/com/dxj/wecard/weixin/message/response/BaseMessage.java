package com.dxj.wecard.weixin.message.response;

/**
 *  平台推送消息给微信用户BaseMessage
 *  
 *  * 类BaseMessage.java的实现描述：TODO 类实现描述 
 *  
 * @author liulihai 2015年9月29日 上午10:32:50
 */
public class BaseMessage {
	//接收方账号openId
	private String ToUserName;
	//开发者账号
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
