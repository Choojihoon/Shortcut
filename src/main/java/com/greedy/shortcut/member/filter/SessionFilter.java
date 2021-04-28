package com.greedy.shortcut.member.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.greedy.shortcut.member.model.service.UserDetailsVO;

@Component
public class SessionFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if(SecurityContextHolder.getContext().getAuthentication() != null) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			if(!principal.getClass().getSimpleName().equals("String")) {
				HttpServletRequest req = (HttpServletRequest) request;
				
				HttpSession session = req.getSession();
				
				UserDetailsVO user = (UserDetailsVO) principal;
				
				Object isUser = session.getAttribute("user");
				
				if(isUser == null) {
					req.getSession().setAttribute("user", user);
				} else {
					UserDetailsVO oldUser = (UserDetailsVO) isUser;
					if(oldUser.getAuthorities() != user.getAuthorities()) {
						req.getSession().setAttribute("user", user);
					}
				}
			}
		}
		
		chain.doFilter(request, response);
	}

}
