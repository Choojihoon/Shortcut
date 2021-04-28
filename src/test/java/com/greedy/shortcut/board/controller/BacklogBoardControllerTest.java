package com.greedy.shortcut.board.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;
@RunWith(SpringJUnit4ClassRunner.class)			//spring-test에서 제공하는 단위 테스트를 위한 클래스 러너
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/resources/spring/servlet-context.xml", 
									"file:src/main/resources/spring/root-context.xml", 
									"file:src/main/resources/spring/security-context.xml"})		
public class BacklogBoardControllerTest {
	
  	 private static final Logger logger = LoggerFactory.getLogger(BacklogBoardController.class);
	
	 @Inject
	 private WebApplicationContext wac;
	
	 private MockMvc mockMvc;
	
	 java.sql.Date projectStartDate=java.sql.Date.valueOf("2021-04-20");
	 java.sql.Date projectEndDate=java.sql.Date.valueOf("2021-05-13");
	 
	 List<ProjectAuthorityDTO> projectMember = new ArrayList<ProjectAuthorityDTO>();
	 private List<MemberDTO> member = new ArrayList<MemberDTO>();
	 ProjectDTO project11 = new ProjectDTO(1, "PJOJECT1",projectStartDate, "N", 1,  projectEndDate, "#FFD9EC", projectMember,member);
	 ProjectAuthorityDTO member1 = new ProjectAuthorityDTO(1,1,1,1, "shortcut");
	 ProjectAuthorityDTO member2 = new ProjectAuthorityDTO(2,1,2,2, "wankkyu@greedy.com");
	 
	@Before
	public void setup() {
		//스프링이 준 WebApplicationContext를 이용해서 mockmvc를 생성
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.debug("setup BeanTest mockMvc...");
		projectMember.add(member1);
		projectMember.add(member2);
	}
	
	@Parameters
	public static <E> List<Object[]> config(){
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		map1.put("pjtNo", "1");
		map1.put("projectName","PJOJECT16");
		map1.put("memberNo", "1");
		map1.put("projectStartDate", "projectStartDate");
		map1.put("projectEndDate", "projectEndDate");
		map1.put("projectColor", "#99999");
		
		map2.put("projectRole", "1");
		map2.put("memberNo", "1");
		
		return Arrays.asList(new Object[][] {
			{map1},
			{map2}
		});
//		.param("projectRole", "1")
	}
	
	@Test
	public void testProject() throws Exception {
		this.mockMvc.perform(get("/board/backlog")
					.param("pjtNo","3")
					.param("projectName","ShortCut")
		)
		.andDo(print())
		//정상 처리 되는지 확인
		.andExpect(status().isOk())
		//담당 컨트롤러가 MemberController인지 확인
		.andExpect(handler().handlerType(BacklogBoardController.class))
		//메소드 이름이 listPage인지 확인
		.andExpect(handler().methodName("project"));
		
	}

//	@Test
//	public void testBacklogPaging() {
//		fail("Not yet implemented"); // TODO 백로그 페이징 처리
//	}
//
//	@Test
//	public void testSprintPaging() {
//		fail("Not yet implemented"); // TODO
//	}

	@Ignore
	public void testIdprojectcheck() throws Exception {
			this.mockMvc.perform(post("/board/projectidDupCheckEdit")
					.param("email", "shortcut")
		)
		.andDo(print())
		//정상 처리 되는지 확인
		.andExpect(status().isOk())
		//담당 컨트롤러가 MemberController인지 확인
		.andExpect(handler().handlerType(BacklogBoardController.class))
		//메소드 이름이 listPage인지 확인
		.andExpect(handler().methodName("idprojectcheck"));
		}

	@Test
	@Ignore
	public void testEditProject() throws Exception {
		
//		MultiValueMap<String, String> paramMap1 = new LinkedMultiValueMap<>();
//		paramMap1.addAll((MultiValueMap<String, String>) projectMember);
//		//paramMap1.put(projectMember, "ProjectAuthorityDTO");
		this.mockMvc.perform(post("/board/backlog/project_edit")
				.param("memberCount", "2")
				.param("pjtNo", "1")
				.param("projectName","PJOJECT16")
				.param("memberNo", "1")
				.param("projectStartDate","2021-04-20")
				.param("projectEndDate", "2021-04-20")
				.param("projectColor", "#99999")
				.param("projectRole", "1")
				
				)
				//.params(params)
				
	.andDo(print())
	//정상 처리 되는지 확인
	.andExpect(status().isOk())
	//담당 컨트롤러가 MemberController인지 확인
	.andExpect(handler().handlerType(BacklogBoardController.class))
	//메소드 이름이 listPage인지 확인
	.andExpect(handler().methodName("EditProject"));
	}

	@Ignore
	public void testBacklogDetail() throws Exception {
		this.mockMvc.perform(post("/board/backlogDetail")
					.param("blgNo", "1")
					.param("projectNo", "1")
		)
		.andDo(print())
		//정상 처리 되는지 확인
		.andExpect(status().isOk())
		//담당 컨트롤러가 MemberController인지 확인
		.andExpect(handler().handlerType(BacklogBoardController.class))
		//메소드 이름이 listPage인지 확인
		.andExpect(handler().methodName("backlogDetail"));
	}

