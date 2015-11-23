package com.dxj.wecard.service;

import com.dxj.wecard.model.Channel;

public interface ChannelService {

	int insert(Channel record);

	Channel getByUserCardId(String userId, String cardId);
}