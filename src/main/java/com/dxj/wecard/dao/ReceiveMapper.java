package com.dxj.wecard.dao;

import java.util.List;

import com.dxj.wecard.bean.Query;
import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.model.Receive;
import com.dxj.wecard.model.ReceiveKey;

public interface ReceiveMapper {

	/**
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(ReceiveKey key);

	/**
	 * @mbggenerated
	 */
	int insert(Receive record);

	/**
	 * @mbggenerated
	 */
	int insertSelective(Receive record);

	/**
	 * @mbggenerated
	 */
	Receive selectByPrimaryKey(ReceiveKey key);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Receive record);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Receive record);

	Query getReceiveCountByApp(Query record);

	Query getReceiveCountByUnderwriter(Query record);

	List<Query> getReceivesRecentByApp(Query record);

	int getReceivesNumCnt(Query record);

	List<BizQuery> getReceivesCnt(Query record);

	int getReceivesNumUser(Query record);

	List<BizQuery> getReceivesUser(Query record);

	Query getReceiveCountDateByApp(Query record);

	List<Receive> getReceiveDateAreaByApp(Query record);

	int getReceivesCashNumByApp(Query record);

	List<Query> getReceivesCashByApp(Query record);

	int getReceivesCashNumByUnderwriter(Query record);

	List<Query> getReceivesCashByUnderwriter(Query record);
	
	List<Query> getReceivesCashByUnderwriterAll(Query record);
	
	int getReceivesCashDetailNumByUnderwriter(Query record);

	List<BizQuery> getReceivesCashDetailByUnderwriter(Query record);
	
	List<BizQuery> getReceivesCashDetailByUnderwriterAll(Query record);

	int getCardsReceiveNumByApp(Query record);

	List<BizQuery> getCardsReceiveByApp(Query record);

	int getReceivesNumByPublisherSpendDetail(Query record);

	List<BizQuery> getReceivesByPublisherSpendDetail(Query record);

	List<Query> getReceivesCashByAppAll(Query record);

	List<BizQuery> getReceivesByPublisherSpendDetailAll(Query record);
}