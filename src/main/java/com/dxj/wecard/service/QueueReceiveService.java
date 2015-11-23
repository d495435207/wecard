package com.dxj.wecard.service;

import javax.jms.Message;

public interface QueueReceiveService {

	void onMessage(Message message);

}