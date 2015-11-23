package com.dxj.wecard.dao;

import java.util.List;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.model.View;
import com.dxj.wecard.model.ViewKey;

public interface ViewMapper {

	/**
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(ViewKey key);

	/**
	 * @mbggenerated
	 */
	int insert(View record);

	/**
	 * @mbggenerated
	 */
	int insertSelective(View record);

	/**
	 * @mbggenerated
	 */
	View selectByPrimaryKey(ViewKey key);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(View record);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKey(View record);
	
	int getViewsNumCnt(Query record);

	List<BizQuery> getViewsCnt(Query record);
}