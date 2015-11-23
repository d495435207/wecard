package com.dxj.wecard.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.dxj.wecard.model.User;
import com.dxj.wecard.model.WeixinApp;
import com.dxj.wecard.service.CardService;
import com.dxj.wecard.service.FundService;
import com.dxj.wecard.service.PartnerService;
import com.dxj.wecard.service.ReceiveService;
import com.dxj.wecard.service.UserPartnerService;
import com.dxj.wecard.service.UserService;
import com.dxj.wecard.service.VerifyService;
import com.dxj.wecard.service.ViewService;
import com.dxj.wecard.util.MD5;
import com.dxj.wecard.util.Utils;

@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {

	static final Logger logger = LogManager.getLogger(ManagerController.class);

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
	private UserService userService;

	@Autowired
	private UserPartnerService userPartnerService;

	@Autowired
	private PartnerService partnerService;

	@AuthPassport
	@RequestMapping("/index")
	public String index(ModelMap modelMap) {
		Integer id = null;
		String appId = null;
		Fund fund = fundService.getFundSumByPartner(id);
		int cardCount = cardService.getCardCountByApp(appId);
		int cardUpCount = cardService.getCardUpCountByApp(appId);
		Query statInfo = receiveService.getReceiveCountByApp(appId);
		List<Query> statInfos = receiveService.getReceivesRecentByApp(appId);

		if (fund == null)
			fund = new Fund();
		if (statInfo == null)
			statInfo = new Query();
		if (statInfos == null) {
			statInfos = new ArrayList<Query>();
			statInfos.add(new Query());
		}
		modelMap.addAttribute("fund", fund);
		modelMap.addAttribute("cardCount", cardCount);
		modelMap.addAttribute("cardUpCount", cardUpCount);
		modelMap.addAttribute("statInfo", statInfo);
		modelMap.addAttribute("statInfos", statInfos);
		return "/manager/managerIndex";
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
		return "/manager/couponMarket";
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
		return "/manager/couponMarketAll";
	}

	@AuthPassport
	@RequestMapping("/modifyPassword")
	public String modifyPassword(ModelMap modelMap) {
		return "/manager/modifyPassword";
	}

	@AuthPassport
	@RequestMapping("/couponManage")
	public String couponManage(ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "type", required = false, defaultValue = "") String type,
			@RequestParam(value = "status", required = false, defaultValue = "") String status,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		Integer id = null;
		String appId = null;
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
		if (!StringUtils.isBlank(name))
			pageInfo.setName(name);
		int num = cardService.getCardsNumByApp(pageInfo);
		pageInfo.setNum(num);
		List<BizQuery> queryInfos = cardService.getCardsByApp(pageInfo);

		WeixinApp weixinapp = getCurrentWeixinApp();
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		// 判断是否授权信息
		modelMap.addAttribute("weixinapp", weixinapp);
		return "/manager/managerCouponManage";
	}

	@AuthPassport
	@RequestMapping("/couponPut")
	public String couponPut(ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "type", required = false, defaultValue = "") String type,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		Integer id = null;
		String appId = null;
		BizQuery pageInfo = new BizQuery();
		pageInfo.setAppId(appId);
		pageInfo.setId(id);
		pageInfo.setPage(page);
		pageInfo.setForm("1");
		if (!StringUtils.isBlank(type))
			pageInfo.setType(type);
		if (!StringUtils.isBlank(title))
			pageInfo.setTitle(title);
		if (!StringUtils.isBlank(name))
			pageInfo.setName(name);
		int num = cardService.getCardsNumByApp(pageInfo);
		pageInfo.setNum(num);
		List<BizQuery> queryInfos = cardService.getCardsByApp(pageInfo);
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/manager/managerCouponPut";
	}

	@AuthPassport
	@RequestMapping("/useDetail")
	public String useDetail(ModelMap modelMap,
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
		return "/manager/useDetail";
	}

	@AuthPassport
	@RequestMapping("/pickDetail")
	public String pickDetail(ModelMap modelMap,
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
		return "/manager/pickDetail";
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
	public String updateCost(String cost, String cardId) {
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
	public String updateCostPut(String cost, String cardId) {
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
	@RequestMapping("/card/down")
	@ResponseBody
	public String cardDown(String cardId) {
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

	@AuthPassport
	@RequestMapping("/updateCharge")
	@ResponseBody
	public String updateCharge(String id, String charge) {
		try {
			if (StringUtils.isBlank(id) || !Utils.isInt(id)) {
				return Utils.getJsonResult("success", "1001", "充值Id输入有误");
			}
			if (StringUtils.isBlank(charge) || !Utils.isDouble(charge)) {
				return Utils.getJsonResult("success", "1002", "充值金额输入有误");
			}
			Fund record = new Fund();
			record.setPartnerId(Integer.valueOf(id));
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
	@RequestMapping("/createPublisher")
	public String createPublisher(ModelMap modelMap) {
		return "/manager/createPublisher";
	}

	@AuthPassport
	@RequestMapping("/createUnderwriter")
	public String createUnderwriter(ModelMap modelMap) {
		return "/manager/createUnderwriter";
	}

	@AuthPassport
	@RequestMapping("/getCash")
	public String getCash(ModelMap modelMap) {
		return "/manager/getCash";
	}

	@AuthPassport
	@RequestMapping("/managerCharge")
	public String managerCharge(ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "id", required = false, defaultValue = "") String id,
			@RequestParam(value = "appId", required = false, defaultValue = "") String appId) {

		Fund fund = null;
		Query statInfo = null;
		List<Query> queryInfos = null;

		Query pageInfo = new Query();
		pageInfo.setPage(page);
		pageInfo.setAppId(appId);
		if (!StringUtils.isBlank(id) && Utils.isInt(id)) {
			fund = fundService.getFundSumByPartner(Integer.valueOf(id));
			pageInfo.setId(Integer.valueOf(id));
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
		return "/manager/managerCharge";
	}

	@AuthPassport
	@RequestMapping("/couponChoose")
	public String couponChoose(ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "type", required = false, defaultValue = "") String type,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		Integer id = null;
		String appId = null;
		BizQuery pageInfo = new BizQuery();
		pageInfo.setAppId(appId);
		pageInfo.setId(id);
		pageInfo.setPage(page);
		pageInfo.setForm("2");
		if (!StringUtils.isBlank(type))
			pageInfo.setType(type);
		if (!StringUtils.isBlank(title))
			pageInfo.setTitle(title);
		if (!StringUtils.isBlank(name))
			pageInfo.setName(name);
		int num = cardService.getCardsNumByApp(pageInfo);
		pageInfo.setNum(num);
		List<BizQuery> queryInfos = cardService.getCardsByApp(pageInfo);
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/manager/managerCouponChoose";
	}

	@AuthPassport
	@RequestMapping("/publisherManage")
	public String publisherManage(ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "user", required = false, defaultValue = "") String user,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		Integer id = null;
		String appId = null;
		BizQuery pageInfo = new BizQuery();
		//获取页面信息pageInfo
		pageInfo.setAppId(appId);
		pageInfo.setId(id);
		pageInfo.setPage(page);
		if (!StringUtils.isBlank(user))
			pageInfo.setUserId(user);
		if (!StringUtils.isBlank(name))
			pageInfo.setName(name);
		int num = fundService.getFundsNumByManagerPublisher(pageInfo);
		pageInfo.setNum(num);
		List<BizQuery> queryInfos = fundService.getFundsByManagerPublisher(pageInfo);
		BizQuery statInfo = fundService.getCountByManagerPublisher();
		modelMap.addAttribute("statInfo", statInfo);
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/manager/publisherManage";
	}

	@AuthPassport
	@RequestMapping("/createAccount")
	@ResponseBody
	public String createAccount(String phone, String password) {
		if (StringUtils.isBlank(phone) || !Utils.isPhone(phone)) {
			return Utils.getJsonResult("success", "1001", "手机号有误");
		}
		if (StringUtils.isBlank(password)) {
			return Utils.getJsonResult("success", "1003", "密码不能为空");
		}
		if (StringUtils.length(password) < 6 || StringUtils.length(password) > 32) {
			return Utils.getJsonResult("success", "1004", "密码长度有误");
		}
		try {
			User user = userService.getById(phone);
			if (user != null) {
				return Utils.getJsonResult("success", "1002", "此号码已注册");
			}
			user = new User();
			user.setId(phone);
			user.setPassword(MD5.GetMD5Code(password));
			user.setIsAdmin(0);
			Partner partner = new Partner();
			partner.setRole(0);
			int resul = userPartnerService.addUserPartner(user, partner);
			if (resul == 1) {
				return Utils.getJsonResult("success", "1000", "创建账户成功");
			}

		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@AuthPassport
	@RequestMapping("/deleteAccount")
	@ResponseBody
	public String deleteAccount(String partnerId , String userId) {
		try {
			// User user = userService.getById(userId);
			int resul = userPartnerService.deleteUser(partnerId,userId);
			if (resul == 1) {
				return Utils.getJsonResult("success", "1000", "删除成功");
			}

		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@AuthPassport
	@RequestMapping("/addUnderwriter")
	@ResponseBody
	public String addUnderwriter(HttpServletRequest request, @RequestBody Partner partner) {
		try {
			if (partner == null)
				return Utils.getJsonResult("fail", "0001", "输入的承销商信息有误");
			if (StringUtils.isBlank(partner.getDevId()) || !Utils.isPhone(partner.getDevId())) {
				return Utils.getJsonResult("success", "1001", "手机号有误");
			}
			if (StringUtils.isBlank(partner.getCompany())) {
				return Utils.getJsonResult("success", "1003", "请输入承销商名称");
			}
			if (StringUtils.isBlank(partner.getDevSecret())) {
				return Utils.getJsonResult("success", "1004", "密码不能为空");
			}
			if (StringUtils.length(partner.getDevSecret()) < 6 || StringUtils.length(partner.getDevSecret()) > 32) {
				return Utils.getJsonResult("success", "1005", "密码长度有误");
			}
			if (partner.getShareRate() == null) {
				return Utils.getJsonResult("success", "1006", "分成比例有误");
			}
			if (StringUtils.isBlank(partner.getBankName())) {
				return Utils.getJsonResult("success", "1007", "	银行名称有误");
			}
			if (StringUtils.isBlank(partner.getPayee())) {
				return Utils.getJsonResult("success", "1008", "	收款方有误");
			}
			if (StringUtils.isBlank(partner.getOpeningBankName())) {
				return Utils.getJsonResult("success", "1009", "开户行名称有误");
			}
			if (StringUtils.isBlank(partner.getBankAccount())) {
				return Utils.getJsonResult("success", "1010", "银行账号有误");
			}
			User user = new User();
			user.setId(partner.getDevId());
			user.setPassword(MD5.GetMD5Code(partner.getDevSecret()));
			user.setIsAdmin(0);
			User u = userService.getById(user.getId());
			if (u != null) {
				return Utils.getJsonResult("success", "1002", "此号码已注册");
			}
			partner.setDevId(null);
			partner.setDevSecret(null);
			partner.setRole(1);
			int resul = userPartnerService.addUserPartner(user, partner);
			if (resul == 1) {
				return Utils.getJsonResult("success", "1000", "创建承销商成功");
			}

		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@AuthPassport
	@RequestMapping("/underwriterDetail")
	public String underwriterDetail(ModelMap modelMap,
			@RequestParam(value = "id", required = false, defaultValue = "") String id,
			@RequestParam(value = "userId", required = false, defaultValue = "") String userId,
			@RequestParam(value = "count", required = false, defaultValue = "") String count,
			@RequestParam(value = "cost", required = false, defaultValue = "") String cost,
			@RequestParam(value = "balance", required = false, defaultValue = "") String balance) {
		Partner record = null;
		BizQuery pageInfo = new BizQuery();
		if (!StringUtils.isBlank(id) || Utils.isInt(id)) {
			pageInfo.setId(Integer.valueOf(id));
			if (!StringUtils.isBlank(userId) || Utils.isInt(userId))
				pageInfo.setUserId(userId);
			if (!StringUtils.isBlank(count) || Utils.isInt(count))
				pageInfo.setCount(Integer.valueOf(count));
			if (!StringUtils.isBlank(balance) || Utils.isInt(balance))
				pageInfo.setBalance(Integer.valueOf(balance));
			if (!StringUtils.isBlank(cost) || Utils.isInt(cost))
				pageInfo.setCost(Integer.valueOf(cost));
			record = partnerService.getById(Integer.valueOf(id));
		}
		modelMap.addAttribute("partner", record);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/manager/underwriterDetail";
	}

	@AuthPassport
	@RequestMapping("/underwriterEdit")
	public String underwriterEdit(ModelMap modelMap,
			@RequestParam(value = "id", required = false, defaultValue = "") String id,
			@RequestParam(value = "userId", required = false, defaultValue = "") String userId) {
		modelMap.addAttribute("id", id);
		Partner record = null;
		BizQuery pageInfo = new BizQuery();
		if (!StringUtils.isBlank(id) || Utils.isInt(id)) {
			pageInfo.setId(Integer.valueOf(id));
			if (!StringUtils.isBlank(userId) || Utils.isInt(userId))
				pageInfo.setUserId(userId);
			record = partnerService.getById(Integer.valueOf(id));
		}
		modelMap.addAttribute("partner", record);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/manager/underwriterEdit";
	}

	@AuthPassport
	@RequestMapping("/underwriterDoEdit")
	@ResponseBody
	public String underwriterDoEdit(String id, String name, String rate) {
		try {
			if (StringUtils.isBlank(id) || !Utils.isInt(id)) {
				return Utils.getJsonResult("success", "1001", "承销商Id输入有误");
			}
			if (StringUtils.isBlank(name)) {
				return Utils.getJsonResult("success", "1002", "承销商名称输入有误");
			}
			if (StringUtils.isBlank(rate) || !Utils.isInt(rate)) {
				return Utils.getJsonResult("success", "1003", "承销商分成占比输入有误");
			}
			Partner record = partnerService.getById(Integer.valueOf(id));
			record.setCompany(name);
			record.setShareRate(Integer.valueOf(rate));
			int resul = partnerService.update(record);
			if (resul == 1) {
				return Utils.getJsonResult("success", "1000", "承销商信息修改成功");
			}

		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@AuthPassport
	@RequestMapping("/underwriterGetcash")
	public String underwriterGetcash(ModelMap modelMap,
			@RequestParam(value = "id", required = false, defaultValue = "") String id,
			@RequestParam(value = "cost", required = false, defaultValue = "") String cost,
			@RequestParam(value = "balance", required = false, defaultValue = "") String balance) {
		Partner record = null;
		BizQuery pageInfo = new BizQuery();
		if (!StringUtils.isBlank(id) && Utils.isInt(id)) {
			pageInfo.setId(Integer.valueOf(id));
			if (!StringUtils.isBlank(balance) && Utils.isInt(balance))
				pageInfo.setBalance(Integer.valueOf(balance));
			if (!StringUtils.isBlank(cost) && Utils.isInt(cost))
				pageInfo.setCost(Integer.valueOf(cost));
			record = partnerService.getById(Integer.valueOf(id));
		}
		modelMap.addAttribute("partner", record);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/manager/underwriterGetcash";
	}

	@AuthPassport
	@RequestMapping("/underwriterDoGetcash")
	@ResponseBody
	public String underwriterDoGetcash(String id, String source, String cost) {
		try {
			if (StringUtils.isBlank(id) || !Utils.isInt(id)) {
				return Utils.getJsonResult("success", "1001", "承销商Id输入有误");
			}
			if (StringUtils.isBlank(source)) {
				return Utils.getJsonResult("success", "1002", "流水号输入有误");
			}
			Partner partner = partnerService.getById(Integer.valueOf(id));
			Fund record = new Fund();
			record.setPartnerId(partner.getId());
			record.setSource(source);
			if (!StringUtils.isBlank(cost) && Utils.isInt(cost)) {
				record.setCreditAmount(Integer.valueOf(cost));
			}
			record.setBankName(partner.getBankName());
			record.setOpeningBankName(partner.getOpeningBankName());
			record.setPayee(partner.getPayee());
			record.setBankAccount(partner.getBankAccount());
			int resul = fundService.insert(record);
			if (resul == 1) {
				return Utils.getJsonResult("success", "1000", "提现成功");
			}
		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@AuthPassport
	@RequestMapping("/underwriterGetcashdetail")
	public String underwriterGetcashdetail(ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "id", required = false, defaultValue = "") String id) {
		Query pageInfo = new Query();
		List<Query> queryInfos = null;
		if (!StringUtils.isBlank(id) && Utils.isInt(id)) {
			pageInfo.setId(Integer.valueOf(id));
			pageInfo.setPage(page);
			int num = fundService.getFundsCashNumByManagerUnderwriter(pageInfo);
			pageInfo.setNum(num);
			queryInfos = fundService.getFundsCashByManagerUnderwriter(pageInfo);
		}
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		return "/manager/underwriterGetcashdetail";
	}

	@AuthPassport
	@RequestMapping("/underwriterGetcashMore")
	public String underwriterGetcashMore(ModelMap modelMap,
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
		return "/manager/underwriterGetcashDetailMore";
	}

	@AuthPassport
	@RequestMapping("/underwriterManage")
	public String underwriterManage(ModelMap modelMap,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "type", required = false, defaultValue = "") String type,
			@RequestParam(value = "user", required = false, defaultValue = "") String user,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		Integer id = null;
		String appId = null;
		BizQuery pageInfo = new BizQuery();
		pageInfo.setAppId(appId);
		pageInfo.setId(id);
		pageInfo.setPage(page);
		if (!StringUtils.isBlank(user))
			pageInfo.setUserId(user);
		if (!StringUtils.isBlank(name))
			pageInfo.setName(name);

		pageInfo.setType("2");
		int type_num = fundService.getFundsNumByManagerUnderwriter(pageInfo);

		if (!StringUtils.isBlank(type))
			pageInfo.setType(type);
		else
			pageInfo.setType(null);

		int num = fundService.getFundsNumByManagerUnderwriter(pageInfo);
		pageInfo.setNum(num);
		List<BizQuery> queryInfos = fundService.getFundsByManagerUnderwriter(pageInfo);

		Fund fund = fundService.getFundSumByPartner(id);
		Query statInfo = receiveService.getReceiveCountByApp(appId);

		if (fund == null)
			fund = new Fund();
		if (statInfo == null)
			statInfo = new Query();

		modelMap.addAttribute("fund", fund);
		modelMap.addAttribute("statInfo", statInfo);
		modelMap.addAttribute("statInfo", statInfo);
		modelMap.addAttribute("queryInfos", queryInfos);
		modelMap.addAttribute("pageInfo", pageInfo);
		modelMap.addAttribute("type_num", type_num);
		return "/manager/underwriterManage";
	}
}