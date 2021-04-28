package com.greedy.shortcut.mywork.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greedy.shortcut.mywork.model.dto.ClientCardTaskAndCardAndMemberDTO;
import com.greedy.shortcut.mywork.model.dto.ClientProjectAndSprintDTO;
import com.greedy.shortcut.mywork.model.dto.ClientProjectDTO;
import com.greedy.shortcut.mywork.model.dto.ClientSprintAndCardTask;
import com.greedy.shortcut.mywork.model.dto.ProjectInfoTest;
import com.greedy.shortcut.mywork.model.service.ClientService;

@Controller
@RequestMapping("/*")
public class ClientController {

	private final ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping("mywork/client")
	public String client(Model model, HttpServletRequest request/* , Principal principal */) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails) principal;
		String email = userDetails.getUsername();
//		System.out.println("username : " + userDetails.getUsername());
//		System.out.println("password : " + userDetails.getPassword());
//		System.out.println("toString : " + userDetails.toString());
//		String email = principal.getName();
//		Object cl = principal.getClass();
//		System.out.println("cl : " + cl);
		
		/* session 값 확인하기 */
//		HttpSession session = request.getSession();
//		String session_name = "";
//		String session_value = "";
//		Enumeration enum_01 = session.getAttributeNames(); 
//		int i = 0;
//		while(enum_01.hasMoreElements()) {
//			i++;
//			session_name = enum_01.nextElement().toString();
//			session_value = session.getAttribute(session_name).toString();
//			System.out.println("SESSION NAME[ " + session_name + " ] SESSION VALUE[ " + session_value + " ]");
//		}
		/*====*/
		
		/*
		 * List<ClientProjectDTO> projectList = clientService.selectProjectList(email);
		 * for(ClientProjectDTO project : projectList) { System.out.println(project); }
		 */
		List<Integer> projectNumberList = clientService.selectProjectNuber(email);
		List<ClientProjectDTO> projectList = new ArrayList<>();
		for(int i = 0; i < projectNumberList.size(); i++) {
			ClientProjectDTO pjt = clientService.selectProjectList(projectNumberList.get(i));
			projectList.add(pjt);
		}
		
		for(ClientProjectDTO project : projectList) {
			System.out.println(project);
		}
		
		model.addAttribute("projectList", projectList);
		
		return "mywork/client";
	}
	
	/* TEST 용 */
	@GetMapping(value="mywork/projectInfo", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String getProjectInfo() throws JsonProcessingException {
		
		List<ProjectInfoTest> projectTestList = new ArrayList<>();
		
		Calendar startDate = new GregorianCalendar(2021, 4, 4);
		Date stDate = new Date(startDate.getTimeInMillis());
		Calendar endDate = new GregorianCalendar(2021, 4, 30);
		Date enDate = new Date(endDate.getTimeInMillis());
		
//		Date from = new Date();
//		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String to = transFormat.format(from);

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String s = transFormat.format(stDate);
		System.out.println(s);
		String e = transFormat.format(enDate);
		System.out.println(e);
		
		String s2 = s.substring(5);
		String e2 = e.substring(5);
		System.out.println(s2);
		System.out.println(e2);
		
		projectTestList.add(new ProjectInfoTest("project1", "test1", stDate, enDate));
		//System.out.println(projectTestList);
		//System.out.println(projectTestList.get(0));
		//System.out.println(new ObjectMapper().writeValueAsString(projectTestList));
		
		return new ObjectMapper().writeValueAsString(projectTestList);
	}
	
	@GetMapping(value="mywork/client/projectInfo/{pjtNo}")
	public String selectProjectInfo(Model model, @PathVariable("pjtNo") int pjtNo) {
		
		/* 프로젝트 재조회(위에 다시 view에 보여줘야하므로) */
//		List<ClientProjectDTO> projectList = clientService.selectProjectList2(pjtNo);
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails) principal;
		String email = userDetails.getUsername();
		
		List<Integer> projectNumberList = clientService.selectProjectNuber(email);
		List<ClientProjectDTO> projectList = new ArrayList<>();
		for(int i = 0; i < projectNumberList.size(); i++) {
			ClientProjectDTO pjt = clientService.selectProjectList(projectNumberList.get(i));
			projectList.add(pjt);
		}
		
		/* 선택한 프로젝트의 정보들 조회(스프린트 정보) */
		ClientProjectAndSprintDTO projectInfo = clientService.selectOneProjectByPjNo(pjtNo);
		System.out.println("projectInfo : " + projectInfo);
		
		/* 스프린트의 수 */
		int totalSprintCount = clientService.selectSprintCount(pjtNo);
		System.out.println("totalSprintCount : " + totalSprintCount);
		
		/* 각 스프린트 당 업무들 조회 */
		/* 스프린트 번호와 업무 정보만 있는 DTO 타입의 리스트 만들기 */
		List<ClientSprintAndCardTask> sprintAndTaskList = new ArrayList<>();
		
		/* 스프린트 수만큼 반복 */
		for(int i = 0; i < totalSprintCount; i++) {
			/* 각 프로젝트 정보의 스프린트 번호를 꺼내기 */
			int sprNo = projectInfo.getSprintList().get(i).getSprNo();
			String sprName = projectInfo.getSprintList().get(i).getSprName();
			ClientSprintAndCardTask sprintAndCardTask = new ClientSprintAndCardTask();
			
			/* 업무와 카드, 담당자를 담을 리스트 조회 */
			List<ClientCardTaskAndCardAndMemberDTO> barInfo = clientService.selectBarInfo(sprNo);
			for(ClientCardTaskAndCardAndMemberDTO bar : barInfo) {
				System.out.println(i + " - " + bar);
			}
			
			/* 스프린트 번호와 리스트 담기  */
			sprintAndCardTask.setSprintNo(sprNo);
			sprintAndCardTask.setSprintName(sprName);
			sprintAndCardTask.setSprintAndCardTaskList(barInfo);
			
			sprintAndTaskList.add(sprintAndCardTask);
		}
		
		for(ClientSprintAndCardTask cct : sprintAndTaskList ) {
			System.out.println(cct);
		}
		
		/* 업무의 수가 항상 같을 수는 없으니 각 스프린트당 업무의 수를 구해주어야 한다. 밑에 반복문에서 최댓값으로 반복 횟수를 정한다. */
		int max = 0;
		List<Integer> temp = new ArrayList();
		for(int i = 0; i < sprintAndTaskList.size(); i++) {
			System.out.println(i + " " + sprintAndTaskList.get(i).getSprintAndCardTaskList().size());
			temp.add(sprintAndTaskList.get(i).getSprintAndCardTaskList().size());
		}
		System.out.println("temp : " + temp);
		
		if(temp.size() > 0) {
			max = Collections.max(temp);
			System.out.println("max : " + max);
		}
		
		/* 날짜 타입 지정 */
		DateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		/* 구글 차트 String 조합하기 */
		String assemblyString = "";
		String result = "";
		System.out.println("sprintAndTaskList.size() : " + sprintAndTaskList.size());
		
		if(sprintAndTaskList.size() > 0) {
			for(int i = 0; i < sprintAndTaskList.size(); i++) {
				for(int j = 0; j < max; j++) {
					
					/* break - 각 업무 수가 다 찼을 때는 break */
					int eachAmount = sprintAndTaskList.get(i).getSprintAndCardTaskList().size();
					if(eachAmount == j) {
						break;
					}
					
					/* 날짜 잘라서 String 타입의 배열에 담기(문자열이 아니면 dateFormat 사용불가) */
					String[] startDateArray = dtFormat.format(sprintAndTaskList.get(i).getSprintAndCardTaskList().get(j).getCardTaskDTO().getStartDate()).split("-"); 
					String[] endDateArray = dtFormat.format(sprintAndTaskList.get(i).getSprintAndCardTaskList().get(j).getCardTaskDTO().getEndDate()).split("-"); 
					
					/* 자른 년, 월, 일을 int형으로 다시 바꾸고 문자열로 만들기 */
					assemblyString += "[ \"" + sprintAndTaskList.get(i).getSprintName() + "\"" + ", "
							        + "\"" + sprintAndTaskList.get(i).getSprintAndCardTaskList().get(j).getMemberDTO().getName() + "-"
							        + sprintAndTaskList.get(i).getSprintAndCardTaskList().get(j).getCardDTO().getCrdTxt() + "\"" + ", "
							        + "new Date(" + Integer.parseInt(startDateArray[0]) + ", " + Integer.parseInt(startDateArray[1]) + ", " + Integer.parseInt(startDateArray[2]) + ")" + ", "
							        + "new Date(" + Integer.parseInt(endDateArray[0]) + ", " + Integer.parseInt(endDateArray[1]) + ", " + Integer.parseInt(endDateArray[2]) + ")" + "]"; 
					
					if(!(i == (sprintAndTaskList.size()))) {
						assemblyString += ", ";
					}
				}
			}
			
			/* 완성된 구글 차트 문자열 */
			String assemblyResult = assemblyString.substring(0, assemblyString.lastIndexOf(","));
			System.out.println("assemblyResult : " + assemblyResult);
			
			result += "[" + assemblyResult + "]";
			System.out.println("result : " + result);
		} 
		
		model.addAttribute("projectList", projectList);                                                                                                                                                                                                                                                                                                      
		model.addAttribute("projectInfo", projectInfo);
		model.addAttribute("totalSprintCount", totalSprintCount);
		model.addAttribute("result", result);
		
		return "mywork/client";
	}
	
}
