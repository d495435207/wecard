package com.dxj.wecard.controller;

import java.util.ArrayList;
import java.util.Calendar;
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
import com.dxj.wecard.model.Area;
import com.dxj.wecard.model.Fund;
import com.dxj.wecard.model.Partner;
import com.dxj.wecard.model.WeixinApp;
import com.dxj.wecard.service.AreaService;
import com.dxj.wecard.service.CardService;
import com.dxj.wecard.service.ExcelService;
import com.dxj.wecard.service.FundService;
import com.dxj.wecard.service.PartnerService;
import com.dxj.wecard.service.ReceiveService;
import com.dxj.wecard.service.VerifyService;
import com.dxj.wecard.service.ViewService;
import com.dxj.wecard.service.WeixinAppService;
import com.dxj.wecard.util.Utils;

@Controller
@RequestMapping("/publisher")
public class PublisherController extends BaseController {

	static final Logger logger = LogManager.getLogger(PublisherController.class);

	@Autowired
	private PartnerService partnerService;

	@Autowired
	private WeixinAppService weixinAppService;

	@Autowired
	private AreaService areaService;

	@Autowired
	private FundService fundService;

	@Autowired
	private CardService cardService;

	@Autowired
	private ReceiveService receiveService;

	@Autowired
	private VerifyService verifyService;

	@Autowired
	private ViewService viewService;

	@Autowired
	private ExcelService excelService;

	@AuthPassport
	@RequestMapping("/index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		String appId = (String) session.getAttribute("appId");
		WeixinApp weixinApp = null;
		Fund fund = null;
		int cardCount = 0;
		int cardUpCount = 0;
		Query statInfo = null;
		List<Query> statInfos = null;

		if (id != null)
			fund = fundService.getFundSumByPartner(id);
		if (!StringUtils.isBlank(appId)) {
			weixinApp = weixinAppService.getById(appId);
			cardCount = cardService.getCardCountByApp(appId);
			cardUpCount = cardService.getCardUpCountByApp(appId);
			statInfo = receiveService.getReceiveCountByApp(appId);
			statInfos = receiveService.getReceivesRecentByApp(appId);
		}
		if (fund == null)
			fund = new Fund();
		if (statInfo == null)
			statInfo = new Query();
		if (statInfos == null) {
			statInfos = new ArrayList<Query>();
			statInfos.add(new Query());
		}
		session.setAttribute("isAuth", weixinApp.getIsAuth());
		modelMap.addAttribute("weixinApp", weixinApp);
		modelMap.addAttribute("fund", fund);
		modelMap.addAttribute("cardCount", cardCount);
		modelMap.addAttribute("cardUpCount", cardUpCount);
		modelMap.addAttribute("statInfo", statInfo);
		modelMap.addAttribute("statInfos", statInfos);
		return "/publisher/publisherIndex";
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
		return "/publisher/couponMarket";
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
		return "/publisher/couponMarketAll";
	}

