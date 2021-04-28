package com.greedy.shortcut.board.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.shortcut.board.model.dao.ProjectMapper;
import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

@Service("projectBoardService")
public class ProjectBoardServiceImpl implements ProjectBoardService{

	private ProjectMapper mapper;
	
	@Autowired
	public ProjectBoardServiceImpl(ProjectMapper mapper) {
		this.mapper = mapper;
	}
	
	/* 아이디 유무 체크 */
	@Override
	public int idprojectcheck(MemberDTO member) {

		MemberDTO userNo = mapper.selectMemberDupCheck(member.getEmail());
		if(userNo == null) {
			System.out.println("가입된 회원이 아님");
			return 0;
		}else {
			System.out.println("사용자 넘버는 ? " + userNo.getNo());
			return userNo.getNo();
		}
		
	}
	
	/* 프로젝트 생성 */
	@Override
	public boolean insertProject(ProjectDTO project) {
		
		/* 목표시간 미입력시 */
		/*
		 * SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM-dd"); Date day = null;
		 * try { day = dfm.parse("2999-12-31"); // jsp 에서 설정한 디폴트값 } catch
		 * (ParseException e) { e.printStackTrace(); }
		 * if(project.getProjectEndDate().equals(day)) {
		 * project.setProjectEndDate(null); }
		 */
		System.out.println("이거 좀 뽑아봐" + project);
		return mapper.insertPoject(project) + mapper.insertProjectHistory(project) > 0? true : false;
	}

	/* 프로젝트 회원 등록 */
	@Override
	public boolean insertProjectMember(ProjectDTO project, List<ProjectAuthorityDTO> projectMemberList) {
		
		int count = 0;
			  for(int i = 0; i < projectMemberList.size(); i++) {
				  mapper.insertProjectMember(projectMemberList.get(i));
				  mapper.insertProjectMemberHistory(projectMemberList.get(i));
				  count++;
			  }
		return  count >= projectMemberList.size()? true : false;
	}
	
	
	/* 프로젝트 조회 */
	@Override
	public List<ProjectDTO> selectProjectList(int no) {
		return mapper.selectProjectList(no);
	}

	


}
