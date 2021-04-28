package com.greedy.shortcut.jackson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JacksonController {

	@GetMapping(value="", produces="application/json; charset=UTF-8" )
	@ResponseBody
	public String getMemberListOnResponseBody() {
		
		
		return null;
	}
}
