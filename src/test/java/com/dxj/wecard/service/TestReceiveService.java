package com.dxj.wecard.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.bean.Query;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-spring.xml",
		"classpath:applicationContext-mybatis.xml", "classpath:applicationContext-activemq.xml",
		"classpath:applicationContext-redis.xml" })
public class TestReceiveService {

	static final Logger logger = LogManager.getLogger(TestReceiveService.class);

	@Autowired
	private ReceiveService receiveService;

	@Test
	public void testQueryByPid() {
		Query statInfo= receiveService.getReceiveCountByApp("1");
		logger.info(JSON.toJSON(statInfo));
	}
	
	@Test
	public void testQueryRecentByPid() {
		List<Query> statInfos= receiveService.getReceivesRecentByApp("1");
		logger.info(JSON.toJSON(statInfos));
	}
}
