package com.greedy.shortcut.board.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CardTaskDTO {

	private int progress;                  //업무진척도
	private int crdNo;                     //카드번호
	private int memNo;					   //담당자
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss SSS", timezone = "Asia/Seoul")
	private java.sql.Date startDate;       //업무시작일
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss SSS", timezone = "Asia/Seoul")
	private java.sql.Date endDate;         //업무종료일
	
	public CardTaskDTO() {}

	public CardTaskDTO(int progress, int crdNo, int memNo, Date startDate, Date endDate) {
		super();
		this.progress = progress;
		this.crdNo = crdNo;
		this.memNo = memNo;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getProgress() {
		return progress;
	}

	public int getCrdNo() {
		return crdNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public java.sql.Date getStartDate() {
		return startDate;
	}

	public java.sql.Date getEndDate() {
		return endDate;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public void setCrdNo(int crdNo) {
		this.crdNo = crdNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "CardTaskDTO [progress=" + progress + ", crdNo=" + crdNo + ", memNo=" + memNo + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
}
