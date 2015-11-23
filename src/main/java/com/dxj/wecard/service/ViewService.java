package com.dxj.wecard.service;

import java.util.List;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;

public interface ViewService {
	// 浏览次数,top 6
	List<BizQuery> getViewsTopCnt();

	// 浏览次数，分页
	int getViewsNumCnt(Query record);

	List<BizQuery> getViewsCnt(Query record);
}