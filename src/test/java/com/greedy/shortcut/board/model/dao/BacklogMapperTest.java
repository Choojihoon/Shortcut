package com.greedy.shortcut.board.model.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
@RunWith(SpringJUnit4ClassRunner.class)			//spring-test에서 제공하는 단위 테스트를 위한 클래스 러너
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/resources/spring/servlet-context.xml", 
									"file:src/main/resources/spring/root-context.xml", 
									"file:src/main/resources/spring/security-context.xml"})	
public class BacklogMapperTest {

	@Autowired
	BacklogMapper backlogMapper;

	@Test
	public void testSelectProject() {
		assertThat(backlogMapper.selectProject(1), is(notNullValue()));
	}

	@Test
	public void testSelectMemberList() {
		List<ProjectAuthorityDTO> projectMember = backlogMapper.selectMemberList(2);
		assertThat(projectMember, is(notNullValue()));
		projectMember.forEach(member -> System.out.println(member));
	}

	@Ignore
	@Test
	public void testSelectMemberDupCheck() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testUpdateProject() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testInsertEditProjectHistory() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testDeleteProjectMember() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testInsertEditProjectMember() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testInsertEditProjectMemberHistory() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testRemoveProject() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testInsertRemoveProjectHistory() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testSelectBacklogList() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testInsertBacklog() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testInsertBacklogHistory() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testSelectBacklogToEdit() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testEditBacklog() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testInsertEditBacklogHistory() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testRemoveBacklog() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testInsertRemoveBacklogHistory() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testSelectSprintList() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testRegistSprint() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testRegistSprintHistory() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testSelectsprintDetailToEdit() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testRemoveSprint() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testEditSprint() {
		fail("Not yet implemented"); // TODO
	}
	
	@Ignore
	@Test
	public void testInsertEditSprintHistory() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testRemoveUpdateHistorySprint() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testRemoveBacklogSprint() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testSelectBacklogNo() {
		fail("Not yet implemented"); // TODO
	}

}
