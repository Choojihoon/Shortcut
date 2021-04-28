package com.greedy.shortcut.board.model.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.greedy.shortcut.board.model.dao.BacklogMapper;
import com.greedy.shortcut.board.model.dto.BacklogDTO;
import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.board.model.dto.SprintDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;
@RunWith(MockitoJUnitRunner.class)			//spring-test에서 제공하는 단위 테스트를 위한 클래스 러너
public class BacklogServiceImplTest {
	
	@InjectMocks
	private BacklogServiceImpl backlogService;
	
	@Mock
	private BacklogMapper backlogMapper;
	
	 java.sql.Date projectStartDate=java.sql.Date.valueOf("2021-04-20");
	 java.sql.Date projectEndDate=java.sql.Date.valueOf("2021-05-13");
	 java.sql.Date SprintStartDate=java.sql.Date.valueOf("2021-04-20");
	 java.sql.Date SprintEndDate=java.sql.Date.valueOf("2021-05-13");
	 
	 List<ProjectAuthorityDTO> projectMember = new ArrayList<ProjectAuthorityDTO>();
	 private List<MemberDTO> member = new ArrayList<MemberDTO>();
	 
	 ProjectDTO project = new ProjectDTO(1, "PJOJECT1",projectStartDate, "N", 1,  projectEndDate, "#FFD9EC", projectMember,member);
	 ProjectAuthorityDTO member1 = new ProjectAuthorityDTO(1,1,1,1, "shortcut");
	 ProjectAuthorityDTO member2 = new ProjectAuthorityDTO(2,1,2,2, "wankkyu@greedy.com");
	 
	 List<BacklogDTO> backlogList= new ArrayList<BacklogDTO>();
	 BacklogDTO backlog1= new BacklogDTO(1, "BACKLOG1-1",1,"테스트 데모 방식1", "테스트 참고 1" );
	 BacklogDTO backlog2= new BacklogDTO(2, "BACKLOG1-2",1,"테스트 데모 방식2", "테스트 참고 2" );
	 
	 List<SprintDTO> sprintList = new ArrayList<SprintDTO>();
	 SprintDTO sprint1 = new SprintDTO(1,"SprintName1", SprintStartDate, SprintEndDate, "SprintGoal", 1);
	 SprintDTO sprint2 = new SprintDTO(2,"SprintName2", SprintStartDate, SprintEndDate, "SprintGoal", 2);
	
	 @Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		backlogService = new BacklogServiceImpl(backlogMapper);
		projectMember.add(member1);
		projectMember.add(member2);
		
		backlogList.add(backlog1);
		backlogList.add(backlog2);
	}

	@Test
	public void testSelectProjectList() {
		when(backlogService.selectProjectList(project.getPjtNo())).thenReturn(project);
		ProjectDTO projects = backlogService.selectProjectList(project.getPjtNo());
		assertThat(projects, is(notNullValue()));
	}

	@Test
	public void testSelectMemberList() {
		when(backlogService.selectMemberList(project.getPjtNo())).thenReturn(projectMember);
		List<ProjectAuthorityDTO> projectMembers = backlogService.selectMemberList(project.getPjtNo());
		assertThat(projectMembers.size(), is(equalTo(2)));
	} 

	@Ignore
	@Test
	public void testIdprojectcheck() {
		//MemberDTO member = new MemberDTO();
		//when(backlogService.idprojectcheck(member1.getMemberId())).thenReturn(member1.getMemberNo());		//회원 가입 되어있는 회원 조회
		int memberNo = backlogService.idprojectcheck(member1.getMemberId());
		
		assertThat(backlogService.idprojectcheck(member1.getMemberId()),is(notNullValue()));
		
	}

	@Ignore
	@Test
	public void testInsertEditProject() {
		assertThat(backlogService.insertEditProject(project), is(notNullValue()));
	}

	@Ignore
	@Test
	public void testInsertEditProjectMember() {
		assertTrue(backlogService.insertEditProjectMember(project, projectMember));
	}

	@Ignore
	@Test
	public void testRemoveProject() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testSelectBacklogList() {
		BacklogDTO backlog= new BacklogDTO();
		List<BacklogDTO> backlogData = new ArrayList<BacklogDTO>();
		backlogData.add(backlog);
		when(backlogMapper.selectBacklogList(1)).thenReturn(backlogData);
		
		List<BacklogDTO> backlogs = backlogService.selectBacklogList(1);
		assertThat(backlogs.size(), is(equalTo(1)));
	}

	@Ignore
	@Test
	public void testInsertBacklog() {
		assertThat(backlogService.insertBacklog(backlog1),is(notNullValue()));
	}

	@Ignore
	@Test
	public void testSelectBacklogToEdit() {
		when(backlogService.selectBacklogToEdit(backlog1.getBlgNo(), backlog1.getPjtNo())).thenReturn(backlog1);
		BacklogDTO backlog = backlogService.selectBacklogToEdit(backlog1.getBlgNo(), backlog1.getPjtNo());
		assertThat(backlog, is(notNullValue()));
	}

	@Ignore
	@Test
	public void testSelectSprintList() {
		when(backlogService.selectSprintList(project.getPjtNo())).thenReturn(sprintList);
		List<SprintDTO> sprint = backlogService.selectSprintList(project.getPjtNo());
		assertThat(sprint, is(notNullValue()));
	}

	@Ignore
	@Test
	public void testEditBacklog() {
		when(backlogService.EditBacklog(backlog1)).thenReturn(true);
		boolean a = backlogService.EditBacklog(backlog1);
		assertThat(a, is(notNullValue()));
	}

	@Ignore
	@Test
	public void testRemoveBacklog() {
		assertThat(backlogService.RemoveBacklog(backlog1),is(notNullValue()));
	}

	@Ignore
	@Test
	public void testRegistSprint() {
		assertThat(backlogService.registSprint(sprint1),is(notNullValue()));
	}

	@Ignore
	@Test
	public void testSelectsprintDetailToEdit() {
		when(backlogService.selectsprintDetailToEdit(sprint1.getSprNo())).thenReturn(sprint1);
		SprintDTO sprint = backlogService.selectsprintDetailToEdit(sprint1.getSprNo());
		assertThat(sprint, is(notNullValue()));
	}

	@Ignore
	@Test
	public void testRemoveSprint() {
		assertThat(backlogService.RemoveBacklog(backlog1),is(notNullValue()));
	}
	
	@Ignore
	@Test
	public void testEditSprint() {
		fail("Not yet implemented"); // TODO
	}
	
	@Ignore
	@Test
	public void testSelectPagingSelectBacklog() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore
	public void testSelectPagingSelectSprint() {
		fail("Not yet implemented"); // TODO
	}

}
