package com.greedy.shortcut.messenger.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greedy.shortcut.member.model.dto.MemberDTO;
import com.greedy.shortcut.messenger.model.dto.MessengerDTO;
import com.greedy.shortcut.messenger.model.dto.PmDTO;
import com.greedy.shortcut.messenger.model.sevice.MsgService;

@Controller
@RequestMapping("/messenger/*")
public class MessengerController<PjtMemDTO> {
	
	private final MsgService msgService;
	
	@Autowired
	public MessengerController(MsgService msgService) {
		this.msgService = msgService;
	}

//	@GetMapping("messenger")
//	public void messenger() {}
	
	@PostMapping(value="member", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String selectMember(HttpServletRequest request) throws JsonProcessingException {
		int userNo =  Integer.parseInt(request.getParameter("userNo"));
		System.out.println("userNo :  " + userNo );
		List<MemberDTO> memberList = msgService.selectMember(userNo);
		System.out.println("memberList :  " + memberList );
		return new ObjectMapper().writeValueAsString(memberList);
	}
}
