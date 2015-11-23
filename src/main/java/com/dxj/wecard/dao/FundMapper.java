package com.dxj.wecard.dao;

import java.util.List;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.model.Fund;

public interface FundMapper {

	/**
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * @mbggenerated
	 */
	int insert(Fund record);

	/**
	 * @mbggenerated
	 */
	int insertSelective(Fund record);

	/**
	 * @mbggenerated
	 */
	Fund selectByPrimaryKey(Integer id);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Fund record);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Fund record);

	Fund getFundSumByPartner(Query record);

	Fund getFundSumDateByPartner(Query record);

	List<Fund> getFundsDateAreaByPartner(Query record);

	int getFundsNumByPartner(Query record);

	List<Query> getFundsByPartner(Query record);

	int getFundsNumByManagerPublisher(BizQuery record);

	List<BizQuery> getFundsByManagerPublisher(BizQuery record);

	int getFundsNumByManagerUnderwriter(BizQuery record);

	List<BizQuery> getFundsByManagerUnderwriter(BizQuery record);

	BizQuery getCountByManagerPublisher();

	int delete(Fund record);
}