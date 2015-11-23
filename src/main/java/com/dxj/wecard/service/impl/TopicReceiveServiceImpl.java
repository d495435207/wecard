package com.dxj.wecard.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.dxj.wecard.service.TopicReceiveService;

@Service("topicReceiveService")
public class TopicReceiveServiceImpl implements TopicReceiveService, MessageListener {

	static final Logger logger = LogManager.getLogger(TopicReceiveServiceImpl.class);

	@Override
	public void onMessage(Message message) {
		try {
			logger.info("TopicReceiveService 接收到消息:" + (String) ((ObjectMessage) message).getObject());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}