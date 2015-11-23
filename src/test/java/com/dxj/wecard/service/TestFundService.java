package com.dxj.wecard.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.model.Fund;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-spring.xml",
		"classpath:applicationContext-mybatis.xml", "classpath:applicationContext-activemq.xml",
		"classpath:applicationContext-redis.xml" })
public class TestFundService {

	static final Logger logger = LogManager.getLogger(TestFundService.class);

	@Autowired
	private FundService fundService;

	@Test
	public void testQueryByPid() {
		Fund fund= fundService.getFundSumByPartner(19);
		logger.info(JSON.toJSON(fund));
	}
}
