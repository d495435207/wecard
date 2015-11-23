package com.dxj.wecard.service;

public interface TopicSendService {

	void send(String queueName, final Object message);

	void send(final Object message);
}