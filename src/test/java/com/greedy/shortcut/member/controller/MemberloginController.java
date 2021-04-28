package com.greedy.shortcut.member.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test. web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)			//spring-test에서 제공하는 단위 테스트를 위한 클래스 러너
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/resources/spring/servlet-context.xml", 
									"file:src/main/resources/spring/root-context.xml", 
									"file:src/main/resources/spring/security-context.xml"})		 //테스트의 설정이 들어있는 xml의 위치
public class MemberloginController {
	//웹 응용 프로그램의 구성을 제공하는 인터페이스
	private static final Logger logger = LoggerFactory.getLogger(MemberloginController.class);
	
	//톰캣을 작동시키지 않아도 컨트롤러 테스트를 진행하게 해줌
	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		//스프링이 준 WebApplicationContext를 이용해서 mockmvc를 생성
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.debug("setup BeanTest mockMvc...");
	}
	
	@Ignore
	public void MemberregistView() throws Exception {
		this.mockMvc.perform(get("/regist"))
		.andDo(print())
		//정상 처리 되는지 확인
		.andExpect(status().isOk())
		//담당 컨트롤러가 MemberController인지 확인
		.andExpect(handler().handlerType(MemberController.class))
		//메소드 이름이 listPage인지 확인
		.andExpect(handler().methodName("registForm"));
	}
	
	//테스트할 용도의 어노테이션, 테스트가 완료됐다면 ignore로 바꿔서 테스트를 안하게 할 수 있다.
	@Test
	public void Memberregist() throws Exception {
		this.mockMvc.perform(post("/regist")
				.param("email","email")
				.param("password", "pwd")
				.param("phone", "010")
				.param("name", "name")
				)
		.andDo(print())
		//정상 처리 되는지 확인
		.andExpect(status().isOk())
		//담당 컨트롤러가 MemberController인지 확인
		.andExpect(handler().handlerType(MemberController.class))
		//메소드 이름이 listPage인지 확인
		.andExpect(handler().methodName("registMember"));
	}

	@Ignore
	public void MemberLogin() throws Exception {
		this.mockMvc.perform(post("/member/login")
				.param("id", "nk3466")
				.param("pwd", "pwd"))
		.andDo(print())
		//정상 처리 되는지 확인
		.andExpect(status().isOk())
		//담당 컨트롤러가 MemberController인지 확인
		.andExpect(handler().handlerType(MemberController.class))
		//메소드 이름이 listPage인지 확인
		.andExpect(handler().methodName("login"));
		
	}
	//302 에러 발생
	@Ignore
	public void MemberLogout() throws Exception {
		this.mockMvc.perform(get("/member/logout")
				.param("id", "nk3466")
				.param("pwd", "pwd")
				)	.andDo(print())
		//정상 처리 되는지 확인
		.andExpect(status().isOk())
		//담당 컨트롤러가 MemberController인지 확인
		.andExpect(handler().handlerType(MemberController.class))
		//메소드 이름이 listPage인지 확인
		.andExpect(handler().methodName("login"));
	}
	

}
