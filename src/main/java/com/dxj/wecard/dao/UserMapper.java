package com.dxj.wecard.dao;

import java.util.List;

import com.dxj.wecard.model.User;

public interface UserMapper {
    /**
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * @mbggenerated
	 */
	int insert(User record);

	/**
	 * @mbggenerated
	 */
	int insertSelective(User record);

	/**
	 * @mbggenerated
	 */
	User selectByPrimaryKey(String id);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKey(User record);

	List<User> getAll();

	int delete(User record);
}