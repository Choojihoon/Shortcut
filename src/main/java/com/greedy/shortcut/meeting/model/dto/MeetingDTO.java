package com.greedy.shortcut.meeting.model.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public class MeetingDTO {

	private Integer meetingNo;
	private String meetingName;
	private String meetingText;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private java.sql.Date enrollDate;
	private String status;
	private int sprintNo;
	private int pjtNo;
	private List<MemberDTO> memberList;
	
	public MeetingDTO() {}

	public MeetingDTO(Integer meetingNo, String meetingName, String meetingText, Date enrollDate, String status,
			int sprintNo, int pjtNo, List<MemberDTO> memberList) {
		super();
		this.meetingNo = meetingNo;
		this.meetingName = meetingName;
		this.meetingText = meetingText;
		this.enrollDate = enrollDate;
		this.status = status;
		this.sprintNo = sprintNo;
		this.pjtNo = pjtNo;
		this.memberList = memberList;
	}

	@Override
	public String toString() {
		return "MeetingDTO [meetingNo=" + meetingNo + ", meetingName=" + meetingName + ", meetingText=" + meetingText
				+ ", enrollDate=" + enrollDate + ", status=" + status + ", sprintNo=" + sprintNo + ", pjtNo=" + pjtNo
				+ ", memberList=" + memberList + "]";
	}

	public Integer getMeetingNo() {
		return meetingNo;
	}

	public void setMeetingNo(Integer meetingNo) {
		this.meetingNo = meetingNo;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public String getMeetingText() {
		return meetingText;
	}

	public void setMeetingText(String meetingText) {
		this.meetingText = meetingText;
	}

	public java.sql.Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(java.sql.Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSprintNo() {
		return sprintNo;
	}

	public void setSprintNo(int sprintNo) {
		this.sprintNo = sprintNo;
	}

	public int getPjtNo() {
		return pjtNo;
	}

	public void setPjtNo(int pjtNo) {
		this.pjtNo = pjtNo;
	}

	public List<MemberDTO> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<MemberDTO> memberList) {
		this.memberList = memberList;
	}

	
	
	
}
