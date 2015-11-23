package com.dxj.wecard.service.impl;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.dxj.wecard.service.CaptchaService;
import com.dxj.wecard.service.SmsService;

@Service("captchaService")
public class CaptchaServiceImpl implements CaptchaService {

	static final Logger logger = LogManager.getLogger(CaptchaServiceImpl.class);

	@Autowired
	private RedisTemplate<String, Serializable> redisTemplate;

	@Autowired
	private SmsService smsService;

	@Override
	public void putCaptchaCache(String phone, String value) {
		String cacheType = "Captcha";
		String key = this.getClass().getSimpleName() + "." + cacheType + "." + phone;
		redisTemplate.opsForValue().set(key, value, 30*60, TimeUnit.SECONDS);
	}

	@Override
	public String getCaptchaCache(String phone) {
		String cacheType = "Captcha";
		String key = this.getClass().getSimpleName() + "." + cacheType + "." + phone;
		return (String) redisTemplate.opsForValue().get(key);
	}

	@Override
	public void putIsSendCache(String phone) {
		String cacheType = "IsSend";
		String value=""+System.currentTimeMillis();
		String key = this.getClass().getSimpleName() + "." + cacheType + "." + phone;
		redisTemplate.opsForValue().set(key, value, 60, TimeUnit.SECONDS);
	}

	@Override
	public String getIsSendCache(String phone) {
		String cacheType = "IsSend";
		String key = this.getClass().getSimpleName() + "." + cacheType + "." + phone;
		return (String) redisTemplate.opsForValue().get(key);
	}

	@Override
	public int sendCaptcha(String content, String phone) {
		return smsService.send(content, phone);
	}
}