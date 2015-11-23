package com.dxj.wecard.service;

public interface CaptchaService {

	void putCaptchaCache(String phone, String code);

	String getCaptchaCache(String phone);
	
	void putIsSendCache(String phone);

	String getIsSendCache(String phone);

	int sendCaptcha(String content, String phone);

}