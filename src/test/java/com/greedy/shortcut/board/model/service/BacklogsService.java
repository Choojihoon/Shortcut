package com.greedy.shortcut.board.model.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.greedy.shortcut.board.model.dao.BacklogMapper;
import com.greedy.shortcut.board.model.dto.BacklogDTO;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)			//spring-test에서 제공하는 단위 테스트를 위한 클래스 러너
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/resources/spring/servlet-context.xml", 
									"file:src/main/resources/spring/root-context.xml", 
									"file:src/main/resources/spring/security-context.xml"})		 //테스트의 설정이 들어있는 xml의 위치
public class BacklogsService {

	
	BacklogServiceImpl backlogService;
	
	@Mock
	BacklogMapper backlogMapper;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		backlogService = new BacklogServiceImpl(backlogMapper);
	}
	
	@Test
	public void getBacklogView() {
		BacklogDTO backlog= new BacklogDTO();
		
		List<BacklogDTO> backlogData = new ArrayList();
		backlogData.add(backlog);
		            
		when(backlogMapper.selectBacklogList(1)).thenReturn(backlogData);
		
		List<BacklogDTO> backlogs = backlogService.selectBacklogList(1);
		
		assertEquals(backlogs.size(),1 );

				}
	
	

}
