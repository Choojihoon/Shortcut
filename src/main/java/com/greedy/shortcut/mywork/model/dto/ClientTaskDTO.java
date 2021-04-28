package com.greedy.shortcut.mywork.model.dto;

import java.sql.Date;

public class ClientTaskDTO implements java.io.Serializable {
	
	private int tkProgress;
	private int crdNo;
	private int memNo;
	private java.sql.Date tkStartDate;
	private java.sql.Date tkEndDate;
	
	public ClientTaskDTO() {}

	public ClientTaskDTO(int tkProgress, int crdNo, int memNo, Date tkStartDate, Date tkEndDate) {
		super();
		this.tkProgress = tkProgress;
		this.crdNo = crdNo;
		this.memNo = memNo;
		this.tkStartDate = tkStartDate;
		this.tkEndDate = tkEndDate;
	}

	public int getTkProgress() {
		return tkProgress;
	}

	public void setTkProgress(int tkProgress) {
		this.tkProgress = tkProgress;
	}

	public int getCrdNo() {
		return crdNo;
	}

	public void setCrdNo(int crdNo) {
		this.crdNo = crdNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public java.sql.Date getTkStartDate() {
		return tkStartDate;
	}

	public void setTkStartDate(java.sql.Date tkStartDate) {
		this.tkStartDate = tkStartDate;
	}

	public java.sql.Date getTkEndDate() {
		return tkEndDate;
	}

	public void setTkEndDate(java.sql.Date tkEndDate) {
		this.tkEndDate = tkEndDate;
	}

	@Override
	public String toString() {
		return "ClientTaskDTO [tkProgress=" + tkProgress + ", crdNo=" + crdNo + ", memNo=" + memNo + ", tkStartDate="
				+ tkStartDate + ", tkEndDate=" + tkEndDate + "]";
	}
	
	
}
