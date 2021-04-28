package com.greedy.shortcut.meeting.model.dto;

import java.sql.Date;

public class MeetingHistoryDTO {

	private String meetName;
	private String meetText;
	private java.sql.Date updateDate;
	private int meetNo;
	private int meetHisNo;
	
	
	public MeetingHistoryDTO() {}


	public MeetingHistoryDTO(String meetName, String meetText, Date updateDate, int meetNo, int meetHisNo) {
		super();
		this.meetName = meetName;
		this.meetText = meetText;
		this.updateDate = updateDate;
		this.meetNo = meetNo;
		this.meetHisNo = meetHisNo;
	}


	public String getMeetName() {
		return meetName;
	}


	public void setMeetName(String meetName) {
		this.meetName = meetName;
	}


	public String getMeetText() {
		return meetText;
	}


	public void setMeetText(String meetText) {
		this.meetText = meetText;
	}


	public java.sql.Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(java.sql.Date updateDate) {
		this.updateDate = updateDate;
	}


	public int getMeetNo() {
		return meetNo;
	}


	public void setMeetNo(int meetNo) {
		this.meetNo = meetNo;
	}


	public int getMeetHisNo() {
		return meetHisNo;
	}


	public void setMeetHisNo(int meetHisNo) {
		this.meetHisNo = meetHisNo;
	}


	@Override
	public String toString() {
		return "MeetingHistoryDTO [meetName=" + meetName + ", meetText=" + meetText + ", updateDate=" + updateDate
				+ ", meetNo=" + meetNo + ", meetHisNo=" + meetHisNo + "]";
	}
	
	
	
}

