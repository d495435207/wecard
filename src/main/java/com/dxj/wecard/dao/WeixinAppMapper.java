package com.dxj.wecard.dao;

import com.dxj.wecard.model.WeixinApp;

public interface WeixinAppMapper {

	/**
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * @mbggenerated
	 */
	int insert(WeixinApp record);

	/**
	 * @mbggenerated
	 */
	int insertSelective(WeixinApp record);

	/**
	 * @mbggenerated
	 */
	WeixinApp selectByPrimaryKey(String id);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(WeixinApp record);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKey(WeixinApp record);
	
	WeixinApp getWeixinByPartner(Integer id);
	
	int unAuthorizerUpdate(String appId);
	
}