package com.greedy.shortcut.member.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.shortcut.member.model.dto.MemberDTO;
import com.greedy.shortcut.member.model.service.MemberService;

@Controller
@RequestMapping("/*")
public class MemberController {
	
	private final MemberService memberService;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberController(MemberService memberService, BCryptPasswordEncoder passwordEncoder) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
	}

	
	@PostMapping("/regist")
	public String registMember(@ModelAttribute MemberDTO member, HttpServletRequest request, RedirectAttributes rttr)  {
		
		System.out.println(member);
		if(!memberService.registMember(member)) {
			
		}
		
		rttr.addFlashAttribute("message", "회원 가입에 성공하셨습니다.");
		
		return "redirect:/";
		
	}
	
	/* 로그인 화면 요청 */
	@RequestMapping("/")
	public String loginView(HttpServletRequest request) {

		// 요청 시점의 사용자 URI 정보를 Session의 Attribute에 담아서 전달(잘 지워줘야 함)
		// 로그인이 틀려서 다시 하면 요청 시점의 URI가 로그인 페이지가 되므로 조건문 설정
		String uri = request.getHeader("Referer");
		System.out.println("uri : " + uri);
		if (!uri.contains("/")) {
			request.getSession().setAttribute("prevPage",
					request.getHeader("Referer"));
		}

		return "/main/main";
	}
	
	@RequestMapping("/update")
	public String ModifyMember(HttpSession httpsession, RedirectAttributes rttr, MemberDTO memberDTO) throws Exception {
		memberService.ModifyMember(memberDTO);
		httpsession.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping("changePassword")
	public String memberUpdate(@ModelAttribute MemberDTO dto, Model model, HttpSession httpsession) {
		
			memberService.updateMember(dto);
			httpsession.invalidate();
			return "redirect:/";
	}
}
	


















