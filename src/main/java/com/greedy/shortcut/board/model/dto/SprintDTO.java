package com.greedy.shortcut.board.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SprintDTO {
	
	
	private int rnum;
	
	private int sprNo;
	private String sprName;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date sprStardDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date sprEndDate;
	private String sprGoal;
	private String sprDelYn;
	private int sprBlgNo;
	
	
	private int startPage; 
	private int endPage;
	private int maxPage;
	
	
	
	public SprintDTO() {}

	public SprintDTO(int sprNo, String sprName, Date sprStardDate, Date sprEndDate, String sprGoal, int sprBlgNo) {
		super();
		this.sprNo = sprNo;
		this.sprName = sprName;
		this.sprStardDate = sprStardDate;
		this.sprEndDate = sprEndDate;
		this.sprGoal = sprGoal;
		this.sprBlgNo = sprBlgNo;
	}

	public SprintDTO(int rnum, int sprNo, String sprName, Date sprStardDate, Date sprEndDate, String sprGoal,
			String sprDelYn, int sprBlgNo, int startPage, int endPage, int maxPage) {
		super();
		this.rnum = rnum;
		this.sprNo = sprNo;
		this.sprName = sprName;
		this.sprStardDate = sprStardDate;
		this.sprEndDate = sprEndDate;
		this.sprGoal = sprGoal;
		this.sprDelYn = sprDelYn;
		this.sprBlgNo = sprBlgNo;
		this.startPage = startPage;
		this.endPage = endPage;
		this.maxPage = maxPage;
	}



	public int getRnum() {
		return rnum;
	}



	public int getSprNo() {
		return sprNo;
	}



	public String getSprName() {
		return sprName;
	}



	public Date getSprStardDate() {
		return sprStardDate;
	}



	public Date getSprEndDate() {
		return sprEndDate;
	}



	public String getSprGoal() {
		return sprGoal;
	}



	public String getSprDelYn() {
		return sprDelYn;
	}



	public int getSprBlgNo() {
		return sprBlgNo;
	}



	public int getStartPage() {
		return startPage;
	}



	public int getEndPage() {
		return endPage;
	}



	public int getMaxPage() {
		return maxPage;
	}



	public void setRnum(int rnum) {
		this.rnum = rnum;
	}



	public void setSprNo(int sprNo) {
		this.sprNo = sprNo;
	}



	public void setSprName(String sprName) {
		this.sprName = sprName;
	}



	public void setSprStardDate(Date sprStardDate) {
		this.sprStardDate = sprStardDate;
	}



	public void setSprEndDate(Date sprEndDate) {
		this.sprEndDate = sprEndDate;
	}



	public void setSprGoal(String sprGoal) {
		this.sprGoal = sprGoal;
	}



	public void setSprDelYn(String sprDelYn) {
		this.sprDelYn = sprDelYn;
	}



	public void setSprBlgNo(int sprBlgNo) {
		this.sprBlgNo = sprBlgNo;
	}



	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}



	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}



	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}



	@Override
	public String toString() {
		return "SprintDTO [rnum=" + rnum + ", sprNo=" + sprNo + ", sprName=" + sprName + ", sprStardDate="
				+ sprStardDate + ", sprEndDate=" + sprEndDate + ", sprGoal=" + sprGoal + ", sprDelYn=" + sprDelYn
				+ ", sprBlgNo=" + sprBlgNo + ", startPage=" + startPage + ", endPage=" + endPage + ", maxPage="
				+ maxPage + "]";
	}

	
	
}