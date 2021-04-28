package com.greedy.shortcut.mywork.controller;

import java.security.Principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greedy.shortcut.common.paging.PageInfoDTO;
import com.greedy.shortcut.common.paging.Pagenation;
import com.greedy.shortcut.member.model.dto.MemberDTO;
import com.greedy.shortcut.mywork.model.dto.MyworkResponseCardAndScheduleDTO;
import com.greedy.shortcut.mywork.model.dto.MyworkResponseCardAndTaskDTO;
import com.greedy.shortcut.mywork.model.service.MyworkService;
import static com.greedy.shortcut.common.paging.Pagenation.getPageInfo;
@Controller
@RequestMapping("/*")
public class MyworkController {
	private MyworkService myworkService;
	
	@Autowired
	public MyworkController(MyworkService myworkService) {
		this.myworkService = myworkService;
	}
	
	
	@GetMapping("mywork/mywork")
	public String Mywork(Principal principal, Model model) {
		
		System.out.println("메소드 진입 ");
		
		String userName = principal.getName();
		System.out.println("userName: " + userName);
		
		/* 회원 정보 조회 */
		MemberDTO member = myworkService.selectUserInfoOne(userName);
		System.out.println("member : " + member);
		
		/* 전체 카드 개수 조회  */
		
		int allCardCount = myworkService.selectTaskTypeCount(member.getNo(), 0);
		int reqCardCount = myworkService.selectTaskTypeCount(member.getNo(), 1);
		int doingCardCount = myworkService.selectTaskTypeCount(member.getNo(), 2);
		int doneCardCount = myworkService.selectTaskTypeCount(member.getNo(), 3);
		int waitCardCount = myworkService.selectTaskTypeCount(member.getNo(), 4);
		
		
		
		System.out.println("전체: " + allCardCount);
		System.out.println("요청: " + reqCardCount);
		System.out.println("진행: " + doingCardCount);
		System.out.println("완료: " + doneCardCount);
		System.out.println("보류: " + waitCardCount);
	
		/* 진행중인 미팅 리스트 조회 */
		List<MyworkResponseCardAndScheduleDTO> meetingList = myworkService.selectMeetingList(member.getNo());
		
		model.addAttribute("allCardCount", allCardCount);
		model.addAttribute("reqCardCount", reqCardCount);
		model.addAttribute("doingCardCount", doingCardCount);
		model.addAttribute("doneCardCount", doneCardCount);
		model.addAttribute("waitCardCount", waitCardCount);
		model.addAttribute("meetingList", meetingList);
		
		return "mywork/mywork";
		
		
	}
	
	@PostMapping(value="/mywork/requestPaging", produces ="application/json; charset=UTF-8")
	@ResponseBody
	public String requestPaging(Model model,  @RequestParam Map<String, String> parameters) throws JsonProcessingException {
		String currentPage = parameters.get("currentPage");
		int memNo = Integer.parseInt(parameters.get("memNo"));
		int type = Integer.parseInt(parameters.get("type"));
		int pageNo = 1;
		int limit = 3;
		int buttonAmount = 5;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		System.out.println("pageNo : " + pageNo);
		System.out.println("memNo:" + memNo);
		
		/* 진행중 카드 갯수 조회 */
		int totalCount = myworkService.selectTaskTypeCount(memNo, type);
		
		/* 페이지 정보 생성*/
		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		
		System.out.println("pageInfo : " + pageInfo);
		
		/* 진행중 카드 리스트 조회 */
		List<MyworkResponseCardAndTaskDTO> cardProgress2List = myworkService.selectTaskTypeList(memNo, type, pageInfo);
		
		for(int i = 0 ; i < cardProgress2List.size(); i++ ) {
			cardProgress2List.get(i).setStartPage(pageInfo.getStartPage());
			cardProgress2List.get(i).setEndPage(pageInfo.getEndPage());
			cardProgress2List.get(i).setMaxPage(pageInfo.getMaxPage());
			cardProgress2List.get(i).setTkProgress(type);
		}
		
		System.out.println("cardProgress2List : " +cardProgress2List);

		return new ObjectMapper().writeValueAsString(cardProgress2List);
		
	}
	@PostMapping(value="/mywork/updateProgress", produces ="application/json; charset=UTF-8")
	@ResponseBody
	public String updateProgress( @RequestParam Map<String, String> parameters) throws JsonProcessingException {

		int crdNo = Integer.parseInt(parameters.get("crdNo"));
		int type = Integer.parseInt(parameters.get("type"));
		int intenType = Integer.parseInt(parameters.get("intenType"));
		
		boolean result = myworkService.updateProgress(crdNo,type,intenType);
		/* 오토 커밋 여부 확인 필요 */
		if (result == false) {
			System.out.println("업데이트에 오류가 발생! ");
		} else {
			System.out.println("업뎃 완료 ");
		}
		
		
		return new ObjectMapper().writeValueAsString("mywork/mywork");
	}

}
