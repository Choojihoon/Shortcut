package com.greedy.shortcut.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage/*")
public class MyPageController {

	@GetMapping("/mypage")
	public void mypage() {}
	
	@GetMapping("/mypage_password")
	public void mypage_password() {}
}
