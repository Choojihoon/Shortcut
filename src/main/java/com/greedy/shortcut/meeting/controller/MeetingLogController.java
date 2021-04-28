package com.greedy.shortcut.meeting.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.greedy.shortcut.board.controller.ProjectBoardController;
import com.greedy.shortcut.board.model.dto.SprintDTO;
import com.greedy.shortcut.meeting.model.dto.AttendListDTO;
import com.greedy.shortcut.meeting.model.dto.MeetingDTO;
import com.greedy.shortcut.meeting.model.service.MeetingService;
import com.greedy.shortcut.member.model.dto.MemberDTO;


@Controller
@RequestMapping("/meeting/*")
public class MeetingLogController {
	
	private static final Logger logger = LoggerFactory.getLogger(MeetingLogController.class);
	private final MeetingService meetingService;

	@Autowired
	public MeetingLogController(MeetingService meetingService) {
		this.meetingService = meetingService;
		
	}
	
	@GetMapping("meetinglog")
	public String meetinglog(Model model, @RequestParam(name="pjtNo") int pjtNo, @RequestParam(name="projectName") String projectName) {
			
		/* 미팅조회 */
		List<MeetingDTO> meetingList = meetingService.selectMeetingList(pjtNo);
		
		
		
		model.addAttribute("pjtNo", pjtNo);
		model.addAttribute("projectName", projectName);
		model.addAttribute("meetingList", meetingList);
		
		
		return "meeting/meetinglog";
	}
	
	
	@PostMapping(value="/meetinglog", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String meeting(@ModelAttribute MeetingDTO meeting, RedirectAttributes rttr, @ModelAttribute AttendListDTO memberList ,@ModelAttribute MemberDTO member,HttpServletRequest request) throws JsonProcessingException{
		
		
		SortedMap<String, String[]> projectMake = Collections
				.synchronizedSortedMap(new TreeMap<String, String[]>(request.getParameterMap()));

		synchronized (projectMake) {
			
			for (String key : projectMake.keySet()) {
				String[] value = projectMake.get(key);

				for (int i = 0; i < value.length; i++) {
					System.out.println(key + " : " + value[i]);
				}
			}
		}
		int memberListsize = Integer.parseInt(((String[])projectMake.get("index"))[0]);
		
		/*회원 정보 담기*/
		 List<AttendListDTO> projectMemberList = new ArrayList<>();
		
		for(int i = 0; i < memberListsize; i++ ) {
			
			AttendListDTO projectmember = new AttendListDTO();
			
			  projectmember.setMemberNo(Integer.parseInt((((String[]) projectMake.get("meetingMember[" + i
			  + "][value]"))[0])));
			  System.out.println("가져온 이름 : " + projectmember.getMemberNo());
			 
			  projectMemberList.add(projectmember);
			  
		}
		
		for(int i = 0; i < projectMemberList.size(); i++) {
			System.out.println("DTO에 넣은 이름 : " + projectMemberList.get(i).getMemberNo());
		}
		
		/* 미팅 인서트 */
		if(!meetingService.insertMeeting(meeting)) {}
		
		/* 미팅번호 */
		MeetingDTO meetingNo = meetingService.selectMeeting();
		
		int mNo = meetingNo.getMeetingNo();
		
		for(int i = 0; i < projectMemberList.size(); i++ ) {
			int memberNo = projectMemberList.get(i).getMemberNo();
			if(meetingService.insertProjectMember(memberNo, mNo)) {
				System.out.println("입력완료!!" + memberNo) ;
			}
		}
		
		rttr.addFlashAttribute("message","회의 내용이 등록 되었습니다.");
		
		return new ObjectMapper().writeValueAsString(meeting);
	}
	
	@PostMapping(value="meetinglog/selectProjectMember", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String selectProjectMember(@ModelAttribute MemberDTO member,   @RequestParam Map<String, String> parameters, Model model) throws JsonProcessingException {
		
		int pjtNo = Integer.parseInt(parameters.get("pjtNo"));
		
		List<MemberDTO> memberList = meetingService.selectProjectMember(member, pjtNo);
		List<SprintDTO> sprintNo = meetingService.selectSprintNumber(pjtNo);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sprintNo", sprintNo);
		map.put("memberList", memberList);
		
		
		return new ObjectMapper().writeValueAsString(map);
		
		
	}
	
	@PostMapping(value="meetinglog/selectAllmeeting", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String meetingList( Model model, @RequestParam Map<String, String> parameters) throws JsonProcessingException {
		int PjtNo = Integer.parseInt(parameters.get("pjtNo"));
		System.out.println("PjtNo : " + PjtNo);
		
		List<MeetingDTO> meetingList = meetingService.selectMeetingList(PjtNo);
		System.out.println(meetingList.get(0).getMeetingName());
		
		return new ObjectMapper().writeValueAsString(meetingList);
	}
	
	@PostMapping(value="meetinglog/selectMeetingDetail", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String selectMeetingDetail(@RequestParam Map<String, String> parameters, Model model) throws JsonProcessingException {
		int meetingNo = Integer.parseInt(parameters.get("meetingNo"));
		HashMap<String,Object> meeting = meetingService.selectMeetingDetail(meetingNo);

		model.addAttribute("meeting", meeting);
		
		return new ObjectMapper().writeValueAsString(meeting);
	}
	
	@PostMapping(value="meetinglog/deletedMeeting", produces="application/json; charset=UTF-8")
	@ResponseBody
	public int deletedMeeting(@RequestParam Map<String, String> parameters, Model model) throws JsonProcessingException {
		int meetingNo = Integer.parseInt(parameters.get("meetingNo"));
		
		int result = meetingService.deletedMeeting(meetingNo);
		
		return result;
	}
	
	@PostMapping(value="meetinglog/modifyMeeting", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String modifyMeeting(@RequestParam Map<String, String> parameters, Model model) throws JsonProcessingException{
		
		int meetingNo = Integer.parseInt(parameters.get("meetingNo"));
		System.out.println("모오냐아아아 " + meetingNo);
		HashMap<String,Object> meeting = meetingService.selectMeetingDetail(meetingNo);

		model.addAttribute("meeting", meeting);
		
		
		
		return new ObjectMapper().writeValueAsString(meeting);
	}
	
	@PostMapping(value="meetinglog/modifyComplete", produces="application/json; charset=UTF-8")
	@ResponseBody
	public int modifyComplete(@RequestParam Map<String, String> parameters, Model model) {
		
		int meetingNo = Integer.parseInt(parameters.get("meetingNo"));
		String modifyTitle = (parameters.get("modifyTitle"));
		String modifyContent = (parameters.get("modifyContent"));
		
		int result = meetingService.modifyComplete(meetingNo,modifyTitle,modifyContent);
		
		return result;
	}
	
	
	
}
