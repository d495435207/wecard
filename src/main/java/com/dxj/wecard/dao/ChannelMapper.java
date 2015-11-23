package com.dxj.wecard.dao;

import com.dxj.wecard.bean.Query;
import com.dxj.wecard.model.Channel;

public interface ChannelMapper {

	/**
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * @mbggenerated
	 */
	int insert(Channel record);

	/**
	 * @mbggenerated
	 */
	int insertSelective(Channel record);

	/**
	 * @mbggenerated
	 */
	Channel selectByPrimaryKey(Integer id);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Channel record);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Channel record);
	
	Channel getByUserCardId(Query record);
}