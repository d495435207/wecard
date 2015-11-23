package com.dxj.wecard.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.bean.order.DataQueryRsp;
import com.dxj.wecard.card.dto.CardPartnerVo;
import com.dxj.wecard.dao.CardMapper;
import com.dxj.wecard.model.Card;
import com.dxj.wecard.service.CardService;

@Service("cardService")
public class CardServiceImpl implements CardService {

	@Autowired
	private CardMapper cardMapper;

	@Override
	public int getCardCountByApp(String appId) {
		Query record = new Query();
		record.setAppId(appId);
		return cardMapper.getCardCountByApp(record);
	}

	@Override
	public int getCardUpCountByApp(String appId) {
		BizQuery record = new BizQuery();
		record.setAppId(appId);
		record.setStatus("1");
		return cardMapper.getCardStatusCountByApp(record);
	}

	@Override
	public int getCardsNumByApp(BizQuery record) {
		return cardMapper.getCardsNumByApp(record);
	}

	@Override
	public List<BizQuery> getCardsByApp(BizQuery record) {
		return cardMapper.getCardsByApp(record);
	}

	@Override
	public List<DataQueryRsp> getCardsByChannelQuery(){
		return cardMapper.getCardsByChannelQuery();
	}
	
	@Override
	public int delete(Integer id) {
		return cardMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int down(Integer id) {
		Card record = new Card();
		record.setId(id);
		record.setCardStatus(2);
		return cardMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateStock(Integer id, Integer stock) {
		Card record = new Card();
		record.setId(id);
		record.setQuantity(stock);
		return cardMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateCost(Integer id, Double cost) {
		Card record = new Card();
		record.setId(id);
		record.setCost(new BigDecimal(cost * 100).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		return cardMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateCostStatus(Integer id, Double cost,Integer status) {
		Card record = new Card();
		record.setId(id);
		record.setCost(new BigDecimal(cost * 100).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		record.setCardStatus(status);
		return cardMapper.updateByPrimaryKeySelective(record);
	}
    @Override
    public CardPartnerVo getCardPanterVo(String appId, String cardId) {
        
        return null;
    }

}