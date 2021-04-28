package com.greedy.shortcut.mywork.model.dto;

import java.sql.Date;

public class MyworkResponseCardAndScheduleDTO {
	
	private int tkProgress;
	private int crdNo;
	private int memNo;
	private int schAlert;
	private java.sql.Date schStartDate;
	private java.sql.Date schEndDate;
	private String crdName;
	private String schPlace;
	private int crdType;
	private int startPage; 
	private int endPage;
	private int maxPage;
	
	public MyworkResponseCardAndScheduleDTO() {}
	
	public MyworkResponseCardAndScheduleDTO(int tkProgress, int crdNo, int memNo, int schAlert, Date schStartDate,
			Date schEndDate, String crdName, String schPlace, int crdType, int startPage, int endPage, int maxPage) {
		super();
		this.tkProgress = tkProgress;
		this.crdNo = crdNo;
		this.memNo = memNo;
		this.schAlert = schAlert;
		this.schStartDate = schStartDate;
		this.schEndDate = schEndDate;
		this.crdName = crdName;
		this.schPlace = schPlace;
		this.crdType = crdType;
		this.startPage = startPage;
		this.endPage = endPage;
		this.maxPage = maxPage;
	}
	@Override
	public String toString() {
		return "MyworkResponseCardAndScheduleDTO [tkProgress=" + tkProgress + ", crdNo=" + crdNo + ", memNo=" + memNo
				+ ", schAlert=" + schAlert + ", schStartDate=" + schStartDate + ", schEndDate=" + schEndDate
				+ ", crdName=" + crdName + ", schPlace=" + schPlace + ", crdType=" + crdType + ", startPage="
				+ startPage + ", endPage=" + endPage + ", maxPage=" + maxPage + "]";
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
	public int getSchAlert() {
		return schAlert;
	}
	public void setSchAlert(int schAlert) {
		this.schAlert = schAlert;
	}
	public java.sql.Date getSchStartDate() {
		return schStartDate;
	}
	public void setSchStartDate(java.sql.Date schStartDate) {
		this.schStartDate = schStartDate;
	}
	public java.sql.Date getSchEndDate() {
		return schEndDate;
	}
	public void setSchEndDate(java.sql.Date schEndDate) {
		this.schEndDate = schEndDate;
	}
	public String getCrdName() {
		return crdName;
	}
	public void setCrdName(String crdName) {
		this.crdName = crdName;
	}
	public String getSchPlace() {
		return schPlace;
	}
	public void setSchPlace(String schPlace) {
		this.schPlace = schPlace;
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
