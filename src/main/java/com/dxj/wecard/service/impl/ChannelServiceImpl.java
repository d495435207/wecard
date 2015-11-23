package com.dxj.wecard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxj.wecard.bean.Query;
import com.dxj.wecard.dao.ChannelMapper;
import com.dxj.wecard.model.Channel;
import com.dxj.wecard.service.ChannelService;

@Service("channelService")
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	private ChannelMapper channelMapper;

	@Override
	public int insert(Channel record) {
		return channelMapper.insert(record);
	}

	@Override
	public Channel getByUserCardId(String userId, String cardId) {
		Query record = new Query();
		record.setId(Integer.valueOf(cardId));
		record.setUserId(userId);
		return channelMapper.getByUserCardId(record);
	}
}