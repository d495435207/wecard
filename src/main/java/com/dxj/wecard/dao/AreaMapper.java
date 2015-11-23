package com.dxj.wecard.dao;

import java.util.List;

import com.dxj.wecard.model.Area;
import com.dxj.wecard.model.AreaKey;

public interface AreaMapper {
	/**
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(AreaKey key);

	/**
	 * @mbggenerated
	 */
	int insert(Area record);

	/**
	 * @mbggenerated
	 */
	int insertSelective(Area record);

	/**
	 * @mbggenerated
	 */
	Area selectByPrimaryKey(AreaKey key);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Area record);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Area record);

	List<Area> getAreasByPid(Long pid);
}