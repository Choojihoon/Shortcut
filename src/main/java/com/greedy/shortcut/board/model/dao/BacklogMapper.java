package com.greedy.shortcut.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.greedy.shortcut.board.model.dto.BacklogDTO;
import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.board.model.dto.SprintDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public interface BacklogMapper {

	/* 프로젝트 수정용 프로젝트 조회  */
	ProjectDTO selectProject(int pjtNo);
	
	/* 프로젝트 수정용 프로젝트멤버 조회  */
	List<ProjectAuthorityDTO> selectMemberList(int pjtNo);

	/* 프로젝트 수정용 아이디 유무  */
	MemberDTO selectMemberDupCheck(String member);

	/* 프로젝트 수정   */
	int updateProject(ProjectDTO project);

	/* 프로젝트 수정 이력 등록  */
	int insertEditProjectHistory(ProjectDTO project);

	/* 기존 회원 삭제 */
	int deleteProjectMember(ProjectDTO project);
	
	/* 프로젝트 회원 수정*/
	int insertEditProjectMember(ProjectAuthorityDTO projectAuthorityDTO);

	/* 프로젝트 회원 수정이력 등록*/
	int insertEditProjectMemberHistory(ProjectAuthorityDTO projectAuthorityDTO);
	
	/* 프로젝트 삭제 */
	boolean removeProject(int projectNo);

	/* 프로젝트 삭제 이력 등록 */
	int insertRemoveProjectHistory(ProjectDTO project);

	/* 백로그 리스트 조회 */
	List<BacklogDTO> selectBacklogList(int pjtNo);

	/* 백로그 등록 */
	int insertBacklog(BacklogDTO backlog);
	
	/* 백로그 히스토리 등록 */
	int insertBacklogHistory(BacklogDTO backlog);

	/* 백로그 수정을 위한 리스트 조회 */
	BacklogDTO selectBacklogToEdit(@Param("blgNo")int blgNo,@Param("pjtNo") int pjtNo);

	/* 백로그 수정 등록 */
	boolean EditBacklog(BacklogDTO backlog);

	/* 백로그 수정 히스토리  등록 */
	boolean insertEditBacklogHistory(BacklogDTO backlog);

	/* 백로그 삭제 */
	boolean RemoveBacklog(BacklogDTO backlogRemove);
	
	/* 백로그 삭제 히스토리 등록 */
	int insertRemoveBacklogHistory(BacklogDTO backlogRemove);
	
	/* 스프린트 리스트 조회 */
	List<SprintDTO> selectSprintList(int pjtNo);
	
	/* 스프린트 생성 */
	int registSprint(SprintDTO sprint);

	/* 스프린트 히스토리 수정 */
	int registSprintHistory(SprintDTO sprint);

	/* 스프린트 디테일 조회 */
	SprintDTO selectsprintDetailToEdit(int sprNo);

	/* 스프린트 삭제 */
	int RemoveSprint(int sprNo);

	/* 스프린트 수정 */
	int EditSprint(SprintDTO sprint);

	/* 스프린트 수정 이력 등록 */
	int insertEditSprintHistory(SprintDTO sprint);

	int RemoveUpdateHistorySprint(int sprNo);

	/* 스프린트 삭제후 백로그 삭제 */
	int RemoveBacklogSprint(int sprNo);

	/* 백로그 번호 조회 (스프린트 삭제를 위한) */
	int selectBacklogNo(int sprNo);

	List<BacklogDTO> selectPagingSelectBacklog(Map<String, Object> pagingMap);

	List<SprintDTO> selectPagingSelectSprint(Map<String, Object> pagingMap);
	
	
	


}
