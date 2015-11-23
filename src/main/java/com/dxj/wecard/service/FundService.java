package com.dxj.wecard.service;

import java.util.Date;
import java.util.List;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.model.Fund;

public interface FundService {

	Fund getById(Integer id);

	// 统计充值和提现汇总数
	Fund getFundSumByPartner(Integer id);

	int insert(Fund record);

	// 统计某时间之前的充值和提现汇总数
	Fund getFundSumDateByPartner(Integer id, Date startTime);

	// 某时间区间的充值和提现情况
	List<Fund> getFundsDateAreaByPartner(Integer id, Date startTime, Date endTime);

	// 充值次数
	int getFundsPublisherNumByPartner(Query record);

	// 充值分页数据
	List<Query> getFundsPublisherByPartner(Query record);

	int getPublisherLastBalance(Query record);

	int getBalance(Fund fund);

	// 发行商管理，发行商数量
	int getFundsNumByManagerPublisher(BizQuery record);

	// 发行商管理，发行商分页数据
	List<BizQuery> getFundsByManagerPublisher(BizQuery record);

	// 承销商管理，承销商数量
	int getFundsNumByManagerUnderwriter(BizQuery record);

	// 承销商管理，承销商分页数据
	List<BizQuery> getFundsByManagerUnderwriter(BizQuery record);

	// 承销商管理，承销商提现数量
	int getFundsCashNumByManagerUnderwriter(Query record);

	// 承销商管理，承销商提现分页数据
	List<Query> getFundsCashByManagerUnderwriter(Query record);

	// 发行商管理，汇总数
	BizQuery getCountByManagerPublisher();


}