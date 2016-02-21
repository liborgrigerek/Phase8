package cz.morosystems.phase8.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cz.morosystems.phase8.service.UserManager;

public class RequestGetUsernameInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// ziskej prihlaseneho uzivatele
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = (auth != null && !auth.getName().contains("anonymous")) ? auth.getName() : "Not logged in."; //get logged in username
		modelAndView.addObject("username", username);
	}
}