	@AuthPassport
	@RequestMapping("/account")
	public String account(HttpServletRequest request, ModelMap modelMap) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		Partner partner = partnerService.getById(id);
		String appId = (String) session.getAttribute("appId");
		WeixinApp weixinApp = weixinAppService.getById(appId);
		Long rootId = 0L;
		Area province = null, city = null, district = null;
		if (!StringUtils.isBlank(partner.getProvince())) {
			Long provinceId = Long.parseLong(partner.getProvince());
			province = areaService.getById(provinceId, rootId);
			if (!StringUtils.isBlank(partner.getCity())) {
				Long cityId = Long.parseLong(partner.getCity());
				city = areaService.getById(cityId, provinceId);
				if (!StringUtils.isBlank(partner.getDistrict())) {
					Long districtId = Long.parseLong(partner.getDistrict());
					district = areaService.getById(districtId, cityId);
				}
			}
		}
		modelMap.addAttribute("partner", partner);
		modelMap.addAttribute("weixinApp", weixinApp);
		modelMap.addAttribute("province", province);
		modelMap.addAttribute("city", city);
		modelMap.addAttribute("district", district);
		return "/publisher/publisherAccount";
	}

	@AuthPassport
	@RequestMapping("/cash")
	public String cash(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		String appId = (String) session.getAttribute("appId");
		Fund fund = null;
		Query statInfo = null;
		List<Query> queryInfos = null;

		Query pageInfo = new Query();
		pageInfo.setAppId(appId);
		pageInfo.setId(id);
		pageInfo.setPage(page);

		if (id != null) {
			fund = fundService.getFundSumByPartner(id);
			int num = fundService.getFundsPublisherNumByPartner(pageInfo);
			pageInfo.setNum(num);
			queryInfos = fundService.getFundsPublisherByPartner(pageInfo);
		}
		if (!StringUtils.isBlank(appId))
			statInfo = receiveService.getReceiveCountByApp(appId);

		if (fund == null)
			fund = new Fund();
		if (statInfo == null)
			statInfo = new Query();

		modelMap.addAttribute("fund", fund);
		modelMap.addAttribute("statInfo", statInfo);
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/publisher/publisherCash";
	}

	@AuthPassport
	@RequestMapping("/couponManage")
	public String couponManage(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "type", required = false, defaultValue = "") String type,
			@RequestParam(value = "status", required = false, defaultValue = "") String status,
			@RequestParam(value = "title", required = false, defaultValue = "") String title) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		String appId = (String) session.getAttribute("appId");
		BizQuery pageInfo = new BizQuery();
		pageInfo.setAppId(appId);
		pageInfo.setId(id);
		pageInfo.setPage(page);
		if (!StringUtils.isBlank(type))
			pageInfo.setType(type);
		if (!StringUtils.isBlank(status) && Utils.isInt(status))
			pageInfo.setStatus(status);
		if (!StringUtils.isBlank(title))
			pageInfo.setTitle(title);

		List<BizQuery> queryInfos = null;
		if (!StringUtils.isBlank(appId)) {
			int num = cardService.getCardsNumByApp(pageInfo);
			pageInfo.setNum(num);
			queryInfos = cardService.getCardsByApp(pageInfo);
		}
		WeixinApp weixinapp = getCurrentWeixinApp();
		// 判断是否授权信息
		modelMap.addAttribute("weixinapp", weixinapp);
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/publisher/publisherCouponManage";
	}

	@AuthPassport
	@RequestMapping("/couponPut")
	public String couponPut(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "type", required = false, defaultValue = "") String type,
			@RequestParam(value = "title", required = false, defaultValue = "") String title) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		String appId = (String) session.getAttribute("appId");
		BizQuery pageInfo = new BizQuery();
		pageInfo.setAppId(appId);
		pageInfo.setId(id);
		pageInfo.setPage(page);
		pageInfo.setForm("1");
		if (!StringUtils.isBlank(type))
			pageInfo.setType(type);
		if (!StringUtils.isBlank(title))
			pageInfo.setTitle(title);

		List<BizQuery> queryInfos = null;
		if (!StringUtils.isBlank(appId)) {
			int num = cardService.getCardsNumByApp(pageInfo);
			pageInfo.setNum(num);
			queryInfos = cardService.getCardsByApp(pageInfo);
		}
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/publisher/publisherCouponPut";
	}

	@AuthPassport
	@RequestMapping("/couponChoose")
	public String couponChoose(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "type", required = false, defaultValue = "") String type,
			@RequestParam(value = "title", required = false, defaultValue = "") String title) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		String appId = (String) session.getAttribute("appId");
		BizQuery pageInfo = new BizQuery();
		pageInfo.setAppId(appId);
		pageInfo.setId(id);
		pageInfo.setPage(page);
		pageInfo.setForm("2");
		if (!StringUtils.isBlank(type))
			pageInfo.setType(type);
		if (!StringUtils.isBlank(title))
			pageInfo.setTitle(title);

		List<BizQuery> queryInfos = null;
		if (!StringUtils.isBlank(appId)) {
			int num = cardService.getCardsNumByApp(pageInfo);
			pageInfo.setNum(num);
			queryInfos = cardService.getCardsByApp(pageInfo);
		}
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/publisher/publisherCouponChoose";
	}

	@AuthPassport
	@RequestMapping("/modifyPassword")
	public String modifyPassword(ModelMap modelMap) {
		return "/publisher/modifyPassword";
	}

	@AuthPassport
	@RequestMapping("/spend")
	public String spend(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "startTime", required = false, defaultValue = "") String startTime,
			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		String appId = (String) session.getAttribute("appId");
		Fund fund = null;
		Query statInfo = null;
		List<Query> queryInfos = null;

		Query pageInfo = new Query();
		pageInfo.setAppId(appId);
		pageInfo.setId(id);
		pageInfo.setPage(page);
		if (!StringUtils.isBlank(startTime))
			pageInfo.setStartTime(Utils.getDate(startTime, "yyyy-MM-dd"));
		if (!StringUtils.isBlank(endTime))
			pageInfo.setEndTime(Utils.getDate(endTime, "yyyy-MM-dd"));

		if (id != null)
			fund = fundService.getFundSumByPartner(id);

		if (!StringUtils.isBlank(appId)) {
			statInfo = receiveService.getReceiveCountByApp(appId);
			int num = receiveService.getReceivesPublisherCashNumByApp(pageInfo);
			pageInfo.setNum(num);
			queryInfos = receiveService.getReceivesPublisherCashByApp(pageInfo);
		}
		if (fund == null)
			fund = new Fund();
		if (statInfo == null)
			statInfo = new Query();

		modelMap.addAttribute("fund", fund);
		modelMap.addAttribute("statInfo", statInfo);
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/publisher/publisherSpend";
	}

	@AuthPassport
	@RequestMapping("/spendExcel")
	public void spendExcel(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "startTime", required = false, defaultValue = "") String startTime,
			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		String appId = (String) session.getAttribute("appId");
		List<Query> queryInfos = null;

		Query pageInfo = new Query();
		pageInfo.setAppId(appId);
		pageInfo.setId(id);
		if (!StringUtils.isBlank(startTime))
			pageInfo.setStartTime(Utils.getDate(startTime, "yyyy-MM-dd"));
		if (!StringUtils.isBlank(endTime))
			pageInfo.setEndTime(Utils.getDate(endTime, "yyyy-MM-dd"));

		if (!StringUtils.isBlank(appId))
			queryInfos = receiveService.getReceivesPublisherCashByAppAll(pageInfo);

		byte[] bytes = excelService.getExcelForSpend(queryInfos);
		excelService.resetRes(response, bytes, "spend");
	}

	@AuthPassport
	@RequestMapping("/spendDetailExcel")
	public void spendDetailExcel(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "atTime", required = false, defaultValue = "") String atTime,
			@RequestParam(value = "balance", required = false, defaultValue = "") String balance) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		String appId = (String) session.getAttribute("appId");
		List<BizQuery> queryInfos = null;
		Query pageInfo = new Query();
		pageInfo.setAppId(appId);
		pageInfo.setId(id);
		if (!StringUtils.isBlank(atTime)) {
			Date time = Utils.getDate(atTime, "yyyy-MM-dd");
			pageInfo.setStartTime(time);
			pageInfo.setEndTime(Utils.getAddDate(time, 1));
		}

		Integer last = null;
		if (!StringUtils.isBlank(balance) && Utils.isInt(balance)) {
			last = Integer.valueOf(balance);
		}
		if (!StringUtils.isBlank(appId)) {
			queryInfos = receiveService.getReceivesByPublisherSpendDetailAll(pageInfo, last);
		}

		byte[] bytes = excelService.getExcelForSpendDetail(queryInfos);
		excelService.resetRes(response, bytes, "spendDetail");
	}

	@AuthPassport
	@RequestMapping("/spendDetail")
	public String spendDetail(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "atTime", required = false, defaultValue = "") String atTime,
			@RequestParam(value = "balance", required = false, defaultValue = "") String balance) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("partnerId");
		String appId = (String) session.getAttribute("appId");
		List<BizQuery> queryInfos = null;
		Query pageInfo = new Query();
		pageInfo.setAppId(appId);
		pageInfo.setId(id);
		pageInfo.setPage(page);
		if (!StringUtils.isBlank(atTime)) {
			Date time = Utils.getDate(atTime, "yyyy-MM-dd");
			pageInfo.setStartTime(time);
			pageInfo.setEndTime(Utils.getAddDate(time, 1));
		}
		if (!StringUtils.isBlank(balance) && Utils.isInt(balance)) {
			pageInfo.setBalance(Integer.valueOf(balance));
		}
		if (!StringUtils.isBlank(appId)) {
			int num = receiveService.getReceivesNumByPublisherSpendDetail(pageInfo);
			pageInfo.setNum(num);
			queryInfos = receiveService.getReceivesByPublisherSpendDetail(pageInfo);
		}

		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/publisher/publisherSpendDetail";
	}

	@AuthPassport
	@RequestMapping("/useDetail")
	public String useDetail(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "cardId", required = false, defaultValue = "1") String cardId) {
		Query pageInfo = new Query();
		pageInfo.setSize(5);
		pageInfo.setPage(page);
		if (!StringUtils.isBlank(cardId) && Utils.isInt(cardId))
			pageInfo.setId(Integer.valueOf(cardId));
		int num = verifyService.getCardsVerifyNumByApp(pageInfo);
		pageInfo.setNum(num);
		List<BizQuery> queryInfos = verifyService.getCardsVerifyByApp(pageInfo);
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/publisher/useDetail";
	}

	@AuthPassport
	@RequestMapping("/pickDetail")
	public String pickDetail(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "cardId", required = false, defaultValue = "1") String cardId) {
		Query pageInfo = new Query();
		pageInfo.setSize(5);
		pageInfo.setPage(page);
		if (!StringUtils.isBlank(cardId) && Utils.isInt(cardId))
			pageInfo.setId(Integer.valueOf(cardId));
		int num = receiveService.getCardsReceiveNumByApp(pageInfo);
		pageInfo.setNum(num);
		List<BizQuery> queryInfos = receiveService.getCardsReceiveByApp(pageInfo);
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/publisher/pickDetail";
	}

	@AuthPassport
	@ResponseBody
	@RequestMapping("/cashPay")
	public String cashPay(HttpServletRequest request, String charge) {
		if (StringUtils.isBlank(charge) || !Utils.isCurrency(charge)) {
			return Utils.getJsonResult("success", "1002", "充值金额有误");
		}
		try {
			HttpSession session = request.getSession();
			Integer id = (Integer) session.getAttribute("partnerId");
			Fund record = new Fund();
			record.setPartnerId(id);
			record.setDebitAmount((int) (Double.parseDouble(charge) * 100));
			record.setAtTime(Calendar.getInstance().getTime());
			int result = fundService.insert(record);
			if (result == 1)
				return Utils.getJsonResult("success", "1000", "充值成功");
		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@AuthPassport
	@RequestMapping("/partner/modify")
	@ResponseBody
	public String partnerModify(HttpServletRequest request, @RequestBody Partner partner) {
		try {
			if (StringUtils.isBlank(partner.getContacts())) {
				return Utils.getJsonResult("success", "1001", "请输入联系人");
			}
			if (StringUtils.isBlank(partner.getCompany())) {
				return Utils.getJsonResult("success", "1002", "请输入商家名称");
			}
			if (StringUtils.isBlank(partner.getAddress())) {
				return Utils.getJsonResult("success", "1003", "请输入详细联系地址");
			}
			if (StringUtils.isBlank(partner.getMail()) || !Utils.isMail(partner.getMail())) {
				return Utils.getJsonResult("success", "1004", "请输入电子邮箱/电子邮箱输入有误");
			}
			HttpSession session = request.getSession();
			Integer id = (Integer) session.getAttribute("partnerId");
			Partner record = partnerService.getById(id);
			record.setContacts(partner.getContacts());
			record.setCompany(partner.getCompany());
			record.setMail(partner.getMail());
			record.setProvince(partner.getProvince());
			record.setCity(partner.getCity());
			record.setDistrict(partner.getDistrict());
			record.setAddress(partner.getAddress());
			int resul = partnerService.update(record);
			if (resul == 1) {
				return Utils.getJsonResult("success", "1000", "基本信息修改成功");
			}

		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@AuthPassport
	@RequestMapping("/card/updateStock")
	@ResponseBody
	public String updateStock(HttpServletRequest request, String stock, String cardId) {
		try {
			if (StringUtils.isBlank(cardId) || !Utils.isInt(cardId)) {
				return Utils.getJsonResult("success", "1001", "卡劵Id输入有误");
			}
			if (StringUtils.isBlank(stock) || !Utils.isInt(stock)) {
				return Utils.getJsonResult("success", "1002", "库存数量输入有误");
			}
			int resul = cardService.updateStock(Integer.valueOf(cardId), Integer.valueOf(stock));
			if (resul == 1) {
				return Utils.getJsonResult("success", "1000", "库存数量修改成功");
			}

		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@AuthPassport
	@RequestMapping("/card/updateCost")
	@ResponseBody
	public String updateCost(HttpServletRequest request, String cost, String cardId) {
		try {
			if (StringUtils.isBlank(cardId) || !Utils.isInt(cardId)) {
				return Utils.getJsonResult("success", "1001", "卡劵Id输入有误");
			}
			if (StringUtils.isBlank(cost) || !Utils.isDouble(cost)) {
				return Utils.getJsonResult("success", "1002", "卡劵单价输入有误");
			}
			int resul = cardService.updateCost(Integer.valueOf(cardId), Double.valueOf(cost));
			if (resul == 1) {
				return Utils.getJsonResult("success", "1000", "卡劵单价修改成功");
			}

		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@AuthPassport
	@RequestMapping("/card/updateCostPut")
	@ResponseBody
	public String updateCostPut(HttpServletRequest request, String cost, String cardId) {
		try {
			if (StringUtils.isBlank(cardId) || !Utils.isInt(cardId)) {
				return Utils.getJsonResult("success", "1001", "卡劵Id输入有误");
			}
			if (StringUtils.isBlank(cost) || !Utils.isDouble(cost)) {
				return Utils.getJsonResult("success", "1002", "卡劵单价输入有误");
			}
			int resul = cardService.updateCostStatus(Integer.valueOf(cardId), Double.valueOf(cost), 1);
			if (resul == 1) {
				return Utils.getJsonResult("success", "1000", "卡劵单价修改成功");
			}

		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@AuthPassport
	@RequestMapping("/card/delete")
	@ResponseBody
	public String cardDelete(HttpServletRequest request, String cardId) {
		try {
			if (StringUtils.isBlank(cardId) || !Utils.isInt(cardId)) {
				return Utils.getJsonResult("success", "1001", "卡劵Id输入有误");
			}
			int resul = cardService.delete(Integer.valueOf(cardId));
			if (resul == 1) {
				return Utils.getJsonResult("success", "1000", "卡劵删除成功");
			}

		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@AuthPassport
	@RequestMapping("/card/down")
	@ResponseBody
	public String cardDown(HttpServletRequest request, String cardId) {
		try {
			if (StringUtils.isBlank(cardId) || !Utils.isInt(cardId)) {
				return Utils.getJsonResult("success", "1001", "卡劵Id输入有误");
			}
			int resul = cardService.down(Integer.valueOf(cardId));
			if (resul == 1) {
				return Utils.getJsonResult("success", "1000", "卡劵下架成功");
			}

		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}
}