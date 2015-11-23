package com.dxj.wecard.dao;

import com.dxj.wecard.model.WeixinUser;
import com.dxj.wecard.model.WeixinUserKey;

public interface WeixinUserMapper {

	/**
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(WeixinUserKey key);

	/**
	 * @mbggenerated
	 */
	int insert(WeixinUser record);

	/**
	 * @mbggenerated
	 */
	int insertSelective(WeixinUser record);

	/**
	 * @mbggenerated
	 */
	WeixinUser selectByPrimaryKey(WeixinUserKey key);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(WeixinUser record);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKey(WeixinUser record);
}