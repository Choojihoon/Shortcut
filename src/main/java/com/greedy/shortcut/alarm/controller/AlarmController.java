package com.greedy.shortcut.alarm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greedy.shortcut.alarm.model.dto.AlertDTO;
import com.greedy.shortcut.alarm.model.service.AlarmService;

@Controller
@RequestMapping("/*")
public class AlarmController {

	private final AlarmService alarmService;
	
	@Autowired
	public AlarmController(AlarmService alarmService) {
		this.alarmService = alarmService;
	}
	
//	@GetMapping(value="alarm/github", produces="application/json; charset=UTF-8")
//	@ResponseBody
//	public String selectGitUrl(@RequestParam int memNo, Model model	) throws JsonProcessingException {
//		
//		String gitUrl = alarmService.selectGitUrl(memNo);
//		model.addAttribute("gitUrl", gitUrl);
//		
//		return new ObjectMapper().writeValueAsString(gitUrl);
//	}
	
	@PostMapping("alarm/github/regist")
	public ModelAndView registGitUrl(ModelAndView mv, @RequestParam(required=true) String githubInfo, @RequestParam int memNo,
			HttpSession session, RedirectAttributes rttr) {
		
		int success = alarmService.registGitUrl(memNo, githubInfo);
		System.out.println("success : " + success);
		
		String gitUrl = alarmService.selectGitUrl(memNo);
		
		session.invalidate();
		rttr.addFlashAttribute("flashMessage", "다시 로그인 해주세요!");
		
		mv.addObject("gitUrl", gitUrl);
		mv.setViewName("redirect:/");
		
		return mv;
	}
	
	@PostMapping("alarm/github/modify")
	public ModelAndView modifyGitUrl(ModelAndView mv, @RequestParam(required=true) String modifyUrl, @RequestParam int memNo,
			RedirectAttributes rttr) {
		
		System.out.println("memNo : " + memNo);
		System.out.println("modifyUrl : " + modifyUrl);
		
		int success = alarmService.modifyGitUrl(memNo, modifyUrl);
		System.out.println("success : " + success);
		
		String gitUrl = alarmService.selectGitUrl(memNo);
		
		rttr.addFlashAttribute("flashMessage", "다시 로그인 해주세요!");

		mv.setViewName("redirect:/");
		
		return mv;
	}
	
	@PostMapping("alarm/github/remove")
	public ModelAndView removeGitUrl(ModelAndView mv, @RequestParam int memNo,
			RedirectAttributes rttr) {
		
		int success = alarmService.removeGitUrl(memNo);
		System.out.println("success : " + success);
		
		rttr.addFlashAttribute("flashMessage", "다시 로그인 해주세요!");
		
		mv.setViewName("redirect:/");
		
		return mv;
	}
	
	@GetMapping(value="session/expire", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String sessionExpire(HttpSession session) throws JsonProcessingException {
		
		session.invalidate();
		
		return new ObjectMapper().writeValueAsString("session expire!");
	}
	
	@GetMapping(value="alarm/general", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String generalAlarm(@RequestParam int no) throws JsonProcessingException {

		List<AlertDTO> generalAlarmList = alarmService.selectGeneralAlarmList(no);
		
		return new ObjectMapper().writeValueAsString(generalAlarmList);
	}
	
	@PostMapping(value="alarm/general/read", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String generalAlarmRead(@RequestParam int no) throws JsonProcessingException {
		
		int success = alarmService.modifyAlarmRead(no);
		
		return new ObjectMapper().writeValueAsString(success);
	}
	
	@PostMapping(value="alarm/general/remove", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String generalAlarmRemove(@RequestParam int altDelNo) throws JsonProcessingException {
		
		int success = alarmService.modifyAlarmRemove(altDelNo);
		
		return new ObjectMapper().writeValueAsString(success);
	}
	
}
