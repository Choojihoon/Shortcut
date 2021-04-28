package com.greedy.shortcut.meeting.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.shortcut.board.model.dto.ProjectAndAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.board.model.dto.SprintDTO;
import com.greedy.shortcut.meeting.model.dao.MeetingMapper;
import com.greedy.shortcut.meeting.model.dto.AttendListDTO;
import com.greedy.shortcut.meeting.model.dto.MeetingDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

@Service("meetingService")
public class MeetingServiceImpl implements MeetingService{

	private MeetingMapper mapper;
	
	@Autowired
	public MeetingServiceImpl(MeetingMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public boolean insertMeeting(MeetingDTO meeting) {

		return mapper.insertMeeting(meeting) > 0? true:false;
	}


	@Override
	public MeetingDTO selectMeeting() {

		return mapper.selectMeeting();
	}


	@Override
	public boolean insertProjectMember(int memberNo, int mNo) {

		return mapper.insertProjectMember(memberNo, mNo) > 0? true:false;
	}

	@Override
	public List<MemberDTO> selectProjectMember(MemberDTO member, int pjtNo) {

		return mapper.selectProjectMember(member, pjtNo);
	}

	@Override
	public List<MeetingDTO> selectMeetingList(int pjtNo) {

		return mapper.selectMeetingList(pjtNo);
	}

	@Override
	public HashMap<String,Object> selectMeetingDetail(int meetingNo) {
		MeetingDTO meeting = mapper.selectMeetingDetail(meetingNo);
		
		List<MemberDTO> memberList = mapper.selectMeetingDetailMember(meetingNo);
		
		List<SprintDTO> sprintName = mapper.selectSprintName(meetingNo);
		
		HashMap<String,Object> MeetingDetail = new HashMap<String,Object>();
		
		MeetingDetail.put("meeting", meeting);
		MeetingDetail.put("memberList", memberList);
		MeetingDetail.put("sprintName", sprintName);
		
		
	
		return MeetingDetail;
	}

	@Override
	public int deletedMeeting(int meetingNo) {

		return mapper.deletedMeeting(meetingNo);
	}

	@Override
	public int modifyComplete(int meetingNo, String modifyTitle, String modifyContent) {

		return mapper.modifyComplete(meetingNo, modifyTitle, modifyContent);
	}

	@Override
	public List<SprintDTO> selectSprintNumber(int pjtNo) {

		return mapper.selectSprintNumber(pjtNo);
	}


	
}



	
	


	

