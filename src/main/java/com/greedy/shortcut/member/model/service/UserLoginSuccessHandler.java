package com.greedy.shortcut.member.model.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Service;

import com.greedy.shortcut.member.model.dao.MemberMapper;
import com.greedy.shortcut.member.model.dto.MemberDTO;

@Service("userLoginSuccessHandler")
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		WebAuthenticationDetails web = (WebAuthenticationDetails) authentication.getDetails();
//		System.out.println("IP : " + web.getRemoteAddress());
//		System.out.println("Session ID : " + web.getSessionId());
		
		// 인증 ID
//		System.out.println("name : " + authentication.getName());
		
		// 권한 리스트
		List<GrantedAuthority> authList = (List<GrantedAuthority>) authentication.getAuthorities();
//		System.out.print("권한 : ");
		for(int i = 0; i< authList.size(); i++) {
//			System.out.print(authList.get(i).getAuthority() + " ");
		}
//		System.out.println();
		
		// 방문자 카운트 증가
		// 필요한 로직 작성
		// ...
		
		
		// 디폴트 URI
		String uri = "/shortcut";

		/* 강제 인터셉트 당했을 경우의 데이터 get */
		RequestCache requestCache = new HttpSessionRequestCache();
		SavedRequest savedRequest = requestCache.getRequest(request, response);
//		System.out.println("save:" + savedRequest);
		
		/* 로그인 버튼 눌러 접속했을 경우의 데이터 get */
		String prevPage = (String) request.getSession().getAttribute("prevPage");
		if (prevPage != null) {
			request.getSession().removeAttribute("prevPage");
		}
		
//		System.out.println(prevPage);
		// null이 아니라면 강제 인터셉트 당했다는 것
		if (savedRequest != null) {
			uri = savedRequest.getRedirectUrl();

		// ""가 아니라면 직접 로그인 페이지로 접속한 것
		} else if (prevPage != null && !prevPage.equals("")) {
			uri = prevPage;
		}
		
//		if(SecurityContextHolder.getContext().getAuthentication() != null) {
//			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//			
//			if(!principal.getClass().getSimpleName().equals("String")) {
//				HttpServletRequest req = (HttpServletRequest) request;
//				
//				HttpSession session = req.getSession();
//				
//				UserDetailsVO user = (UserDetailsVO) principal;
//				
//				Object isUser = session.getAttribute("user");
//				
//				MemberDTO userInfo = mapper.selectUserInfoOne(user.getName());
//				
//				if(isUser == null) {
//					req.getSession().setAttribute("user", user);
//				} else {
//					UserDetailsVO oldUser = (UserDetailsVO) isUser;
//					if(oldUser.getAuthorities() != user.getAuthorities()) {
//						req.getSession().setAttribute("user", user);
//						req.getSession().setAttribute("userInfo", userInfo);
//					}
//				}
//			}
//		}
		

		// 세 가지 케이스에 따른 URI 주소로 리다이렉트
		response.sendRedirect(uri);
	}
}