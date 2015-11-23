package com.dxj.wecard.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.card.dto.CardPartnerVo;
import com.dxj.wecard.dao.CardMapper;
import com.dxj.wecard.dao.FundMapper;
import com.dxj.wecard.dao.ReceiveMapper;
import com.dxj.wecard.model.Fund;
import com.dxj.wecard.model.Receive;
import com.dxj.wecard.service.FundService;
import com.dxj.wecard.service.ReceiveService;
import com.dxj.wecard.util.Utils;

@Service("receiveService")
public class ReceiveServiceImpl implements ReceiveService {

	@Autowired
	private RedisTemplate<String, Serializable> redisTemplate;

	@Autowired
	private CardMapper cardMapper;

	@Autowired
	private ReceiveMapper receiveMapper;

	@Autowired
	private FundMapper fundMapper;

	@Autowired
	private FundService fundService;

	@Override
	public Query getReceiveCountByApp(String appId) {
		Query record = new Query();
		record.setAppId(appId);
		return receiveMapper.getReceiveCountByApp(record);
	}

	@Override
	public Query getReceiveCountByUnderwriter(Integer id) {
		Query record = new Query();
		record.setId(id);
		return receiveMapper.getReceiveCountByUnderwriter(record);
	}

	@Override
	public List<Query> getReceivesRecentByApp(String appId) {
		Query stat = new Query();
		stat.setStartTime(Utils.getAddDate(-7));
		stat.setEndTime(Utils.getAddDate(0));
		stat.setAppId(appId);
		List<Query> statInfos = receiveMapper.getReceivesRecentByApp(stat);
		List<Query> result = new ArrayList<Query>();
		for (int i = 1; i < 8; i++) {
			Query e = new Query();
			e.setCount(0);
			e.setSum(0);
			e.setAtTime(Utils.getAddDate(-i));
			for (Query s : statInfos) {
				if (s.getAtTime().compareTo(e.getAtTime()) == 0) {
					e.setCount(s.getCount());
					e.setSum(s.getSum());
					statInfos.remove(s);
					break;
				}
			}

			result.add(e);
		}
		return result;
	}

	@Override
	public List<Query> getReceivesRecentByUnderwriter(Integer id) {
		Query stat = new Query();
		stat.setStartTime(Utils.getAddDate(-7));
		stat.setEndTime(Utils.getAddDate(0));
		stat.setId(id);
		List<Query> statInfos = receiveMapper.getReceivesCashByUnderwriter(stat);
		List<Query> result = new ArrayList<Query>();
		for (int i = 1; i < 8; i++) {
			Query e = new Query();
			e.setCount(0);
			e.setSum(0);
			e.setAtTime(Utils.getAddDate(-i));
			for (Query s : statInfos) {
				if (s.getAtTime().compareTo(e.getAtTime()) == 0) {
					e.setCount(s.getCount());
					e.setSum(s.getSum());
					statInfos.remove(s);
					break;
				}
			}

			result.add(e);
		}
		return result;
	}

	@Override
	public int getReceivesCashNumByUnderwriter(Query record) {
		return receiveMapper.getReceivesCashNumByUnderwriter(record);
	}

	@Override
	public List<Query> getReceivesCashByUnderwriter(Query record) {
		return receiveMapper.getReceivesCashByUnderwriter(record);
	}

	@Override
	public int getReceivesCashDetailNumByUnderwriter(Query record) {
		return receiveMapper.getReceivesCashDetailNumByUnderwriter(record);
	}

	@Override
	public List<BizQuery> getReceivesCashDetailByUnderwriter(Query record) {
		return receiveMapper.getReceivesCashDetailByUnderwriter(record);
	}

	@Override
	public List<Query> getReceivesCashByUnderwriterAll(Query record) {
		return receiveMapper.getReceivesCashByUnderwriterAll(record);
	}

	@Override
	public List<BizQuery> getReceivesCashDetailByUnderwriterAll(Query record) {
		return receiveMapper.getReceivesCashDetailByUnderwriterAll(record);
	}

	@Override
	public List<BizQuery> getReceivesTopCnt() {
		Query top = new BizQuery();
		top.setStart(0);
		top.setSize(6);
		return receiveMapper.getReceivesCnt(top);
	}

