package com.dxj.wecard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxj.wecard.dao.PartnerMapper;
import com.dxj.wecard.model.Partner;
import com.dxj.wecard.service.PartnerService;

@Service("partnerService")
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerMapper partnerMapper;

	@Override
	public int delete(int id) {
		return partnerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Partner record) {
		return partnerMapper.insert(record);
	}

	@Override
	public Partner getById(Integer id) {
		return partnerMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Partner record) {
		return partnerMapper.updateByPrimaryKeySelective(record);
	}

}