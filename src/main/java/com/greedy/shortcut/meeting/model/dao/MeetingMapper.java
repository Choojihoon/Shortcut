package com.greedy.shortcut.meeting.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.greedy.shortcut.board.model.dto.ProjectAndAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.board.model.dto.SprintDTO;
import com.greedy.shortcut.meeting.model.dto.MeetingDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

@Mapper
public interface MeetingMapper {

	int insertMeeting(MeetingDTO meeting);

	ProjectAndAuthorityDTO projectMemberCheck(String name);

	List<MemberDTO> selectProjectMember(@Param("member") MemberDTO member, @Param("pjtNo") int pjtNo);

	int insertProjectMember(@Param("memberNo") int memberNo, @Param("meetingNo") int mNo);

	MeetingDTO selectMeeting();

	List<MeetingDTO> selectMeetingList(int pjtNo);

	MeetingDTO selectMeetingDetail(int meetingNo);

	List<MemberDTO> selectMeetingDetailMember(int meetingNo);

	int deletedMeeting(int meetingNo);

	int modifyComplete(@Param("meetingNo") int meetingNo, @Param("modifyTitle") String modifyTitle, @Param("modifyContent") String modifyContent);

	List<SprintDTO> selectSprintNumber(int pjtNo);

	List<SprintDTO> selectSprintName(int meetingNo);

	



	


}
