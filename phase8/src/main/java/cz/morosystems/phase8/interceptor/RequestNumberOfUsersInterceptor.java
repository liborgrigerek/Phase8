package cz.morosystems.phase8.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cz.morosystems.phase8.service.UserManager;

public class RequestNumberOfUsersInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private UserManager userManager;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// ziskej pocet uzivatelu v databazi
		Integer n = userManager.getNUsers();
		modelAndView.addObject("nUsers", n);
	}
}
