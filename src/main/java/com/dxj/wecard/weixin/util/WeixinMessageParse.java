package com.dxj.wecard.weixin.util;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dxj.wecard.weixin.message.response.TextMessage;
import com.dxj.wecard.weixin.qq.aes.WXBizMsgCrypt;

/**
 * 处理微信发来的请求
 * 
 * @author liulihai
 * 
 */
public class WeixinMessageParse {
    static final Logger logger = LogManager.getLogger(WeixinMessageParse.class);

	public static String parseRequest(HttpServletRequest request) {
		String resp = null;
		// 默认范围的消息内容
		String respContext = "";
		try {
			Map<String, String> requestMap = WeixinXmlUtils.parseXml(request);
			// 发送方账号
			String fromUserName = requestMap.get("FromUserName");
			// 开发者账号
			String toUserName = requestMap.get("ToUserName");
			String msgType = requestMap.get("MsgType");
			resp = requestMap.get("event_type");
			if (msgType == null) {
				return "success";
			} else {
				if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_TEXT)) {
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(WeixinXmlUtils.RESPONSE_MESSAGE_TYPE_TEXT);
					String content = requestMap.get("Content").trim();
					resp = content + "_callback";

				} else if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_IMAGE)) {

				} else if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_LINK)) {
					respContext = "你发的连接消息";
				} else if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_LOCATION)) {
					respContext = "你发的位置消息";
				} else if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_VODEO)) {
					respContext = "你发的视频消息";
				} else if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_VOICE)) {
					// 语音消息
					String content = requestMap.get("Recognition").trim();
					respContext = content;
				} else if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_EVENT)) {

					String eventType = requestMap.get("Event");
					System.out.println("eventType值为:" + resp);
					if (resp == null && "".equals(resp)) {
						resp = eventType;
					}
					if (eventType.equals(WeixinXmlUtils.EVENT_TYPE_SUNSCRIBE)) {
						
					} else if (eventType.equals(WeixinXmlUtils.EVENT_TYPE_CLICK)) {
						// TODO 菜单点击事件
					} else if (eventType.equals(WeixinXmlUtils.EVENT_TYPE_LOCATION)) {
						// TODO 未知时间
					} else if (eventType.equals(WeixinXmlUtils.EVENT_TYPE_SCAN)) {
						// TODO 扫描二维码时间
					} else if (eventType.equals(WeixinXmlUtils.EVENT_TYPE_UNSUBSCRIBE)) {
						// TODO 取消关注事件
					}
					respContext = "你发的图片消息";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("coreService返回值" + resp);
		return resp;
	}
	/**
	 * 
	 * @param xml
	 * @return
	 * @author liulihai 2015年10月13日 下午2:50:10
	 */
	public static String parseString(String xml) {
		String resp = null;
		// 默认范围的消息内容
		try {
			Map<String, String> requestMap = WeixinXmlUtils.parseXmlFromStr(xml);
			// 发送方账号
			String fromUserName = requestMap.get("FromUserName");
			// 开发者账号
			String toUserName = requestMap.get("ToUserName");
			String msgType = requestMap.get("MsgType");
			Long timestamp = null;
			if (msgType == null) {
				return "success";
			} else {
				if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_TEXT)) {
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					timestamp = new Date().getTime();
					textMessage.setCreateTime(timestamp);
					textMessage.setMsgType(WeixinXmlUtils.RESPONSE_MESSAGE_TYPE_TEXT);
					String content = requestMap.get("Content").trim();
					if (content.startsWith("QUERY_AUTH_CODE")) {
						String[] type = content.split(":");
						textMessage.setContent(type[1] + "_from_api");
						resp = WeixinXmlUtils.messageToXml(textMessage);
						System.out.println("API转换toXml" + resp);
						logger.info("API转换toXml" + resp);
						resp = encodeMsg(resp, timestamp);
					} else {
						textMessage.setContent(content + "_callback");
						resp = WeixinXmlUtils.messageToXml(textMessage);
						System.out.println("文本toXml" + resp);
						logger.info("文本toXml" + resp);
						resp = encodeMsg(resp, timestamp);
					}

				} else if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_IMAGE)) {

				} else if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_LINK)) {
				} else if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_LOCATION)) {
				} else if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_VODEO)) {
				} else if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_VOICE)) {
					// 语音消息
				} else if (msgType.equals(WeixinXmlUtils.REQUEST_MESSAGE_TYPE_EVENT)) {

					String eventType = requestMap.get("Event");
					if (eventType.equals(WeixinXmlUtils.EVENT_TYPE_SUNSCRIBE)) {
						
					} else if (eventType.equals(WeixinXmlUtils.EVENT_TYPE_CLICK)) {
						// TODO 菜单点击事件
					} else if (eventType.equals(WeixinXmlUtils.EVENT_TYPE_LOCATION)) {
						TextMessage textMessage = new TextMessage();
						textMessage.setToUserName(fromUserName);
						textMessage.setFromUserName(toUserName);
						timestamp = new Date().getTime();
						textMessage.setCreateTime(timestamp);
						textMessage.setMsgType(WeixinXmlUtils.RESPONSE_MESSAGE_TYPE_TEXT);
						// String content = requestMap.get("Content").trim();
						textMessage.setContent("LOCATIONfrom"+"_callback");
						resp = WeixinXmlUtils.messageToXml(textMessage);
//						logger.error("事件toXml" + resp);
						resp = encodeMsg(resp, timestamp);
//						Map<String, String> enMap = MessageUtil.parseXmlFromStr(resp);
//						WXBizMsgCrypt pc = new WXBizMsgCrypt("wo8335224", "AJNWhVF59O9rouopAojRh95plpOrsOXm3GZPxeko2yM", "wx38cda8b857eb1134");
//						String reqult=pc.decryptMsg(enMap.get("MsgSignature"), enMap.get("TimeStamp"), enMap.get("Nonce"), resp);
//						System.out.println("再解密出来" + reqult);
//						logger.error("再解密出来" + reqult);
						// TODO 未知时间
					} else if (eventType.equals(WeixinXmlUtils.EVENT_TYPE_SCAN)) {
						// TODO 扫描二维码时间
					} else if (eventType.equals(WeixinXmlUtils.EVENT_TYPE_UNSUBSCRIBE)) {
						// TODO 取消关注事件
					}
					

				}
			}

			// textMessage.setContent(respContext);
			// respXml = MessageUtil.messageToXml(textMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
	/**
	 * 消息加密
	 * @param resp
	 * @param timestamp
	 * @return
	 * @throws Exception
	 * @author liulihai 2015年10月8日 上午9:29:43
	 */
	private static String encodeMsg(String resp, Long timestamp) throws Exception {
		WXBizMsgCrypt pc = new WXBizMsgCrypt(WeixinConstant.TOKEN, WeixinConstant.KEY, WeixinConstant.COMPONENTAPPID);
		String radnom = UUID.randomUUID().toString().substring(0, 6);
		return pc.encryptMsg(resp, Long.toString(timestamp), radnom);
	}

}
