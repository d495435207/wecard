package com.dxj.wecard.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxj.wecard.auth.AuthPassport;
import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.model.Fund;
import com.dxj.wecard.model.Partner;
import com.dxj.wecard.service.ExcelService;
import com.dxj.wecard.service.FundService;
import com.dxj.wecard.service.PartnerService;
import com.dxj.wecard.service.ReceiveService;
import com.dxj.wecard.service.VerifyService;
import com.dxj.wecard.service.ViewService;
import com.dxj.wecard.util.Utils;

@Controller
@RequestMapping("/underwriter")
public class UnderwriterController extends BaseController {

	static final Logger logger = LogManager.getLogger(UnderwriterController.class);

	@Autowired
	private PartnerService partnerService;

	@Autowired
	private ReceiveService receiveService;

	@Autowired
	private VerifyService verifyService;

	@Autowired
	private ViewService viewService;

	@Autowired
	private ExcelService excelService;

	@Autowired
	private FundService fundService;

	@AuthPassport
	@RequestMapping("/index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		Query statInfo = null;
		List<Query> statInfos = null;
		if (id != null) {
			statInfo = receiveService.getReceiveCountByUnderwriter(id);
			statInfos = receiveService.getReceivesRecentByUnderwriter(id);
		}
		if (statInfo == null)
			statInfo = new Query();
		if (statInfos == null) {
			statInfos = new ArrayList<Query>();
			statInfos.add(new Query());
		}
		modelMap.addAttribute("statInfo", statInfo);
		modelMap.addAttribute("statInfos", statInfos);
		return "/underwriter/underwriterIndex";
	}

	@AuthPassport
	@RequestMapping("/couponMarket")
	public String couponMarket(ModelMap modelMap) {
		List<BizQuery> receivesTopUser = receiveService.getReceivesTopUser();
		List<BizQuery> receivesTopCnt = receiveService.getReceivesTopCnt();
		List<BizQuery> verifiesTopCnt = verifyService.getVerifiesTopCnt();
		List<BizQuery> viewsTopCnt = viewService.getViewsTopCnt();
		modelMap.addAttribute("receivesTopUser", receivesTopUser);
		modelMap.addAttribute("receivesTopCnt", receivesTopCnt);
		modelMap.addAttribute("verifiesTopCnt", verifiesTopCnt);
		modelMap.addAttribute("viewsTopCnt", viewsTopCnt);
		return "/underwriter/couponMarket";
	}

