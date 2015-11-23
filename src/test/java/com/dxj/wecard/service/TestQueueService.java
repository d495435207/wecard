package com.dxj.wecard.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-spring.xml",
		"classpath:applicationContext-mybatis.xml", "classpath:applicationContext-activemq.xml",
		"classpath:applicationContext-redis.xml" })
public class TestQueueService {

	static final Logger logger = LogManager.getLogger(TestQueueService.class);

	@Autowired
	private QueueSendService queueSendService;

	@Autowired
	private TopicSendService topicSendService;

	@Test
	public void testQueueSend() {
		queueSendService.send("wecard.queue", "test.queue");
		queueSendService.send("test.queue");
	}

	@Test
	public void testTopicSend() {
		topicSendService.send("wecard.topic", "test.topic");
		topicSendService.send("test.topic");
	}
}
