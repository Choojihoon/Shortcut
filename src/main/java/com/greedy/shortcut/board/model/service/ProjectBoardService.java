package com.greedy.shortcut.board.model.service;

import java.util.List;

import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public interface ProjectBoardService {
	/* 아이디 유무 체크 */
	int idprojectcheck(MemberDTO member);
	/* 프로젝트 생성 */
	boolean insertProject(ProjectDTO project);
	/* 프로젝트 맴버 등록 */
	boolean insertProjectMember(ProjectDTO project, List<ProjectAuthorityDTO> projectMemberList);
	/* 프로젝트 이력 등록 */
	//boolean insertProjectHistory(ProjectDTO project);
	/* 프로젝트 멤버 이력 등록 */
	//boolean insertProjectMemberHistory(ProjectDTO project, List<ProjectAuthorityDTO> projectMemberList);
	/* 프로젝트 리스트 출력 */
	List<ProjectDTO> selectProjectList(int no);



}
