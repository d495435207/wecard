package com.dxj.wecard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxj.wecard.model.Partner;
import com.dxj.wecard.model.User;
import com.dxj.wecard.model.WeixinApp;
import com.dxj.wecard.service.CaptchaService;
import com.dxj.wecard.service.UserPartnerService;
import com.dxj.wecard.service.UserService;
import com.dxj.wecard.service.WeixinAppService;
import com.dxj.wecard.util.MD5;
import com.dxj.wecard.util.Utils;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private CaptchaService captchaService;

	@Autowired
	private UserPartnerService userPartnerService;

	@Autowired
	private WeixinAppService weixinAppService;

	@ResponseBody
	@RequestMapping("/forgetPassword")
	public String forgetPassword(HttpServletRequest request, String password) {
		if (StringUtils.isBlank(password)) {
			return Utils.getJsonResult("success", "1003", "密码不能为空");
		}
		if (StringUtils.length(password) < 6 || StringUtils.length(password) > 32) {
			return Utils.getJsonResult("success", "1004", "密码长度有误");
		}
		try {
			HttpSession session = request.getSession();
			String userId = (String) session.getAttribute("userId");
			if (!StringUtils.isBlank(userId)) {
				User user = userService.getById(userId);
				if (user == null) {
					return Utils.getJsonResult("success", "1002", "此号码尚未注册");
				}
				user.setPassword(MD5.GetMD5Code(password));
				int result = userService.update(user);
				if (result == 1)
					return Utils.getJsonResult("success", "1000", "密码修改成功");
			}
		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@ResponseBody
	@RequestMapping("/modifyPassword")
	public String modifyPassword(HttpServletRequest request, String password, String oldPassword) {
		if (StringUtils.isBlank(password)) {
			return Utils.getJsonResult("success", "1003", "密码不能为空");
		}
		if (StringUtils.length(password) < 6 || StringUtils.length(password) > 32) {
			return Utils.getJsonResult("success", "1004", "密码长度有误");
		}
		if (StringUtils.isBlank(oldPassword)) {
			return Utils.getJsonResult("success", "1013", "密码不能为空");
		}
		if (StringUtils.length(oldPassword) < 6 || StringUtils.length(oldPassword) > 32) {
			return Utils.getJsonResult("success", "1014", "密码长度有误");
		}
		try {
			HttpSession session = request.getSession();
			String userId = (String) session.getAttribute("userId");
			if (!StringUtils.isBlank(userId)) {
				User user = userService.getById(userId);
				if (user == null) {
					return Utils.getJsonResult("success", "1002", "此号码尚未注册");
				}
				if (!MD5.GetMD5Code(oldPassword).equals(user.getPassword())) {
					return Utils.getJsonResult("success", "1015", "原密码不正确");
				}
				user.setPassword(MD5.GetMD5Code(password));
				int result = userService.update(user);
				if (result == 1)
					return Utils.getJsonResult("success", "1000", "密码修改成功");
			}
		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@RequestMapping("/getCode")
	@ResponseBody
	public String getCode(String phone) {
		if (StringUtils.isBlank(phone) || !Utils.isPhone(phone)) {
			return Utils.getJsonResult("success", "1001", "手机号有误");
		}
		String time = captchaService.getIsSendCache(phone);
		if (!StringUtils.isBlank(time)) {
			return Utils.getJsonResult("success", "1002", "验证码已发送，请不要频繁获取");
		}
		String content = "";
		String verifyCode = Utils.verifyCode();
		content = "验证码：" + verifyCode + "，如非本人操作请忽略";
		try {
			int result = captchaService.sendCaptcha(content, phone);
			if (result == 1) {
				captchaService.putCaptchaCache(phone, verifyCode);
				captchaService.putIsSendCache(phone);
				return Utils.getJsonResult("success", "1000", "发送验证码成功");
			}
		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "发送验证码失败,请联系管理员");
	}

	@RequestMapping("/isRegist")
	@ResponseBody
	public String isRegist(String phone) {
		if (StringUtils.isBlank(phone) || !Utils.isPhone(phone)) {
			return Utils.getJsonResult("success", "1001", "手机号有误");
		}
		try {
			User user = userService.getById(phone);
			if (user == null) {
				return Utils.getJsonResult("success", "1000", "此号码尚未注册");
			} else {
				return Utils.getJsonResult("success", "1002", "此号码已注册");
			}
		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@RequestMapping("/forget")
	@ResponseBody
	public String forget(HttpServletRequest request, String phone, String security) {
		if (StringUtils.isBlank(phone) || !Utils.isPhone(phone)) {
			return Utils.getJsonResult("success", "1001", "手机号有误");
		}
		if (StringUtils.isBlank(security)) {
			return Utils.getJsonResult("success", "1005", "验证码不能为空");
		}
		try {
			String verifyCode = captchaService.getCaptchaCache(phone);
			if (verifyCode == null) {
				return Utils.getJsonResult("success", "1006", "验证码未获取/已失效，请点击获取");
			}
			if (!verifyCode.equals(security)) {
				return Utils.getJsonResult("success", "1007", "验证码不正确");
			}
			User user = userService.getById(phone);
			if (user == null) {
				return Utils.getJsonResult("success", "1002", "此号码尚未注册");
			}
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			return Utils.getJsonResult("success", "1000", "验证用户成功");
		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@RequestMapping("/register")
	@ResponseBody
	public String register(String phone, String password, String security) {
		if (StringUtils.isBlank(phone) || !Utils.isPhone(phone)) {
			return Utils.getJsonResult("success", "1001", "手机号有误");
		}
		if (StringUtils.isBlank(password)) {
			return Utils.getJsonResult("success", "1003", "密码不能为空");
		}
		if (StringUtils.length(password) < 6 || StringUtils.length(password) > 32) {
			return Utils.getJsonResult("success", "1004", "密码长度有误");
		}
		if (StringUtils.isBlank(security)) {
			return Utils.getJsonResult("success", "1005", "验证码不能为空");
		}
		try {
			String verifyCode = captchaService.getCaptchaCache(phone);
			if (verifyCode == null) {
				return Utils.getJsonResult("success", "1006", "验证码未获取/已失效，请点击获取");
			}
			if (!verifyCode.equals(security)) {
				return Utils.getJsonResult("success", "1007", "验证码不正确");
			}
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
				return Utils.getJsonResult("success", "1000", "注册用户成功");
			}

		} catch (Exception e) {
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request, String phone, String password) {
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
			if (user == null) {
				return Utils.getJsonResult("success", "1002", "该手机号码尚未注册");
			}
			if (!MD5.GetMD5Code(password).equals(user.getPassword())) {
				return Utils.getJsonResult("success", "1005", "密码不正确");
			}
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("isAdmin", user.getIsAdmin());
			if (user.getIsAdmin() == 1) {
				// 管理员
				return Utils.getJsonResult("success", "1000", "用户登录成功", "manager/index.do");
			} else if (user.getIsAdmin() == 0) {
				Partner partner = userPartnerService.getPartnerByUser(phone);
				if (partner == null) {
					partner = new Partner();
					partner.setRole(0);
					userPartnerService.addPartner(user, partner);
				}
				//请问这一步是干什么的？？为什么要new一个partner？？
				
				
				session.setAttribute("partnerId", partner.getId());
				session.setAttribute("role", partner.getRole());
				if (partner.getRole() == 1) {
					// 卡劵承销商
					return Utils.getJsonResult("success", "1000", "用户登录成功", "underwriter/index.do");
				} else if (partner.getRole() == 0) {
					// 为卡劵发行商
					WeixinApp weixinApp = weixinAppService.getWeixinByPartner(partner.getId());
					if (weixinApp != null){
					    session.setAttribute("appId", weixinApp.getId());
					    session.setAttribute("isAuth", weixinApp.getIsAuth());
					}
					return Utils.getJsonResult("success", "1000", "用户登录成功", "publisher/index.do");
				}
			}
		} catch (Exception e) {
		    logger.error(e);
		}
		return Utils.getJsonResult("fail", "0000", "系统内部错误");
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("userId");
		} catch (Exception e) {
		}
		return "redirect:/login.do";
	}
}