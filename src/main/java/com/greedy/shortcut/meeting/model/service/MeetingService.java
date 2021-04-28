package com.greedy.shortcut.meeting.model.service;

import java.util.HashMap;
import java.util.List;

import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.board.model.dto.SprintDTO;
import com.greedy.shortcut.meeting.model.dto.MeetingDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public interface MeetingService {

	boolean insertMeeting(MeetingDTO meeting);

	List<MemberDTO> selectProjectMember(MemberDTO member, int pjtNo);

	boolean insertProjectMember(int memberNo, int mNo);

	MeetingDTO selectMeeting();

	List<MeetingDTO> selectMeetingList(int pjtNo);

	HashMap<String,Object> selectMeetingDetail(int meetingNo);

	int deletedMeeting(int meetingNo);

	int modifyComplete(int meetingNo, String modifyTitle, String modifyContent);

	List<SprintDTO> selectSprintNumber(int pjtNo);







}
