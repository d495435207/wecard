package com.dxj.wecard.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dxj.wecard.util.Utils;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);

			// 没有声明需要权限,或者声明不验证权限
			if (authPassport == null || authPassport.validate() == false)
				return true;
			else {
				// 在这里实现自己的权限验证逻辑
				boolean isPermit = false;
				try {
					HttpSession session = request.getSession();
					String userId = (String) session.getAttribute("userId");
					if (!StringUtils.isBlank(userId)) {
						String url = request.getRequestURI();
						Integer isAdmin = (Integer) session.getAttribute("isAdmin");
						if (isAdmin == 1) {// 管理员
							if (Utils.isPermitUrl(url, "manager"))
								isPermit = true;
						} else if (isAdmin == 0) {// 非管理员
							Integer role = (Integer) session.getAttribute("role");
							if (role == 1) {// 承销商
								if (Utils.isPermitUrl(url, "underwriter"))
									isPermit = true;
							} else if (role == 0) {// 发行商
								if (Utils.isPermitUrl(url, "publisher"))
									isPermit = true;
							}
						}
					}
				} catch (Exception e) {
				}
				if (isPermit) // 如果验证成功返回true
					return true;
				else// 如果验证失败
				{
					// 返回到登录界面
					String path = request.getContextPath();
					response.sendRedirect(path + "/login.do");
					return false;
				}
			}
		} else
			return true;
	}
}