package com.greedy.shortcut.member.model.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.greedy.shortcut.member.model.dao.MemberMapper;
import com.greedy.shortcut.member.model.dto.MemberDTO;

@Service("userLoginService")
public class UserDetailsServiceCustom implements UserDetailsService {
	
	private HttpServletRequest request;
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String inputUserId) {
		
		// 최종적으로 리턴해야할 객체
		UserDetailsVO userDetails = new UserDetailsVO();
		
		// 사용자 정보 select
		MemberDTO userInfo = mapper.selectUserInfoOne(inputUserId);
//		System.out.println("userInfo : " + userInfo);
		
		/* loginMember(request, userInfo); */
		
		// 사용자 정보 없으면 null 처리
		if(userInfo == null) {
			return null;
			
		// 사용자 정보 있을 경우 로직 전개(userDetails에 데이터 넣기)	
		} else {
			
			
			userDetails.setUsername(userInfo.getEmail());
			userDetails.setPassword(userInfo.getPassword());
			userDetails.setName(userInfo.getName());
			userDetails.setNo(userInfo.getNo());
			userDetails.setGitUrl(userInfo.getGitUrl());
			System.out.println("name : " + userInfo.getName());
			System.out.println("email : " + userInfo.getEmail());
			System.out.println("gitUrl : " + userInfo.getGitUrl());
//			System.out.println("password : " + userInfo.getPassword());
			// 사용자 권한 select해서 받아온 List<String> 객체 주입
//			userDetails.setAuthorities(mapper.selectUserAuthOne(inputUserId));
		}
		
		
		return userDetails;
	}
	
//	public void loginMember(HttpServletRequest request, MemberDTO loginMember) {
//		HttpSession session = request.getSession();
//		session.setAttribute("loginMember", loginMember);
//		System.out.println(loginMember);
//	}

	
}
