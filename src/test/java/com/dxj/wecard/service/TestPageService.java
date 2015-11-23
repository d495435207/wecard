package com.dxj.wecard.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.bean.order.BodyReq;
import com.dxj.wecard.bean.order.DataOrderRsp;
import com.dxj.wecard.bean.order.DataQueryRsp;
import com.dxj.wecard.bean.order.HeadReq;
import com.dxj.wecard.bean.order.OrderReq;
import com.dxj.wecard.bean.order.OrderRsp;
import com.dxj.wecard.bean.order.QueryReq;
import com.dxj.wecard.bean.order.QueryRsp;

public class TestPageService {

	static final Logger logger = LogManager.getLogger(TestPageService.class);

	@Test
	public void testPage() {
		Query page = new Query();
		page.setSize(20);
		logger.info(JSON.toJSON(page));
		page.setCount(18);
		logger.info(JSON.toJSON(page));
		page.setPage(0);
		logger.info(JSON.toJSON(page));
		page.setPage(1);
		logger.info(JSON.toJSON(page));
		page.setPage(5);
		logger.info(JSON.toJSON(page));
		page.setPage(6);
		logger.info(JSON.toJSON(page));
	}

	@Test
	public void testJSON() {
		OrderReq req = new OrderReq();
		HeadReq head = new HeadReq();
		BodyReq body = new BodyReq();
		head.setEcid("123");
		head.setPw("abc");
		body.setCardid("opq");
		req.setBody(body);
		req.setHead(head);
		logger.info("order req--" + JSON.toJSONString(req));

		QueryReq queryReq = new QueryReq();
		HeadReq queryHead = new HeadReq();
		queryHead.setEcid("123");
		queryHead.setPw("abc");
		queryReq.setHead(queryHead);
		logger.info("query req--" + JSON.toJSONString(queryReq));

		OrderRsp rsp = new OrderRsp();
		DataOrderRsp dor = new DataOrderRsp();
		rsp.setCode("0000");
		dor.setCardid("opq");
		dor.setOuterid("456");
		rsp.setData(dor);
		logger.info("order rsp--" + JSON.toJSONString(rsp));

		QueryRsp queryRsp = new QueryRsp();
		DataQueryRsp dqr = new DataQueryRsp();
		queryRsp.setCode("0000");
		dqr.setCardid("opq");
		dqr.setW_appid("456");
		dqr.setW_name("789");
		dqr.setW_logo("http://www.png");
		dqr.setW_cardid("abc");
		dqr.setTitle("卡卡");
		dqr.setSub_title("-劵");
		dqr.setQuantity("1000");
		dqr.setCost("50");
		dqr.setType("团购");
		dqr.setStatus("已投放");
		dqr.setColor("#123455");
		dqr.setDate_info("2015年12月份有效");
		List<DataQueryRsp> ds = new ArrayList<DataQueryRsp>();
		ds.add(dqr);
		queryRsp.setData(ds);
		logger.info("query rsp--" + JSON.toJSONString(queryRsp));
	}
}
