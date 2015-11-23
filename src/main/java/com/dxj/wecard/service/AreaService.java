package com.dxj.wecard.service;

import java.util.List;

import com.dxj.wecard.model.Area;

public interface AreaService {

	Area getById(Long id,Long pid);
	
	List<Area> getAreasByPid(Long pid);
}