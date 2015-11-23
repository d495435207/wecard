package com.dxj.wecard.dao;

import com.dxj.wecard.model.Branch;

public interface BranchMapper {

	/**
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * @mbggenerated
	 */
	int insert(Branch record);

	/**
	 * @mbggenerated
	 */
	int insertSelective(Branch record);

	/**
	 * @mbggenerated
	 */
	Branch selectByPrimaryKey(Integer id);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Branch record);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Branch record);
}