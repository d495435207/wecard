package com.dxj.wecard.dao;

import java.util.List;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.model.Verify;
import com.dxj.wecard.model.VerifyKey;

public interface VerifyMapper {

	/**
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(VerifyKey key);

	/**
	 * @mbggenerated
	 */
	int insert(Verify record);

	/**
	 * @mbggenerated
	 */
	int insertSelective(Verify record);

	/**
	 * @mbggenerated
	 */
	Verify selectByPrimaryKey(VerifyKey key);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Verify record);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Verify record);
	
	int getVerifiesNumCnt(Query record);

	List<BizQuery> getVerifiesCnt(Query record);

	int getCardsVerifyNumByApp(Query record);

	List<BizQuery> getCardsVerifyByApp(Query record);
}