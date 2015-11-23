package com.dxj.wecard.dao;

import com.dxj.wecard.model.CardMore;

public interface CardMoreMapper {

	/**
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * @mbggenerated
	 */
	int insert(CardMore record);

	/**
	 * @mbggenerated
	 */
	int insertSelective(CardMore record);

	/**
	 * @mbggenerated
	 */
	CardMore selectByPrimaryKey(Integer id);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(CardMore record);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKey(CardMore record);
	
	void deleteByIds(String[] ids);
}