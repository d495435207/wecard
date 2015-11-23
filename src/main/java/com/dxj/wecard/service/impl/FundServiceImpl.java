package com.dxj.wecard.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.dao.FundMapper;
import com.dxj.wecard.dao.ReceiveMapper;
import com.dxj.wecard.model.Fund;
import com.dxj.wecard.model.Receive;
import com.dxj.wecard.service.FundService;

@Service("fundService")
public class FundServiceImpl implements FundService {

	@Autowired
	private FundMapper fundMapper;

	@Autowired
	private ReceiveMapper receiveMapper;

	@Override
	public Fund getById(Integer id) {
		return fundMapper.selectByPrimaryKey(id);
	}

	@Override
	public Fund getFundSumByPartner(Integer id) {
		Query record = new Query();
		record.setId(id);
		return fundMapper.getFundSumByPartner(record);
	}

	@Override
	public int insert(Fund record) {
		record.setAtTime(Calendar.getInstance().getTime());
		return fundMapper.insert(record);
	}

	@Override
	public Fund getFundSumDateByPartner(Integer id, Date startTime) {
		Query record = new Query();
		record.setId(id);
		record.setStartTime(startTime);
		return fundMapper.getFundSumDateByPartner(record);
	}

	@Override
	public List<Fund> getFundsDateAreaByPartner(Integer id, Date startTime, Date endTime) {
		Query record = new Query();
		record.setId(id);
		record.setStartTime(startTime);
		record.setEndTime(endTime);
		return fundMapper.getFundsDateAreaByPartner(record);
	}

	@Override
	public int getFundsNumByManagerPublisher(BizQuery record) {
		return fundMapper.getFundsNumByManagerPublisher(record);
	}

	@Override
	public List<BizQuery> getFundsByManagerPublisher(BizQuery record) {
		return fundMapper.getFundsByManagerPublisher(record);
	}

	@Override
	public int getFundsNumByManagerUnderwriter(BizQuery record) {
		return fundMapper.getFundsNumByManagerUnderwriter(record);
	}

	@Override
	public List<BizQuery> getFundsByManagerUnderwriter(BizQuery record) {
		return fundMapper.getFundsByManagerUnderwriter(record);
	}

	@Override
	public int getFundsCashNumByManagerUnderwriter(Query record) {
		return fundMapper.getFundsNumByPartner(record);
	}

	@Override
	public List<Query> getFundsCashByManagerUnderwriter(Query record) {
		List<Query> result = new ArrayList<Query>();
		List<Query> fundInfos = fundMapper.getFundsByPartner(record);
		if (fundInfos != null && fundInfos.size() > 0) {
			int j = fundInfos.size() - 1;
			Query startFund = fundInfos.get(j);
			Query stat = new Query();
			stat.setStartTime(startFund.getAtTime());
			stat.setId(record.getId());
			Fund fundSum = fundMapper.getFundSumDateByPartner(stat);
			int charge = getBalance(fundSum);
			for (int i = j; i >= 0; i--) {
				Query q = fundInfos.get(i);
				charge += q.getSum();
				q.setCharge(charge);
				result.add(0, q);
			}
		}
		return result;
	}

	@Override
	public BizQuery getCountByManagerPublisher() {
		return fundMapper.getCountByManagerPublisher();
	}

	@Override
	public int getFundsPublisherNumByPartner(Query record) {
		return fundMapper.getFundsNumByPartner(record);
	}

	@Override
	public List<Query> getFundsPublisherByPartner(Query record) {
		List<Query> result = new ArrayList<Query>();
		List<Query> fundInfos = fundMapper.getFundsByPartner(record);
		if (fundInfos != null && fundInfos.size() > 0) {
			Query startFund = fundInfos.get(fundInfos.size() - 1);
			Query endFund = fundInfos.get(0);
			Query stat = new Query();
			stat.setStartTime(startFund.getAtTime());
			stat.setEndTime(endFund.getAtTime());
			stat.setAppId(record.getAppId());
			stat.setId(record.getId());
			// 充值期间的消费情况
			List<Receive> receiveInfos = null;
			if (!StringUtils.isBlank(record.getAppId()))
				receiveInfos = receiveMapper.getReceiveDateAreaByApp(stat);
			if (receiveInfos == null)
				receiveInfos = new ArrayList<Receive>();
			// 计算余额~~
			// 最后一条记录之前的余额
			int balance = getPublisherLastBalance(stat);

			int i = fundInfos.size() - 1;
			int j = receiveInfos.size() - 1;
			// 处理记录的余额
			if (i > 0) {
				for (; i >= 0; i--) {
					Query fund = fundInfos.get(i);
					int cost = 0;
					for (; j >= 0; j--) {
						Receive receive = receiveInfos.get(j);
						if (receive.getAtTime().compareTo(fund.getAtTime()) > 0) {
							balance -= cost;
							break;
						} else if (j == 0) {
							cost += receive.getCost();
							balance -= cost;
						} else
							cost += receive.getCost();
					}
					balance += fund.getSum();
					fund.setBalance(balance);
					result.add(0, fund);
				}
			}
		}
		return result;
	}

	@Override
	public int getPublisherLastBalance(Query record) {
		// 最后一条充值记录之前的汇总数
		Fund fundSum = fundMapper.getFundSumDateByPartner(record);
		// 最后一条充值记录之前的消费汇总数
		Query statInfo = null;
		if (!StringUtils.isBlank(record.getAppId()))
			statInfo = receiveMapper.getReceiveCountDateByApp(record);

		int balance = 0;
		int charge = getBalance(fundSum);
		balance += charge;
		if (statInfo != null)
			balance -= statInfo.getSum();
		return balance;
	}

	@Override
	public int getBalance(Fund fund) {
		int charge = 0;
		if (fund != null) {
			if (fund.getDebitAmount() != null)
				charge += fund.getDebitAmount();
			if (fund.getCreditAmount() != null)
				charge -= fund.getCreditAmount();
		}
		return charge;
	}
}