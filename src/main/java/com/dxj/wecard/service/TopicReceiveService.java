package com.dxj.wecard.service;

import javax.jms.Message;

public interface TopicReceiveService {

	void onMessage(Message message);

}