	@Ignore
	public void testSprintDetail() throws Exception {
		this.mockMvc.perform(post("/board/sprintDetail")
				.param("sprNo", "1")
	)
	.andDo(print())
	//정상 처리 되는지 확인
	.andExpect(status().isOk())
	//담당 컨트롤러가 MemberController인지 확인
	.andExpect(handler().handlerType(BacklogBoardController.class))
	//메소드 이름이 listPage인지 확인
	.andExpect(handler().methodName("sprintDetail"));
	}

	@Ignore
	public void testRemoveProject() throws Exception {
		this.mockMvc.perform(post("/board/projectRemove")
				.param("pjtNo", "1")
				.param("projectName", "PJOJECT1")
				.param("projectStartDate", "2021-04-20")
				.param("projectEndDate", "2021-05-20")
				.param("projectColor", "#FFD9EC")
				
	)
	.andDo(print())
	//정상 처리 되는지 확인
	.andExpect(status().isOk())
	//담당 컨트롤러가 MemberController인지 확인
	.andExpect(handler().handlerType(BacklogBoardController.class))
	//메소드 이름이 listPage인지 확인
	.andExpect(handler().methodName("removeProject"));
	}

	@Ignore
	public void testRegistBacklog() throws Exception {
		this.mockMvc.perform(post("/board/backlog/backlog_regist")
				.param("blgName", "BacklogName")
				.param("blgPri", "1")
				.param("pjtNo", "1")
				.param("blgDemoMemo", "#demo")
				.param("blgRefMemo", "#memo")
				
	)
	.andDo(print())
	//정상 처리 되는지 확인
	.andExpect(status().isOk())
	//담당 컨트롤러가 MemberController인지 확인
	.andExpect(handler().handlerType(BacklogBoardController.class))
	//메소드 이름이 listPage인지 확인
	.andExpect(handler().methodName("registBacklog"));
	}

	@Ignore
	public void testEditBacklog() throws Exception {
		this.mockMvc.perform(post("/board/backlog/backlog_Edit")
				.param("pjtNo", "1")
				.param("blgNo", "1")
				.param("blgName", "BacklogName")
				.param("blgPri", "1")
				.param("pjtNo", "1")
				.param("blgDemoMemo", "#demo")
				.param("blgRefMemo", "#memo")
				
	)
	.andDo(print())
	//정상 처리 되는지 확인
	.andExpect(status().isOk())
	//담당 컨트롤러가 MemberController인지 확인
	.andExpect(handler().handlerType(BacklogBoardController.class))
	//메소드 이름이 listPage인지 확인
	.andExpect(handler().methodName("EditBacklog"));
	}

	@Ignore
	public void testRemoveBacklog() throws Exception {
		this.mockMvc.perform(post("/board/backlog/backlog_Remove")
				.param("pjtNo", "1")
				.param("blgNo", "1")
				
	)
	.andDo(print())
	//정상 처리 되는지 확인
	.andExpect(status().isOk())
	//담당 컨트롤러가 MemberController인지 확인
	.andExpect(handler().handlerType(BacklogBoardController.class))
	//메소드 이름이 listPage인지 확인
	.andExpect(handler().methodName("RemoveBacklog"));
	}

	@Ignore
	public void testRegistSprint() throws Exception {
		this.mockMvc.perform(post("/board/sprint/sprint_regist")
				.param("sprName", "sprintName")
				.param("sprStardDate", "2021-04-20")
				.param("sprEndDate", "2021-05-20")
				.param("sprGoal", "sprintGoal")
				.param("sprBlgNo", "1")
				
	)
	.andDo(print())
	//정상 처리 되는지 확인
	.andExpect(status().isOk())
	//담당 컨트롤러가 MemberController인지 확인
	.andExpect(handler().handlerType(BacklogBoardController.class))
	//메소드 이름이 listPage인지 확인
	.andExpect(handler().methodName("registSprint"));
	}

	@Ignore
	public void testRemoveSprint() throws Exception {
		this.mockMvc.perform(post("/board/sprint/sprint_remove")
				.param("sprNo", "1")
				
	)
	.andDo(print())
	//정상 처리 되는지 확인
	.andExpect(status().isOk())
	//담당 컨트롤러가 MemberController인지 확인
	.andExpect(handler().handlerType(BacklogBoardController.class))
	//메소드 이름이 listPage인지 확인
	.andExpect(handler().methodName("RemoveSprint"));
	}

	@Ignore
	public void testEditSprint() throws Exception {
		this.mockMvc.perform(post("/board/sprint/sprint_Edit")
				.param("sprNo", "1")
				.param("sprName", "sprintName")
				.param("sprStardDate", "2021-04-20")
				.param("sprEndDate", "2021-05-20")
				.param("sprGoal", "sprintGoal")
				
	)
	.andDo(print())
	//정상 처리 되는지 확인
	.andExpect(status().isOk())
	//담당 컨트롤러가 MemberController인지 확인
	.andExpect(handler().handlerType(BacklogBoardController.class))
	//메소드 이름이 listPage인지 확인
	.andExpect(handler().methodName("EditSprint"));
	}

}
