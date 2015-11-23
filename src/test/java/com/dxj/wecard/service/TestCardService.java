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
import com.dxj.wecard.bean.order.DataQueryRsp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-spring.xml",
		"classpath:applicationContext-mybatis.xml", "classpath:applicationContext-activemq.xml",
		"classpath:applicationContext-redis.xml" })
public class TestCardService {

	static final Logger logger = LogManager.getLogger(TestCardService.class);

	@Autowired
	private CardService cardService;

	@Test
	public void testQueryByPid() {
		Integer count = cardService.getCardCountByApp(null);
		logger.info(JSON.toJSON(count));
	}

	@Test
	public void testQueryStatusByPid() {
		Integer count = cardService.getCardUpCountByApp("1");
		logger.info(JSON.toJSON(count));
	}

	@Test
	public void testQueryChannel() {
		List<DataQueryRsp> data = cardService.getCardsByChannelQuery();
		logger.info(JSON.toJSONString(data));
	}
}
