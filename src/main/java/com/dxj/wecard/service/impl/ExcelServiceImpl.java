package com.dxj.wecard.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.springframework.stereotype.Service;

import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.service.ExcelService;
import com.dxj.wecard.util.Utils;
import com.dxj.wecard.util.velocity.NumericTool;

@Service("excelService")
public class ExcelServiceImpl implements ExcelService {

	@Override
	public void resetRes(HttpServletResponse response, byte[] bytes, String name) {
		try {
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;filename=" + name + ".xls");
			response.setContentLength(bytes.length);
			response.getOutputStream().write(bytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
		}
	}

	@Override
	public byte[] getExcelForSpendDetail(List<BizQuery> records) {
		InputStream in = null;
		ByteArrayOutputStream out = null;
		NPOIFSFileSystem fs = null;
		HSSFWorkbook wb = null;
		try {
			in = this.getClass().getResourceAsStream("/excel/spendDetail.xls");
			fs = new NPOIFSFileSystem(in);
			wb = new HSSFWorkbook(fs.getRoot(), true);
			HSSFSheet sheet = wb.getSheetAt(0);
			int i = 0;
			double num = 100;
			for (BizQuery q : records) {
				i++;
				HSSFRow row = sheet.createRow(i);
				int j = 0;
				row.createCell(j).setCellValue(Utils.getDateString(q.getAtTime(), "HH:mm:ss"));
				j++;
				row.createCell(j).setCellValue(q.getTitle());
				j++;
				row.createCell(j).setCellValue(NumericTool.toFixedCurrency(q.getCost() / num));
				j++;
				row.createCell(j).setCellValue(NumericTool.toFixedCurrency(q.getBalance() / num));
				j++;
				row.createCell(j).setCellValue(q.getName());
			}
			out = new ByteArrayOutputStream();
			wb.write(out);
		} catch (IOException e) {
		} finally {
			try {
				if (out != null)
					out.close();
				if (wb != null)
					wb.close();
				if (fs != null)
					fs.close();
				if (in != null)
					in.close();
			} catch (Exception e) {
			}
		}
		return out.toByteArray();
	}

	@Override
	public byte[] getExcelForSpend(List<Query> records) {
		InputStream in = null;
		ByteArrayOutputStream out = null;
		NPOIFSFileSystem fs = null;
		HSSFWorkbook wb = null;
		try {
			in = this.getClass().getResourceAsStream("/excel/spend.xls");
			fs = new NPOIFSFileSystem(in);
			wb = new HSSFWorkbook(fs.getRoot(), true);
			HSSFSheet sheet = wb.getSheetAt(0);
			int i = 0;
			double num = 100;
			for (Query q : records) {
				i++;
				HSSFRow row = sheet.createRow(i);
				int j = 0;
				row.createCell(j).setCellValue(Utils.getDateString(q.getAtTime(), "yyyy-MM-dd"));
				j++;
				row.createCell(j).setCellValue(NumericTool.toFixedCurrency(q.getSum() / num));
				j++;
				row.createCell(j).setCellValue(NumericTool.toFixedCurrency(q.getBalance() / num));
			}
			out = new ByteArrayOutputStream();
			wb.write(out);
		} catch (IOException e) {
		} finally {
			try {
				if (out != null)
					out.close();
				if (wb != null)
					wb.close();
				if (fs != null)
					fs.close();
				if (in != null)
					in.close();
			} catch (Exception e) {
			}
		}
		return out.toByteArray();
	}

	@Override
	public byte[] getExcelForCashDetail(List<BizQuery> records) {
		InputStream in = null;
		ByteArrayOutputStream out = null;
		NPOIFSFileSystem fs = null;
		HSSFWorkbook wb = null;
		try {
			in = this.getClass().getResourceAsStream("/excel/cashDetail.xls");
			fs = new NPOIFSFileSystem(in);
			wb = new HSSFWorkbook(fs.getRoot(), true);
			HSSFSheet sheet = wb.getSheetAt(0);
			int i = 0;
			double num = 100;
			for (BizQuery q : records) {
				i++;
				HSSFRow row = sheet.createRow(i);
				int j = 0;
				row.createCell(j).setCellValue(Utils.getDateString(q.getAtTime(), "HH:mm:ss"));
				j++;
				row.createCell(j).setCellValue(q.getTitle());
				j++;
				row.createCell(j).setCellValue(NumericTool.toFixedCurrency(q.getCost() / num));
				j++;
				row.createCell(j).setCellValue(NumericTool.toFixedCurrency(q.getCharge() / num));
				j++;
				row.createCell(j).setCellValue(q.getName());
			}
			out = new ByteArrayOutputStream();
			wb.write(out);
		} catch (IOException e) {
		} finally {
			try {
				if (out != null)
					out.close();
				if (wb != null)
					wb.close();
				if (fs != null)
					fs.close();
				if (in != null)
					in.close();
			} catch (Exception e) {
			}
		}
		return out.toByteArray();
	}

	@Override
	public byte[] getExcelForCash(List<Query> records) {
		InputStream in = null;
		ByteArrayOutputStream out = null;
		NPOIFSFileSystem fs = null;
		HSSFWorkbook wb = null;
		try {
			in = this.getClass().getResourceAsStream("/excel/cash.xls");
			fs = new NPOIFSFileSystem(in);
			wb = new HSSFWorkbook(fs.getRoot(), true);
			HSSFSheet sheet = wb.getSheetAt(0);
			int i = 0;
			double num = 100;
			for (Query q : records) {
				i++;
				HSSFRow row = sheet.createRow(i);
				int j = 0;
				row.createCell(j).setCellValue(Utils.getDateString(q.getAtTime(), "yyyy-MM-dd"));
				j++;
				row.createCell(j).setCellValue("" + q.getCount());
				j++;
				row.createCell(j).setCellValue(NumericTool.toFixedCurrency(q.getSum() / num));
			}
			out = new ByteArrayOutputStream();
			wb.write(out);
		} catch (IOException e) {
		} finally {
			try {
				if (out != null)
					out.close();
				if (wb != null)
					wb.close();
				if (fs != null)
					fs.close();
				if (in != null)
					in.close();
			} catch (Exception e) {
			}
		}
		return out.toByteArray();
	}
}