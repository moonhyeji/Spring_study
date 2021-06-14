package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class); 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[Interceptor] :preHandle");
		
		if(request.getRequestURI().contains("/loginform.do")||
		   request.getRequestURI().contains("/ajaxlogin.do")||
		   request.getSession().getAttribute("login") != null ||
		   request.getRequestURI().contains("/test.do")
		   ) {
			return true;  //트루면 보내줌
		
		}
		//spring 3.2이상부터는 servlet-context.xmldptj  <exclude-mapping-path>를 통해 설정 가능!
		//localhost:8989/upgrade/list.do 를 주소창에 치면 바로 loginform.do 로 넘어가서 (다른 컨트롤러로 가서) 로그인 하라고 하게 할 수 있음.!
		if(request.getSession().getAttribute("login") == null) {
			response.sendRedirect("loginform.do");
		}
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("[Interceptor] :postHandle");
		
		if(modelAndView != null) {
			logger.info("Target View :" + modelAndView.getViewName());
		}
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("[Interceptor] :afterCompletions");
	}

}
