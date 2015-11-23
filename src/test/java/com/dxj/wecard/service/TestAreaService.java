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
import com.dxj.wecard.model.Area;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-spring.xml",
		"classpath:applicationContext-mybatis.xml", "classpath:applicationContext-activemq.xml",
		"classpath:applicationContext-redis.xml" })
public class TestAreaService {

	static final Logger logger = LogManager.getLogger(TestAreaService.class);

	@Autowired
	private AreaService areaService;

	@Test
	public void testQueryByPid() {
		List<Area> areas= areaService.getAreasByPid(4L);
		logger.info(JSON.toJSON(areas));
	}
}
