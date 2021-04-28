package com.greedy.shortcut.board.model.service;

import java.util.List;

import com.greedy.shortcut.board.model.dto.BacklogDTO;
import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.board.model.dto.SprintDTO;
import com.greedy.shortcut.common.paging.PageInfoDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;


public interface BacklogService {

	ProjectDTO selectProjectList(int pjtNo);

	List<ProjectAuthorityDTO> selectMemberList(int pjtNo);

	int idprojectcheck(String string);

	boolean insertEditProject(ProjectDTO project);

	boolean insertEditProjectMember(ProjectDTO project, List<ProjectAuthorityDTO> projectMemberList);

	boolean removeProject(ProjectDTO project);

	List<BacklogDTO> selectBacklogList(int pjtNo);
	
	/* 백로그 생성 */
	boolean insertBacklog(BacklogDTO backlog);

	/* 백로그 조회 */
	BacklogDTO selectBacklogToEdit(int blgNo, int pjtNo);

	/* 스프린트 리스트 조회 */
	List<SprintDTO> selectSprintList(int pjtNo);
	
	/* 백로그 수정 */
	boolean EditBacklog(BacklogDTO backlog);

	/* 백로그 삭제 */
	boolean RemoveBacklog(BacklogDTO backlogRemove);

	/* 스프린트 생성 */
	boolean registSprint(SprintDTO sprint);
	
	/* 스프린트 조회 */
	SprintDTO selectsprintDetailToEdit(int sprNo);

	/* 스프린트 삭제 */
	boolean RemoveSprint(int sprNo);

	/* 스프린트 수정 */
	boolean EditSprint(SprintDTO sprint);

	List<BacklogDTO> selectPagingSelectBacklog(int pjtNo, PageInfoDTO pageInfo);

	List<SprintDTO> selectPagingSelectSprint(int pjtNo, PageInfoDTO pageInfo);
	
	

}
