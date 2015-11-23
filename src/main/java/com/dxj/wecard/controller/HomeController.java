package com.dxj.wecard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.bean.order.BodyReq;
import com.dxj.wecard.bean.order.DataOrderRsp;
import com.dxj.wecard.bean.order.DataQueryRsp;
import com.dxj.wecard.bean.order.HeadReq;
import com.dxj.wecard.bean.order.OrderReq;
import com.dxj.wecard.bean.order.OrderRsp;
import com.dxj.wecard.bean.order.QueryReq;
import com.dxj.wecard.bean.order.QueryRsp;
import com.dxj.wecard.model.Channel;
import com.dxj.wecard.model.User;
import com.dxj.wecard.service.CardService;
import com.dxj.wecard.service.ChannelService;
import com.dxj.wecard.service.UserService;
import com.dxj.wecard.util.MD5;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {

	static final Logger logger = LogManager.getLogger(HomeController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ChannelService channelService;

	@Autowired
	private CardService cardService;

	@RequestMapping("/login")
	public String login(ModelMap modelMap) {
		return "/login";
	}

	@RequestMapping("/register")
	public String register(ModelMap modelMap) {
		return "/register";
	}

	@RequestMapping("/registerSuccess")
	public String registerSuccess(ModelMap modelMap) {
		return "/registerSuccess";
	}

	@RequestMapping("/forget")
	public String forget(ModelMap modelMap) {
		return "/forget";
	}

	@ResponseBody
	@RequestMapping("/order")
	public String order(HttpServletRequest request, @RequestBody OrderReq order) {
		OrderRsp rsp = new OrderRsp();
		if (order == null)
			rsp.setCode("9999");
		else {
			HeadReq head = order.getHead();
			String code = verifyUser(request, head);
			rsp.setCode(code);
			if (code.equals("0000")) {
				BodyReq body = order.getBody();
				Channel channel = channelService.getByUserCardId(head.getEcid(), body.getCardid());
				if (channel == null)
					channelService.insert(channel);
				DataOrderRsp data = new DataOrderRsp();
				data.setCardid(body.getCardid());
				data.setOuterid("" + channel.getId());
				rsp.setData(data);
			}
		}
		return JSON.toJSONString(rsp);
	}

	@ResponseBody
	@RequestMapping("/query")
	public String query(HttpServletRequest request, @RequestBody QueryReq query) {
		QueryRsp rsp = new QueryRsp();
		if (query == null)
			rsp.setCode("9999");
		else {
			HeadReq head = query.getHead();
			String code = verifyUser(request, head);
			rsp.setCode(code);
			if (code.equals("0000")) {
				List<DataQueryRsp> data = cardService.getCardsByChannelQuery();
				rsp.setData(data);
			}
		}
		return JSON.toJSONString(rsp);
	}

	private String verifyUser(HttpServletRequest request, HeadReq head) {
		try {
			if (head == null)
				return "9999";
			String id = head.getEcid();
			User user = userService.getById(id);
			if (user == null)
				return "0001";
			String pw = head.getPw();
			if (!MD5.GetMD5Code(pw).equals(user.getPassword()))
				return "0003";
			String ip = getIpAddress(request);
			if (!ip.equals(user.getIp()))
				return "0002";
		} catch (Exception e) {
			return "9999";
		}
		return "0000";
	}

	private String getIpAddress(HttpServletRequest request) throws IOException {
		// 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

		String ip = request.getHeader("X-Forwarded-For");
		if (logger.isInfoEnabled()) {
			logger.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
				if (logger.isInfoEnabled()) {
					logger.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
				}
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
				if (logger.isInfoEnabled()) {
					logger.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
				}
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
				if (logger.isInfoEnabled()) {
					logger.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
				}
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
				if (logger.isInfoEnabled()) {
					logger.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
				}
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
				if (logger.isInfoEnabled()) {
					logger.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
				}
			}
		} else if (ip.length() > 15) {
			String[] ips = ip.split(",");
			for (int index = 0; index < ips.length; index++) {
				String strIp = (String) ips[index];
				if (!("unknown".equalsIgnoreCase(strIp))) {
					ip = strIp;
					break;
				}
			}
		}
		return ip;
	}
}