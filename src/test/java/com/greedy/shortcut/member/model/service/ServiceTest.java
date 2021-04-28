package com.greedy.shortcut.member.model.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.greedy.shortcut.member.model.dto.MemberDTO;
import com.greedy.shortcut.member.model.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)			//spring-test에서 제공하는 단위 테스트를 위한 클래스 러너
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/resources/spring/servlet-context.xml", 
									"file:src/main/resources/spring/root-context.xml", 
									"file:src/main/resources/spring/spring-security.xml"})		 //테스트의 설정이 들어있는 xml의 위치
public class ServiceTest {

	@Autowired
	MemberService memberService;
	
	MemberDTO memberDTO;
	
	@Before
    public void setUp() throws Exception {
		memberDTO = new MemberDTO();
		memberDTO.setNo(1);
		memberDTO.setEmail("email");
		memberDTO.setPassword("123");
		memberDTO.setPhone("010");
		memberDTO.setName("남경");
	    }

	@Test
    public void testRegist() throws Exception {
        assertTrue(memberService.registMember(memberDTO));
    }

		


}
