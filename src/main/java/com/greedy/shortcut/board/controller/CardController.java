package com.greedy.shortcut.board.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greedy.shortcut.board.model.dto.BoardDTO;
import com.greedy.shortcut.board.model.dto.CardAttendListDTO;
import com.greedy.shortcut.board.model.dto.CardScheduleDTO;
import com.greedy.shortcut.board.model.dto.CardTaskDTO;
import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.RequestCardDTO;
import com.greedy.shortcut.board.model.service.CardService;

@Controller
@RequestMapping("/*")
public class CardController {

	private final CardService cardService;

	@Autowired
	public CardController(CardService cardService) {
		this.cardService = cardService;
	}

	@RequestMapping(value = "/card/cardmember", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<ProjectAuthorityDTO> selectMember(@ModelAttribute ProjectAuthorityDTO pAuth,
			HttpServletRequest request) {

		int pjtNo = Integer.parseInt(request.getParameter("pjtNo"));
		System.out.println("pjtNo : " + pjtNo);

		List<ProjectAuthorityDTO> memberList = cardService.selectMember(pjtNo);
		System.out.println("memberList!!!!!!!! : " + memberList);

		return memberList;
	}

	@PostMapping("/card/create")
	public String registCard(@ModelAttribute RequestCardDTO card, HttpServletRequest request, 
			@RequestParam(name="sprNo") int sprNo ,@RequestParam(name="pjtNo") int
			pjtNo ,@RequestParam(name="projectName") String projectName
			,RedirectAttributes redirect,RedirectAttributes rttr, Model model) {
		CardScheduleDTO crd_sch = new CardScheduleDTO();
		CardTaskDTO crd_task = new CardTaskDTO();
		
		System.out.println("card!!!!!!!!!!!!!! : " + card);
		
		Enumeration eParam = request.getParameterNames();
		 
		 while (eParam.hasMoreElements()) {
		        String pName = (String)eParam.nextElement();
		        String pValue = request.getParameter(pName);

		        System.out.println(pName + " : " + pValue + "<br>");
		 }
		 
		 String schA = card.getScheduleStartDate().replace("T", "").replace("-", "").replace(":", "");
		 String schB = card.getScheduleEndDate().replace("T", "").replace("-", "").replace(":", "");
		 String schC = card.getTaskStartDate().replace("T", "").replace("-", "").replace(":", "");
		 String schD = card.getTaskEndDate().replace("T", "").replace("-", "").replace(":", "");
		 card.setScheduleEndDate(schB);
		 card.setScheduleStartDate(schA);
		 card.setTaskStartDate(schC);
		 card.setTaskEndDate(schD);
		
		System.out.println("card: " + card);
		
		if (!cardService.registCard(card)) {
			System.out.println(card);
		}

		
		rttr.addFlashAttribute("message", "카드 등록에 성공하셨습니다.");

		return "redirect:/board/kanbanboard/?pjtNo="+pjtNo+"&sprNo="+sprNo+"&projectName="+
		 projectName;
		
	}
	
	@GetMapping(value = "/select/cardInfo", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String selectCardInfo(@RequestParam Map<String, String> parameters, HttpServletRequest request, Model model) throws JsonProcessingException {
		
		int cardNo = Integer.parseInt(request.getParameter("crdNo"));
		System.out.println("cardNo 무야호: " + cardNo);
		
		List<RequestCardDTO> selectCardInfo = cardService.selectCardInfo(cardNo);
		
		RequestCardDTO selectOneCardInfo = null;
		if(selectCardInfo.size() != 0) {
			
			selectOneCardInfo = selectCardInfo.get(0);
			System.out.println("selectCardInfo : " + selectOneCardInfo);
			model.addAttribute("selectCardInfo", selectOneCardInfo);
		}
		return new ObjectMapper().writeValueAsString(selectOneCardInfo);
		
		
	}
	
	@RequestMapping(value = "/card/member", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<CardAttendListDTO> selectCardMember(@ModelAttribute CardAttendListDTO pAuth,
			HttpServletRequest request) {

		int crdNo = Integer.parseInt(request.getParameter("crdNo"));
		System.out.println("crdNo : " + crdNo);

		List<CardAttendListDTO> memberList = cardService.selectCardMember(crdNo);
		System.out.println("memberList : " + memberList);

		return memberList;
	}
	
	@PostMapping("/card/modifyCard")
	public String modifyCard(@ModelAttribute RequestCardDTO card, 
			@RequestParam(name="sprNo") int sprNo ,@RequestParam(name="pjtNo") int
			pjtNo ,@RequestParam(name="projectName") String projectName
			,RedirectAttributes redirect, Model model) {
		
		String schA = card.getScheduleStartDate().replace("T", "").replace("-", "").replace(":", "");
		String schB = card.getScheduleEndDate().replace("T", "").replace("-", "").replace(":", "");
		String schC = card.getTaskStartDate().replace("T", "").replace("-", "").replace(":", "");
		String schD = card.getTaskEndDate().replace("T", "").replace("-", "").replace(":", "");
		card.setScheduleEndDate(schB);
		card.setScheduleStartDate(schA);
		card.setTaskStartDate(schC);
		card.setTaskEndDate(schD);
				
		if (!cardService.modifyCard(card)) {
			System.out.println(card);
					
		}
		
		return "redirect:/board/kanbanboard/?pjtNo="+pjtNo+"&sprNo="+sprNo+"&projectName="+
		 projectName;
	}
	
	@PostMapping("/card/deleteCard")
	public String deleteCard(@ModelAttribute RequestCardDTO card, 
			@RequestParam(name="sprNo") int sprNo ,@RequestParam(name="pjtNo") int
			pjtNo ,@RequestParam(name="projectName") String projectName
			,RedirectAttributes redirect, Model model) {
		
		if (!cardService.deleteCard(card)) {
			System.out.println(card);
					
		}
		
		return "redirect:/board/kanbanboard/?pjtNo="+pjtNo+"&sprNo="+sprNo+"&projectName="+
		 projectName;
	}
	
}
