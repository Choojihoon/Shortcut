package com.greedy.shortcut.board.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.board.model.service.ProjectBoardService;
import com.greedy.shortcut.member.model.dto.MemberDTO;

@Controller
@RequestMapping("/board/*")
public class ProjectBoardController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectBoardController.class);
	private final ProjectBoardService projectBoardService;

	@Autowired
	public ProjectBoardController(ProjectBoardService projectBoardService) {
		this.projectBoardService = projectBoardService;
	}

	@GetMapping("project_board/{no}")
	public String project(Model model, HttpServletRequest request, @PathVariable("no") int no) {
		
		/*
		 * Object principal =
		 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 * UserDetails userDetails = (UserDetails) principal; String email =
		 * userDetails.getUsername();
		 */
		
		System.out.println("no :" + no);
		
		List<ProjectDTO> projectList = projectBoardService.selectProjectList(no);
		for(ProjectDTO project : projectList) {
			System.out.println(project);
		}
		
		model.addAttribute("projectList", projectList);
		
		return "board/project_board";
	}

	@PostMapping(value="/project_regist" , produces="application/json; charset=UTF-8")
	@ResponseBody
	public String registProject(HttpSession httpsession,		
			@ModelAttribute ProjectDTO project,
			HttpServletRequest request, RedirectAttributes rttr) throws JsonProcessingException {
		
		System.out.println(project);
		
		/* model key value 값 출력 */
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
		/*회원 정보 담기*/
		 List<ProjectAuthorityDTO> projectMemberList = new ArrayList<>();
		 
		 for(int i = 0; i < (projectMake.size() - 4)/2; i++) {
			 ProjectAuthorityDTO projectAuthority = new ProjectAuthorityDTO();
			  
			 projectAuthority.setMemberNo(Integer.parseInt(((String[]) projectMake.get("nk1[" + i + "][value]"))[0]));
			 i++;
			 projectAuthority.setProjectRole(Integer.parseInt(((String[]) projectMake.get("nk1[" + i + "][value]"))[0]));
			 
			 projectMemberList.add(projectAuthority);
		 }
			
			if (!projectBoardService.insertProject(project) 
					|| !projectBoardService.insertProjectMember(project, projectMemberList)	) {
			 rttr.addFlashAttribute("message","프로젝트 생성이 취소되었습니다.");
				return new ObjectMapper().writeValueAsString(project);
		 }
			 rttr.addFlashAttribute("message","프로젝트가 생성되었습니다.");
			 return new ObjectMapper().writeValueAsString(project);
		//return "/board/backlog";
	}
	/* 이메일 유무  체크*/
	@PostMapping(value="/projectidDupCheck" , produces="application/json; charset=UTF-8")
	@ResponseBody
	public int idprojectcheck(@ModelAttribute MemberDTO member, HttpServletRequest request) {
		
		System.out.println(member);
		int result = projectBoardService.idprojectcheck(member);
		return result;
	}
	
}