	@Override
	public List<BizQuery> getReceivesTopUser() {
		Query top = new BizQuery();
		top.setStart(0);
		top.setSize(6);
		return receiveMapper.getReceivesUser(top);
	}

	@Override
	public int getReceivesNumCnt(Query record) {
		return receiveMapper.getReceivesNumCnt(record);
	}

	@Override
	public List<BizQuery> getReceivesCnt(Query record) {
		return receiveMapper.getReceivesCnt(record);
	}

	@Override
	public int getReceivesNumUser(Query record) {
		return receiveMapper.getReceivesNumUser(record);
	}

	@Override
	public List<BizQuery> getReceivesUser(Query record) {
		return receiveMapper.getReceivesUser(record);
	}

	@Override
	public Query getReceiveCountDateByApp(String id, Date startTime) {
		Query stat = new Query();
		stat.setStartTime(startTime);
		stat.setAppId(id);
		return receiveMapper.getReceiveCountDateByApp(stat);
	}

	@Override
	public List<Receive> getReceiveDateAreaByApp(String id, Date startTime, Date endTime) {
		Query stat = new Query();
		stat.setStartTime(startTime);
		stat.setEndTime(endTime);
		stat.setAppId(id);
		return receiveMapper.getReceiveDateAreaByApp(stat);
	}

	@Override
	public int getReceivesPublisherCashNumByApp(Query record) {
		return receiveMapper.getReceivesCashNumByApp(record);
	}

	private List<Query> getResultAdjustSpend(List<Query> queryInfos, Query record) {
		List<Query> result = new ArrayList<Query>();
		if (queryInfos != null && queryInfos.size() > 0) {
			Query startQuery = queryInfos.get(queryInfos.size() - 1);
			Query endQuery = queryInfos.get(0);
			Query stat = new Query();
			stat.setStartTime(startQuery.getAtTime());
			stat.setEndTime(Utils.getAddDate(endQuery.getAtTime(), 1));
			stat.setAppId(record.getAppId());
			stat.setId(record.getId());
			// 消费期间的充值提现情况
			List<Fund> fundInfos = null;
			if (record.getId() != null)
				fundInfos = fundMapper.getFundsDateAreaByPartner(stat);
			if (fundInfos == null)
				fundInfos = new ArrayList<Fund>();
			// 计算余额~~
			// 最后一条记录之前的余额
			int balance = fundService.getPublisherLastBalance(stat);

			int i = queryInfos.size() - 1;
			int j = fundInfos.size() - 1;
			// 处理记录的余额
			if (i > 0) {
				for (; i >= 0; i--) {
					Query query = queryInfos.get(i);
					Date time = Utils.getAddDate(query.getAtTime(), 1);
					int cost = 0;
					for (; j >= 0; j--) {
						Fund fund = fundInfos.get(j);
						if (fund.getAtTime().compareTo(time) >= 0) {
							balance += cost;
							break;
						} else if (j == 0) {
							cost += fundService.getBalance(fund);
							balance += cost;
						} else
							cost += fundService.getBalance(fund);
					}
					balance -= query.getSum();
					query.setBalance(balance);
					result.add(0, query);
				}
			}
		}
		return result;
	}

	@Override
	public List<Query> getReceivesPublisherCashByAppAll(Query record) {
		List<Query> queryInfos = receiveMapper.getReceivesCashByAppAll(record);
		return getResultAdjustSpend(queryInfos, record);
	}

	@Override
	public List<Query> getReceivesPublisherCashByApp(Query record) {
		List<Query> queryInfos = receiveMapper.getReceivesCashByApp(record);
		return getResultAdjustSpend(queryInfos, record);
	}

	@Override
	public int getCardsReceiveNumByApp(Query record) {
		return receiveMapper.getCardsReceiveNumByApp(record);
	}

	@Override
	public List<BizQuery> getCardsReceiveByApp(Query record) {
		return receiveMapper.getCardsReceiveByApp(record);
	}

	@Override
	public int getReceivesNumByPublisherSpendDetail(Query record) {
		return receiveMapper.getReceivesNumByPublisherSpendDetail(record);
	}

