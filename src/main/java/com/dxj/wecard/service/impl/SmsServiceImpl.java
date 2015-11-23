package com.dxj.wecard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.bean.SmsGwInfo;
import com.dxj.wecard.bean.SmsResult;
import com.dxj.wecard.service.SmsService;
import com.dxj.wecard.util.ClientUtil;
import com.dxj.wecard.util.MD5;
import com.dxj.wecard.util.Seq;
import com.dxj.wecard.weixin.util.WeixinHttpsRequest;

@Service("smsService")
public class SmsServiceImpl implements SmsService {

	static final Logger logger = LogManager.getLogger(SmsServiceImpl.class);

	@Autowired
	private SmsGwInfo smsGwInfo;

	@Override
	public int send(String content, String phone) {
		Map<String, String> params = new HashMap<String, String>();
		int msgId = Seq.getRawSeq();
		params.put("msgId", "" + msgId);
		params.put("mobileNo", phone);
		params.put("type", "verification");
		params.put("from", smsGwInfo.getFrom());
		params.put("content", content);
		String sign = MD5.GetMD5Code(msgId + smsGwInfo.getKey() + phone);
		params.put("sign", sign);
		try {
			String response = ClientUtil.sendPost(smsGwInfo.getUrl(), JSON.toJSONString(params)).toString();
			SmsResult result = JSON.parseObject(response, SmsResult.class);
			return result.getResultCode();
		} catch (Exception e) {
			logger.error("发送短信异常：", e);
		}
		return 0;
	}
	public static String getMsgId(){
        String msg=""+System.currentTimeMillis();
        return msg.substring(6, 12);
    }
}