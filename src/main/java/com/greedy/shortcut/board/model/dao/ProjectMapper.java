package com.greedy.shortcut.board.model.dao;

import java.util.List;

import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public interface ProjectMapper {
	/* 아이디 유무 체크 */
	MemberDTO selectMemberDupCheck(String inputUserId);
	
	/* 프로젝트 생성 */
	int insertPoject(ProjectDTO project);
	
	/* 프로젝트 생성 이력 등록 (프로젝트 생성시)*/
	int insertProjectHistory(ProjectDTO project);
	
	/* 프로젝트 번호 조회(프로젝트 생성시) */
	ProjectDTO selectProjectNum(ProjectDTO project);
	
	/* 프로젝트 멤버 등록 (프로젝트 생성시) */
	int insertProjectMember(ProjectAuthorityDTO projectAuthorityDTO);

	/* 프로젝트 멤버 조회 */
	List<ProjectDTO> selectProjectList(int no);

	/* 프로젝트 멤버 이력 등록 (프로젝트 생성시)  */
	int insertProjectMemberHistory(ProjectAuthorityDTO projectAuthorityDTO);

}
