package com.dxj.wecard.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.model.Receive;

public interface ReceiveService {

	// 统计消费汇总数
	Query getReceiveCountByApp(String appId);

	// 统计分成汇总数
	Query getReceiveCountByUnderwriter(Integer id);

	// 按天分组，最近7天消费情况
	List<Query> getReceivesRecentByApp(String appId);

	// 消费次数，top 6
	List<BizQuery> getReceivesTopCnt();

	// 消费人数, top 6
	List<BizQuery> getReceivesTopUser();

	// 消费次数，分页
	int getReceivesNumCnt(Query record);

	List<BizQuery> getReceivesCnt(Query record);

	// 消费人数，分页
	int getReceivesNumUser(Query record);

	List<BizQuery> getReceivesUser(Query record);

	// 统计某时间之前的消费汇总数
	Query getReceiveCountDateByApp(String id, Date startTime);

	// 查询某时间段消费情况
	List<Receive> getReceiveDateAreaByApp(String id, Date startTime, Date endTime);

	// 按天分组，某时间段消费数
	int getReceivesPublisherCashNumByApp(Query record);

	// 按天分组，某时间段消费分页数据
	List<Query> getReceivesPublisherCashByApp(Query record);

	// 某卡领用数
	int getCardsReceiveNumByApp(Query record);

	// 某卡领用分页数据
	List<BizQuery> getCardsReceiveByApp(Query record);

	// 按天分组，最近7天分成情况
	List<Query> getReceivesRecentByUnderwriter(Integer id);

	// 按天分组，某承销商分成汇总数量
	int getReceivesCashNumByUnderwriter(Query record);

	// 按天分组，某承销商分成汇总分页数据
	List<Query> getReceivesCashByUnderwriter(Query record);

	// 下载全部按天分组，某承销商分成汇总数据
	List<Query> getReceivesCashByUnderwriterAll(Query record);

	// 按天分组，某承销商分成汇总-详细数量
	int getReceivesCashDetailNumByUnderwriter(Query record);

	// 按天分组，某承销商分成汇总-详细分页数据
	List<BizQuery> getReceivesCashDetailByUnderwriter(Query record);

	// 下载全部按天分组，某承销商分成汇总-详细分数据
	List<BizQuery> getReceivesCashDetailByUnderwriterAll(Query record);

	// 发行商管理，消费明细数量
	int getReceivesNumByPublisherSpendDetail(Query record);

	// 发行商管理，消费明细分页数据
	List<BizQuery> getReceivesByPublisherSpendDetail(Query record);

	// 下载全部按天分组的消费数据
	List<Query> getReceivesPublisherCashByAppAll(Query record);

	// 下载全部按天分组后消费明细数据
	List<BizQuery> getReceivesByPublisherSpendDetailAll(Query record, Integer last);

	// 用户领取卡券入库
	int userGetCardSave(Map<String, String> requestMap);

}