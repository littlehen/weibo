package com.nit.weibo.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @Description: SESSION拦截器，用于验证用户身份
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

	private SessionContext sc = SessionContext.getInstance();

	// 拦截前处理
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		int hour = 2;
		//session的有效期
		request.getSession().setMaxInactiveInterval(60 * 60 * hour);/*秒为单位*/  
		String sessionId = request.getParameter("sessionId");
		String userDevice = request.getParameter("userDevice");
		if (null != userDevice) {
			if (null != sessionId) {
				if (userDevice.equals(ProjectConstants.DeviceType_Web)) {
					HttpSession session = sc.getSession(sessionId);
					if (null == session) {
						response.getWriter().print(ProjectConstants.SessionCheck_TimeOut);
					} else {
						return true;
					}
				} else
					response.getWriter().print(ProjectConstants.TokenCheck_TimeOut);
			} else {
				response.getWriter().print(ProjectConstants.LoginError);
			}
		} else {
			response.getWriter().print(ProjectConstants.LoginError);
		}
		return false;
	}

	// 拦截后处理
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav)
			throws Exception {
	}

	// 全部完成后处理
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {
	}
}
