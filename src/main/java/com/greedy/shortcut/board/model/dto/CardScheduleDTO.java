package com.greedy.shortcut.board.model.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CardScheduleDTO {

	private int alert;                  //일정알림
	private String place;               //일정장소
	private int crdNo;                  // 카드번호
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss SSS", timezone = "Asia/Seoul")
	private java.sql.Date startDate;    //일정 시작일
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss SSS", timezone = "Asia/Seoul")
	private java.sql.Date endDate;      //일정 종료일
	
	private List<CardAttendListDTO> cardAttendList;   //일정참석여부
	
	public CardScheduleDTO() {}

	public CardScheduleDTO(int alert, String place, int crdNo, Date startDate, Date endDate,
			List<CardAttendListDTO> cardAttendList) {
		super();
		this.alert = alert;
		this.place = place;
		this.crdNo = crdNo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cardAttendList = cardAttendList;
	}

	public int getAlert() {
		return alert;
	}

	public String getPlace() {
		return place;
	}

	public int getCrdNo() {
		return crdNo;
	}

	public java.sql.Date getStartDate() {
		return startDate;
	}

	public java.sql.Date getEndDate() {
		return endDate;
	}

	public List<CardAttendListDTO> getCardAttendList() {
		return cardAttendList;
	}

	public void setAlert(int alert) {
		this.alert = alert;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setCrdNo(int crdNo) {
		this.crdNo = crdNo;
	}

	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}

	public void setCardAttendList(List<CardAttendListDTO> cardAttendList) {
		this.cardAttendList = cardAttendList;
	}

	@Override
	public String toString() {
		return "CardScheduleDTO [alert=" + alert + ", place=" + place + ", crdNo=" + crdNo + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", cardAttendList=" + cardAttendList + "]";
	}
}
