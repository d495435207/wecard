package com.dxj.wecard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.dao.ViewMapper;
import com.dxj.wecard.service.ViewService;

@Service("viewService")
public class ViewServiceImpl implements ViewService {

	@Autowired
	private ViewMapper viewMapper;

	@Override
	public List<BizQuery> getViewsTopCnt() {
		Query top = new BizQuery();
		top.setStart(0);
		top.setSize(6);
		return viewMapper.getViewsCnt(top);
	}

	@Override
	public int getViewsNumCnt(Query record) {
		return viewMapper.getViewsNumCnt(record);
	}

	@Override
	public List<BizQuery> getViewsCnt(Query record) {
		return viewMapper.getViewsCnt(record);
	}
}