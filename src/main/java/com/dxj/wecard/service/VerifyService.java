package com.dxj.wecard.service;

import java.util.List;
import java.util.Map;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;

public interface VerifyService {
	// 核销次数，top 6
	List<BizQuery> getVerifiesTopCnt();

	// 某卡核销数
	int getCardsVerifyNumByApp(Query record);

	// 某卡核销分页数据
	List<BizQuery> getCardsVerifyByApp(Query record);

	// 核销次数，分页
	int getVerifiesNumCnt(Query record);

	List<BizQuery> getVerifiesCnt(Query record);
	
	int userConsumeCard(Map<String, String> requestMap);
}