	private List<BizQuery> getResultAdjustSpendDetail(List<BizQuery> receiveInfos, Query record, Integer last) {
		List<BizQuery> result = new ArrayList<BizQuery>();
		if (receiveInfos != null && receiveInfos.size() > 0) {
			int j = receiveInfos.size() - 1;
			BizQuery startReceive = receiveInfos.get(j);
			Query stat = new Query();
			stat.setStartTime(startReceive.getAtTime());
			stat.setAppId(record.getAppId());
			stat.setId(record.getId());
			int balance = fundService.getPublisherLastBalance(stat);
			for (int i = j; i >= 0; i--) {
				BizQuery q = receiveInfos.get(i);
				balance -= q.getCost();
				q.setBalance(balance);
				result.add(0, q);
			}
			if (last != null) {
				BizQuery q = receiveInfos.get(0);
				q.setBalance(last);
				result.remove(0);
				result.add(0, q);
			}
		}
		return result;
	}

	@Override
	public List<BizQuery> getReceivesByPublisherSpendDetailAll(Query record, Integer last) {
		List<BizQuery> receiveInfos = receiveMapper.getReceivesByPublisherSpendDetailAll(record);
		return getResultAdjustSpendDetail(receiveInfos, record, last);
	}

	@Override
	public List<BizQuery> getReceivesByPublisherSpendDetail(Query record) {
		List<BizQuery> receiveInfos = receiveMapper.getReceivesByPublisherSpendDetail(record);
		return getResultAdjustSpendDetail(receiveInfos, record, null);
	}

	@Override
	public int userGetCardSave(Map<String, String> requestMap) {
		String appid = requestMap.get("appid");
		// 领取用户openId
		String userOpenId = requestMap.get("FromUserName");
		// 转赠前的用户openId
		String friendUserName = requestMap.get("FriendUserName");
		// 领取时间
		String createTime = requestMap.get("CreateTime");
		// 卡券ID
		String cardId = requestMap.get("CardId");
		// 0为否 1为是
		String isGiveByFriend = requestMap.get("IsGiveByFriend");
		// 代理商Id
		String outerId = requestMap.get("OuterId");
		// 卡券code
		String userCardCode = requestMap.get("UserCardCode");
		//
		String oldUserCardCode = requestMap.get("OldUserCardCode");
		CardPartnerVo vo = getCardPartnerVo(appid, cardId, outerId);
		Receive rc = new Receive();
		// 微信对时间戳除了1000
		rc.setAtTime(new Timestamp(Long.parseLong(createTime) * 1000));
		rc.setCode(userCardCode);
		rc.setCardId(vo.getId());
		rc.setCost(vo.getCost());
		rc.setCostProfit(vo.getShareRate() == null ? null : vo.getShareRate());
		rc.setFriendOpenId(friendUserName);
		rc.setOpenId(userOpenId);
		rc.setIsGiveFriend(Integer.parseInt(isGiveByFriend));
		rc.setOldCode(oldUserCardCode);
		rc.setOuterId(outerId);
		int number = receiveMapper.insert(rc);
		return number;
	}

	/**
	 * @param appid
	 * @param cardId
	 * @param outerId
	 * @return
	 * @author liulihai 2015年10月14日 下午3:04:50
	 */
	private CardPartnerVo getCardPartnerVo(String appid, String cardId, String outerId) {
		String key = this.getClass().getSimpleName() + "." + appid + "." + cardId;
		String value = (String) redisTemplate.opsForValue().get(key);
		CardPartnerVo vo = null;
		if (StringUtils.isNotBlank(value)) {
			vo = JSON.parseObject(value, CardPartnerVo.class);
			return vo;
		} else {
			Map<String, Object> parames = new HashMap<String, Object>();
			parames.put("appId", appid);
			parames.put("cardId", cardId);
			// 微信默认返回0，所以这边过滤掉
			if (StringUtils.isNotBlank(outerId) && !outerId.equals("0")) {
				parames.put("partnerId", outerId);
			}
			vo = cardMapper.getCardPanterVo(parames);
			redisTemplate.opsForValue().set(key, JSON.toJSONString(vo), 60 * 2, TimeUnit.SECONDS);
		}
		return vo;
	}
}