	@AuthPassport
	@RequestMapping("/couponMarketAll")
	public String couponMarketAll(ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "type", required = false, defaultValue = "1") int type) {
		BizQuery pageInfo = new BizQuery();
		pageInfo.setType("" + type);
		pageInfo.setPage(page);
		List<BizQuery> queryInfos = new ArrayList<BizQuery>();
		int num = 0;
		switch (type) {
		case 2:
			num = receiveService.getReceivesNumCnt(pageInfo);
			pageInfo.setNum(num);
			queryInfos = receiveService.getReceivesCnt(pageInfo);
			break;
		case 3:
			num = viewService.getViewsNumCnt(pageInfo);
			pageInfo.setNum(num);
			queryInfos = viewService.getViewsCnt(pageInfo);
			break;
		case 4:
			num = verifyService.getVerifiesNumCnt(pageInfo);
			pageInfo.setNum(num);
			queryInfos = verifyService.getVerifiesCnt(pageInfo);
			break;
		default:
			num = receiveService.getReceivesNumUser(pageInfo);
			pageInfo.setNum(num);
			queryInfos = receiveService.getReceivesUser(pageInfo);
			break;
		}
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/underwriter/couponMarketAll";
	}

	@AuthPassport
	@RequestMapping("/modifyPassword")
	public String modifyPassword(ModelMap modelMap) {
		return "/underwriter/modifyPassword";
	}

	@AuthPassport
	@RequestMapping("/account")
	public String account(HttpServletRequest request, ModelMap modelMap) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		Partner partner = partnerService.getById(id);
		modelMap.addAttribute("partner", partner);
		return "/underwriter/underwriterAccount";
	}

	@AuthPassport
	@RequestMapping("/updateUnderwriter")
	@ResponseBody
	public String updateUnderwriter(HttpServletRequest request, @RequestBody Partner partner) {
		try {
			if (StringUtils.isBlank(partner.getBankName())) {
				return Utils.getJsonResult("success", "1001", "请输入银行名称");
			}
			if (StringUtils.isBlank(partner.getBankAccount())) {
				return Utils.getJsonResult("success", "1002", "请输入开户行名称");
			}
			if (StringUtils.isBlank(partner.getPayee())) {
				return Utils.getJsonResult("success", "1003", "请输入收款方");
			}
			if (StringUtils.isBlank(partner.getOpeningBankName())) {
				return Utils.getJsonResult("success", "1004", "请输入银行账号");
			}
			HttpSession session = request.getSession();
			Integer id = (Integer) session.getAttribute("partnerId");
			Partner record = partnerService.getById(id);
			record.setBankName(partner.getBankName());
			record.setBankAccount(partner.getBankAccount());
			record.setPayee(partner.getPayee());
			record.setOpeningBankName(partner.getOpeningBankName());
			int resul = partnerService.update(record);
			if (resul == 1) {
				return Utils.getJsonResult("success", "1000", "财务信息修改成功");
			}

		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@AuthPassport
	@RequestMapping("/cash")
	public String cash(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "startTime", required = false, defaultValue = "") String startTime,
			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		Query statInfo = null;
		List<Query> queryInfos = null;

		Query pageInfo = new Query();
		pageInfo.setId(id);
		pageInfo.setPage(page);
		if (!StringUtils.isBlank(startTime))
			pageInfo.setStartTime(Utils.getDate(startTime, "yyyy-MM-dd"));
		if (!StringUtils.isBlank(endTime))
			pageInfo.setEndTime(Utils.getDate(endTime, "yyyy-MM-dd"));

		if (id != null) {
			statInfo = receiveService.getReceiveCountByUnderwriter(id);
			int num = receiveService.getReceivesCashNumByUnderwriter(pageInfo);
			pageInfo.setNum(num);
			queryInfos = receiveService.getReceivesCashByUnderwriter(pageInfo);
		}
		if (statInfo == null)
			statInfo = new Query();

		modelMap.addAttribute("statInfo", statInfo);
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/underwriter/underwriterCash";
	}

	@AuthPassport
	@RequestMapping("/cashDetail")
	public String cashDetail(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "atTime", required = false, defaultValue = "") String atTime) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		List<BizQuery> queryInfos = null;
		Query pageInfo = new Query();
		pageInfo.setId(id);
		pageInfo.setPage(page);
		if (!StringUtils.isBlank(atTime)) {
			Date time = Utils.getDate(atTime, "yyyy-MM-dd");
			pageInfo.setStartTime(time);
			pageInfo.setEndTime(Utils.getAddDate(time, 1));
		}
		if (id != null) {
			int num = receiveService.getReceivesCashDetailNumByUnderwriter(pageInfo);
			pageInfo.setNum(num);
			queryInfos = receiveService.getReceivesCashDetailByUnderwriter(pageInfo);
		}
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/underwriter/underwriterCashDetail";
	}

	@AuthPassport
	@RequestMapping("/cashExcel")
	public void cashExcel(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "startTime", required = false, defaultValue = "") String startTime,
			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		List<Query> queryInfos = null;

		Query pageInfo = new Query();
		pageInfo.setId(id);
		if (!StringUtils.isBlank(startTime))
			pageInfo.setStartTime(Utils.getDate(startTime, "yyyy-MM-dd"));
		if (!StringUtils.isBlank(endTime))
			pageInfo.setEndTime(Utils.getDate(endTime, "yyyy-MM-dd"));

		if (id != null) {
			queryInfos = receiveService.getReceivesCashByUnderwriterAll(pageInfo);
		}

		byte[] bytes = excelService.getExcelForCash(queryInfos);
		excelService.resetRes(response, bytes, "cash");
	}

	@AuthPassport
	@RequestMapping("/cashDetailExcel")
	public void cashDetailExcel(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "atTime", required = false, defaultValue = "") String atTime) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		List<BizQuery> queryInfos = null;
		Query pageInfo = new Query();
		pageInfo.setId(id);
		if (!StringUtils.isBlank(atTime)) {
			Date time = Utils.getDate(atTime, "yyyy-MM-dd");
			pageInfo.setStartTime(time);
			pageInfo.setEndTime(Utils.getAddDate(time, 1));
		}
		if (id != null)
			queryInfos = receiveService.getReceivesCashDetailByUnderwriterAll(pageInfo);

		byte[] bytes = excelService.getExcelForCashDetail(queryInfos);
		excelService.resetRes(response, bytes, "cashDetail");
	}

	@AuthPassport
	@RequestMapping("/spend")
	public String spend(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		Query statInfo = null;
		Fund fund = null;
		List<Query> queryInfos = null;
		Query pageInfo = new Query();
		pageInfo.setId(id);
		pageInfo.setPage(page);
		if (id != null) {
			fund = fundService.getFundSumByPartner(id);
			statInfo = receiveService.getReceiveCountByUnderwriter(id);
			int num = fundService.getFundsCashNumByManagerUnderwriter(pageInfo);
			pageInfo.setNum(num);
			queryInfos = fundService.getFundsCashByManagerUnderwriter(pageInfo);
		}
		if (fund == null)
			fund = new Fund();
		if (statInfo == null)
			statInfo = new Query();

		modelMap.addAttribute("fund", fund);
		modelMap.addAttribute("statInfo", statInfo);
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/underwriter/underwriterSpend";
	}

	@AuthPassport
	@RequestMapping("/spendDetail")
	public String spendDetail(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "id", required = false, defaultValue = "") String id,
			@RequestParam(value = "cost", required = false, defaultValue = "") String cost,
			@RequestParam(value = "charge", required = false, defaultValue = "") String charge) {
		BizQuery pageInfo = new BizQuery();
		Fund record = null;
		if (!StringUtils.isBlank(id) && Utils.isInt(id)) {
			pageInfo.setId(Integer.valueOf(id));
			record = fundService.getById(pageInfo.getId());
		}
		if (!StringUtils.isBlank(cost) && Utils.isInt(cost))
			pageInfo.setCost(Integer.valueOf(cost));
		if (!StringUtils.isBlank(charge) && Utils.isInt(charge))
			pageInfo.setCharge(Integer.valueOf(charge));
		modelMap.addAttribute("pageInfo", pageInfo);
		modelMap.addAttribute("fund", record);
		return "/underwriter/underwriterSpendDetail";
	}
}