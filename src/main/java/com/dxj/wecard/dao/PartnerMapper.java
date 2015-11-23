package com.dxj.wecard.dao;

import com.dxj.wecard.model.Partner;

public interface PartnerMapper {

	/**
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * @mbggenerated
	 */
	int insert(Partner record);

	/**
	 * @mbggenerated
	 */
	int insertSelective(Partner record);

	/**
	 * @mbggenerated
	 */
	Partner selectByPrimaryKey(Integer id);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Partner record);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Partner record);

	Partner getPartnerByUser(String id);

	int delete(Partner record);
}