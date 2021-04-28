package com.greedy.shortcut.meeting.model.dto;

public class AttendListDTO {
	
	private int meetingNo;
	private int memberNo;
	
	public AttendListDTO() {}

	public AttendListDTO(int meetingNo, int memberNo) {
		super();
		this.meetingNo = meetingNo;
		this.memberNo = memberNo;
	}

	public int getMeetingNo() {
		return meetingNo;
	}

	public void setMeetingNo(int meetingNo) {
		this.meetingNo = meetingNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "AttendListDTO [meetingNo=" + meetingNo + ", memberNo=" + memberNo + "]";
	}

	
	
	
}
