package com.dxj.wecard.dao;

import java.util.List;
import java.util.Map;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.bean.order.DataQueryRsp;
import com.dxj.wecard.card.dto.CardPartnerVo;
import com.dxj.wecard.model.Card;

public interface CardMapper {

	/**
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * @mbggenerated
	 */
	int insert(Card record);

	/**
	 * @mbggenerated
	 */
	int insertSelective(Card record);

	/**
	 * @mbggenerated
	 */
	Card selectByPrimaryKey(Integer id);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Card record);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Card record);

	int getCardCountByApp(Query record);

	int getCardStatusCountByApp(BizQuery record);

	int getCardsNumByApp(BizQuery record);

	List<BizQuery> getCardsByApp(BizQuery record);

	/**
	 * 拉取appid本地卡券
	 * 
	 * @param appid
	 * @return
	 * @author liulihai 2015年10月12日 上午11:03:39
	 */
	List<Card> getWecardCardsByAppid(String appid);

	void deleteByAppid(String appId);

	List<DataQueryRsp> getCardsByChannelQuery();
	
	CardPartnerVo getCardPanterVo(Map<String,Object> map);
}