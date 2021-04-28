package com.greedy.shortcut.mywork.model.dto;

import java.sql.Date;

public class MyworkResponseCardAndTaskDTO {
	
	private int tkProgress;
	private int crdNo;
	private int memNo;
	private java.sql.Date tkStartDate;
	private java.sql.Date tkEndDate;
	private String crdName;
	private int crdType;
	private int startPage; 
	private int endPage;
	private int maxPage;

	public MyworkResponseCardAndTaskDTO() {}

	public MyworkResponseCardAndTaskDTO(int tkProgress, int crdNo, int memNo, Date tkStartDate, Date tkEndDate,
			String crdName, int crdType, int startPage, int endPage, int maxPage) {
		super();
		this.tkProgress = tkProgress;
		this.crdNo = crdNo;
		this.memNo = memNo;
		this.tkStartDate = tkStartDate;
		this.tkEndDate = tkEndDate;
		this.crdName = crdName;
		this.crdType = crdType;
		this.startPage = startPage;
		this.endPage = endPage;
		this.maxPage = maxPage;
	}

	@Override
	public String toString() {
		return "MyworkResponseCardAndTaskDTO [tkProgress=" + tkProgress + ", crdNo=" + crdNo + ", memNo=" + memNo
				+ ", tkStartDate=" + tkStartDate + ", tkEndDate=" + tkEndDate + ", crdName=" + crdName + ", crdType="
				+ crdType + ", startPage=" + startPage + ", endPage=" + endPage + ", maxPage=" + maxPage + "]";
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

	public String getCrdName() {
		return crdName;
	}

	public void setCrdName(String crdName) {
		this.crdName = crdName;
	}

	public int getCrdType() {
		return crdType;
	}

	public void setCrdType(int crdType) {
		this.crdType = crdType;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	

	

	
	
	
}
