package com.dxj.wecard.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxj.wecard.model.Area;
import com.dxj.wecard.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController extends BaseController{

	static final Logger logger = LogManager.getLogger(AreaController.class);

	@Autowired
	private AreaService areaService;
	
	@RequestMapping("/{pid}")
	@ResponseBody
	public Object getAreas(@PathVariable Long pid) {
		List<Area> areas = areaService.getAreasByPid(pid);
		return areas;
	}
}