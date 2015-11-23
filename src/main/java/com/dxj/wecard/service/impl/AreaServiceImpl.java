package com.dxj.wecard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxj.wecard.dao.AreaMapper;
import com.dxj.wecard.model.Area;
import com.dxj.wecard.model.AreaKey;
import com.dxj.wecard.service.AreaService;

@Service("areaService")
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaMapper areaMapper;
	
	@Override
	public Area getById(Long id,Long pid){
		AreaKey key=new AreaKey();
		key.setId(id);
		key.setPid(pid);
		return areaMapper.selectByPrimaryKey(key);
	}
	
	@Override
	public List<Area> getAreasByPid(Long pid) {
		return areaMapper.getAreasByPid(pid);
	}
}