package com.greedy.shortcut.board.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/board/backlog/*")
public class ReviewController {

	@PostMapping(value="/reviewPaging", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String pagingAjax(/* @RequestParam Map<String, String> parameters */) throws JsonProcessingException {
//		System.out.println("d");
//		int abc = Integer.parseInt(parameters.get("abc"));
//		System.out.println("abc : " + abc);
		
		String a = "a";
		
		return new ObjectMapper().writeValueAsString(a);
	}
	
	@GetMapping(value="/please", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String pleaseTest(@RequestParam Map<String, String> parameters) throws JsonProcessingException {
		System.out.println("success");
		
		String one = (String) parameters.get("one");
		String two = (String) parameters.get("two");
		String pjtNo = (String) parameters.get("pjtNo");
		
		int oneInt = Integer.parseInt(one);
		
		System.out.println("one : " + one);
		System.out.println("oneInt : " + oneInt);
		System.out.println("two : " + two);
		System.out.println("pjtNo : " + pjtNo);
		
		return new ObjectMapper().writeValueAsString(one);
	}
}
