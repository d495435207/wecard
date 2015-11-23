package com.dxj.wecard.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;

public interface ExcelService {

	void resetRes(HttpServletResponse response, byte[] bytes, String name);

	byte[] getExcelForSpend(List<Query> records);

	byte[] getExcelForSpendDetail(List<BizQuery> records);

	byte[] getExcelForCash(List<Query> records);

	byte[] getExcelForCashDetail(List<BizQuery> records);
}