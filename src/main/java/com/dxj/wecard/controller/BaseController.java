package com.dxj.wecard.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.model.User;
import com.dxj.wecard.model.WeixinApp;
import com.dxj.wecard.service.UserService;
import com.dxj.wecard.service.WeixinAppService;

public class BaseController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private WeixinAppService weixinAppService;
	protected HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request;
	}

	protected HttpSession getSession() {
		return getRequest().getSession(true);
	}

	/**
	 * 校验是否登录
	 * 
	 * @return
	 */
	public boolean isLogin() {
		if (getCurrentUserId() == null) {
			return false;
		}
		return true;
	}

	/**
	 * 获取当前用户
	 * 
	 * @param
	 * @return
	 */
	public User getCurrentUser(String userId) {
		if (!StringUtils.isEmpty(userId)) {
			User user = userService.getUserCache(userId);
			if (user != null) {
				return user;
			}
		}
		return null;
	}
	/**
	 * 当前weixin app用户
	 * @param appId
	 * @return
	 * @author liulihai 2015年10月11日 下午4:33:47
	 */
	public WeixinApp getCurrentWeixinApp(){
	    String appId=getCurrentWeixinAppId();
	    if (!StringUtils.isEmpty(appId)) {
	        WeixinApp weixinapp = weixinAppService.getById(appId);
            if (weixinapp != null) {
                return weixinapp;
            }
        }
	    return null;
	}
	/**
     * 取得当前登录用户 weixin Id
     * 
     * @return
     */
    public String getCurrentWeixinAppId() {
        HttpServletRequest request = getRequest();
        return (String) request.getSession().getAttribute("appId");
    }
	/**
	 * 获取当前用户
	 * 
	 * @param
	 * @return
	 */
	public User getCurrentUser() {
		return getCurrentUser(getCurrentUserId().toString());
	}

	/**
	 * 取得当前登录用户Id
	 * 
	 * @return
	 */
	public String getCurrentUserId() {
	    HttpServletRequest request = getRequest();
		return (String) request.getAttribute("userId");
	}

	/**
	 * 创建一个简单的成功json串
	 */
	public String createSimpleSuccessJson(String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "Y");
		map.put("message", message);

		return JSON.toJSONString(map).toString();
	}

	/**
	 * 创建一个简单的成失败json串
	 */
	public String createSimpleFailureJson(String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "N");
		map.put("message", message);

		return JSON.toJSONString(map).toString();
	}

	/**
	 * 接口文档返回json串
	 * 
	 * @param resultCode
	 * @param msg
	 * @param obj
	 * @return
	 */
	public String createResultJson(String resultCode, String msg, Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result_code", resultCode);
		map.put("msg", msg);
		if (obj != null) {
			map.put("data", JSON.toJSON(obj));
		}
		return JSON.toJSONString(map);

	}

	/**
	 * json解析成Map
	 * 
	 * @param jsonStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> parseObject(String jsonStr) {

		if (StringUtils.isEmpty(jsonStr)) {
			return null;
		}
		try {
			Map<String, Object> jsonMap = JSON.parseObject(jsonStr, Map.class);
			return jsonMap;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 数组格式转换成 List<Map<String,Object>>
	 * 
	 * @param jsonStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> parseList(String jsonStr) {
		if (StringUtils.isEmpty(jsonStr)) {
			return null;
		}
		try {
			List<Map<String, Object>> list = JSON.parseObject(jsonStr,
					List.class);
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 手机号验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * 用于处理异常的
	 * 
	 * @return
	 */
	@ExceptionHandler({ Exception.class })
	public String exception(Exception e) {
		return "error";
	}

}
