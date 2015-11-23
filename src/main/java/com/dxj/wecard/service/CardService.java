package com.dxj.wecard.service;

import java.util.List;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.order.DataQueryRsp;
import com.dxj.wecard.card.dto.CardPartnerVo;

public interface CardService {

	int getCardCountByApp(String appId);

	int getCardUpCountByApp(String appId);

	int getCardsNumByApp(BizQuery record);

	List<BizQuery> getCardsByApp(BizQuery record);

	int delete(Integer id);

	int down(Integer id);

	int updateStock(Integer id, Integer stock);

	int updateCost(Integer id, Double cost);

	int updateCostStatus(Integer id, Double cost, Integer status);
	
	List<DataQueryRsp> getCardsByChannelQuery();
	/**
	 * 用户领取卡券，查询card表和panter表的分成比例
	 * @param appId
	 * @param cardId
	 * @return
	 * @author liulihai 2015年10月14日 下午1:53:25
	 */
	CardPartnerVo getCardPanterVo(String appId,String cardId);
}