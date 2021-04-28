package com.greedy.shortcut.board.model.service;


import java.util.HashMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.shortcut.board.model.dao.BacklogMapper;
import com.greedy.shortcut.board.model.dto.BacklogDTO;
import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.board.model.dto.SprintDTO;
import com.greedy.shortcut.common.paging.PageInfoDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;


@Service("backlogService")
public class BacklogServiceImpl implements BacklogService {

	private BacklogMapper backlogMapper;
	
	@Autowired
	public BacklogServiceImpl(BacklogMapper backlogMapper) {
		this.backlogMapper = backlogMapper;
	}

	@Override
    public ProjectDTO selectProjectList(int pjtNo) {
		return backlogMapper.selectProject(pjtNo);
	}

	@Override
    public List<ProjectAuthorityDTO> selectMemberList(int pjtNo) {
		return backlogMapper.selectMemberList(pjtNo);
	}

		/* 아이디 유무 체크 */
	@Override
	public int idprojectcheck(String member) {
		MemberDTO memberinfo = backlogMapper.selectMemberDupCheck(member);
		if(memberinfo.getNo() == 0) {
			System.out.println("가입된 회원이 아님");
			return 0;
		}else {
			System.out.println("사용자 넘버는 ? " + memberinfo.getNo());
			return memberinfo.getNo();
		}
		
	}
	/* 프로젝트 수정  */
	@Override
	public boolean insertEditProject(ProjectDTO project) {
		
		System.out.println("프로젝트 수정213213621" + project);
		int a = backlogMapper.updateProject(project);
		System.out.println("와???");
		int b = backlogMapper.insertEditProjectHistory(project);
		/* 목표시간 미입력시 */
		/*
		 * SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM-dd"); Date day = null;
		 * try { day = dfm.parse("2999-12-31"); // jsp 에서 설정한 디폴트값 } catch
		 * (ParseException e) { e.printStackTrace(); }
		 * if(project.getProjectEndDate().equals(day)) {
		 * project.setProjectEndDate(null); }
		 */
		return a + b> 1? true : false;
	}

	/* 프로젝트회원 수정  */
	@Override
	public boolean insertEditProjectMember(ProjectDTO project, List<ProjectAuthorityDTO> projectMemberList) {
		
		System.out.println("프로젝트 수정" + project);
		int count = 0;
		int a = backlogMapper.deleteProjectMember(project);
		System.out.println("프로젝트 사이즈 : " +  projectMemberList.size());
		for(int i = 0; i < projectMemberList.size(); i++) {
			int b = backlogMapper.insertEditProjectMember(projectMemberList.get(i));
			int c = backlogMapper.insertEditProjectMemberHistory(projectMemberList.get(i));
			  count++;
		  }
		
		return count >= projectMemberList.size()? true : false;
	}
	/* 프로젝트 삭제 */
	@Override
	public boolean removeProject(ProjectDTO project) {
		
		backlogMapper.removeProject(project.getPjtNo());
		
		return  backlogMapper.insertRemoveProjectHistory(project) > 0 ? true : false;
	}
	
	/* 백로그 리스트 출력 */
	@Override
	public List<BacklogDTO> selectBacklogList(int pjtNo) {
		return backlogMapper.selectBacklogList(pjtNo);
	}
	
	/* 백로그 생성 */
	@Override
	public boolean insertBacklog(BacklogDTO backlog) {
		return backlogMapper.insertBacklog(backlog) + backlogMapper.insertBacklogHistory(backlog)  > 1 ? true : false;
	}
	
	/* 백로그 수정하기 위한 조회 */
	@Override
	public BacklogDTO selectBacklogToEdit(int blgNo, int pjtNo) {
		System.out.println("으악" + blgNo);
		System.out.println("으악1" + pjtNo);
		return backlogMapper.selectBacklogToEdit(blgNo, pjtNo);
	}

	/* 스프린트 리스트 조회 */
	@Override
	public List<SprintDTO> selectSprintList(int pjtNo) {

		return backlogMapper.selectSprintList(pjtNo);
	}
	
	/* 백로그 수정 */
	@Override
	public boolean EditBacklog(BacklogDTO backlog) {

		boolean a = backlogMapper.EditBacklog(backlog);
		boolean b = backlogMapper.insertEditBacklogHistory(backlog);
		
		return a && b ? true : false;
	}

	/* 백로그 삭제 */
	@Override
	public boolean RemoveBacklog(BacklogDTO backlogRemove) {
		
		//boolean backlogMapper.RemoveBacklog(backlogRemove);
		//int b = backlogMapper.insertRemoveBacklogHistory(backlogRemove);
		
		return backlogMapper.RemoveBacklog(backlogRemove)? true : false;
	}

	/* 스프린트 생성 */
	@Override
	public boolean registSprint(SprintDTO sprint) {
		// TODO Auto-generated method stub
		return backlogMapper.registSprint(sprint) + backlogMapper.registSprintHistory(sprint)  > 1 ? true : false;
	}

	/* 스프린트 조회 */
	@Override
	public SprintDTO selectsprintDetailToEdit(int sprNo) {
		return backlogMapper.selectsprintDetailToEdit(sprNo);
	}

	/* 스프린트 삭제 */
	@Override
	public boolean RemoveSprint(int sprNo) {

		/* 스프린트 삭제 */
		int a = backlogMapper.RemoveSprint(sprNo);
		/* 백로그번호조회 */
		int blgNo = backlogMapper.selectBacklogNo(sprNo);
		/* 백로그 삭제 */
		int c = backlogMapper.RemoveBacklogSprint(blgNo);
		int d = backlogMapper.RemoveUpdateHistorySprint(sprNo);
		
		return a  + blgNo  + c + d > 2? true : false;
	}

	/* 스프린트 수정 */
	@Override
	public boolean EditSprint(SprintDTO sprint) {

		int a = backlogMapper.EditSprint(sprint);
		System.out.println("스프린트 수정" + a);
		int b = backlogMapper.insertEditSprintHistory(sprint);
		System.out.println("스프린트 수정" + b);
		return  a + b > 1? true : false;
	}

	@Override
	public List<BacklogDTO> selectPagingSelectBacklog(int pjtNo, PageInfoDTO pageInfo) {

		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("pjtNo", pjtNo);
		pagingMap.put("startRow", pageInfo.getStartRow());
		pagingMap.put("endRow", pageInfo.getEndRow());
		
		return backlogMapper.selectPagingSelectBacklog(pagingMap);
	}

	@Override
	public List<SprintDTO> selectPagingSelectSprint(int pjtNo, PageInfoDTO pageInfo) {

		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("pjtNo", pjtNo);
		pagingMap.put("startRow", pageInfo.getStartRow());
		pagingMap.put("endRow", pageInfo.getEndRow());
		
		return backlogMapper.selectPagingSelectSprint(pagingMap);
	}

	
}
