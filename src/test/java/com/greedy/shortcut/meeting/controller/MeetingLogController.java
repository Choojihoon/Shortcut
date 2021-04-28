package com.greedy.shortcut.meeting.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)			//spring-test에서 제공하는 단위 테스트를 위한 클래스 러너
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/resources/spring/servlet-context.xml", 
									"file:src/main/resources/spring/root-context.xml", 
									"file:src/main/resources/spring/security-context.xml"})	
public class MeetingLogController {
	
	//웹 응용 프로그램의 구성을 제공하는 인터페이스
			private static final Logger logger = LoggerFactory.getLogger(MeetingLogController.class);
			
			@Inject
			private WebApplicationContext wac;
			
			private MockMvc mockMvc;
	
			@Before
			public void setup() {
				//스프링이 준 WebApplicationContext를 이용해서 mockmvc를 생성
				this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
				logger.debug("setup BeanTest mockMvc...");
			}
			@Test
			public void backlogView() throws Exception {
				this.mockMvc.perform(get("/meeting/meetinglog")
							.param("pjtNo","1")
							.param("projectName","PJOJECT1")
				)
				.andDo(print())
				//정상 처리 되는지 확인
				.andExpect(status().isOk())
				//담당 컨트롤러가 MemberController인지 확인
				.andExpect(handler().handlerType(MeetingLogController.class))
				//메소드 이름이 listPage인지 확인
				.andExpect(handler().methodName("project"));
			}
}
