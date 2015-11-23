package com.dxj.wecard.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.Utils;
import com.alibaba.fastjson.JSON;
import com.dxj.wecard.model.Partner;
import com.dxj.wecard.model.User;
import com.dxj.wecard.model.UserPartner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-spring.xml",
		"classpath:applicationContext-mybatis.xml", "classpath:applicationContext-activemq.xml",
		"classpath:applicationContext-redis.xml" })
public class TestUserService {

	static final Logger logger = LogManager.getLogger(TestUserService.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserPartnerService userPartnerService;

	@Autowired
	private PartnerService partnerService;

	@Test
	public void testQueryById() {
		User user = userService.getById("13910253932");
		logger.info(JSON.toJSON(user));
	}

	@Test
	public void testQueryAll() {
		List<User> users = userService.getAll();
		logger.info(JSON.toJSON(users));
	}

	@Test
	public void testInsert() {
		User user = new User();
		user.setId("13910253932");
		user.setIsAdmin(0);
		user.setPassword("654321");
		int result = userService.insert(user);
		System.out.println(result);
	}

	@Test
	public void testlogin() {
		String phone = "13910253932";
		Partner partner = userPartnerService.getPartnerByUser(phone);
		System.out.println(partner.toString());
	}

	@Test
	@Transactional
	public void testRegister2() {
		User user = new User();
		user.setId("13910253932");
		user.setIsAdmin(0);
		user.setPassword("654321");
		int result_user = userService.insert(user);
		Partner partner = new Partner();
		partner.setRole(0);
		int result_partner = partnerService.insert(partner);
		int i = 1 / 0; // 抛出运行时异常 测试事务
		UserPartner userPartner = new UserPartner();
		userPartner.setUserId(user.getId());
		userPartner.setPartnerId(partner.getId());
		int result_userPartner = userPartnerService.insert(userPartner);
		if (result_user == 1 && result_partner == 1 && result_userPartner == 1) {
			logger.info("add user success");
		} else
			logger.info("add user fail");
	}

	@Test
	public void testRegister() {
		User user = new User();
		user.setId("13910253932");
		user.setIsAdmin(0);
		user.setPassword("654321");
		Partner partner = new Partner();
		partner.setRole(0);
		int result = userPartnerService.addPartner(user, partner);
		if (result == 1) {
			logger.info("add user success");
		} else
			logger.info("add user fail");
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setId("13621129267");
		user.setIsAdmin(0);
		user.setPassword(Utils.md5(Utils.md5("123456")));
		Partner partner = new Partner();
		partner.setRole(0);
		int result = userPartnerService.addUserPartner(user, partner);
		if (result == 1) {
			logger.info("add user success");
		} else
			logger.info("add user fail");
	}

	@Test
	public void testRedisPut() {
		User user = userService.getById("13910253931");
		userService.putUserCache(user);
		logger.info(JSON.toJSON(user));
	}

	@Test
	public void testRedisGet() {
		User user = userService.getUserCache("13910253931");
		logger.info(JSON.toJSON(user));
	}
}
