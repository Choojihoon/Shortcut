package com.greedy.shortcut.mywork.model.dto;

import java.sql.Date;

public class ClientSprintDTO implements java.io.Serializable {

	private int sprNo;
	private String sprName;
	private java.sql.Date sprStartDate;
	private java.sql.Date sprEndDate;
	private String sprGoal;
	private String sprDelYn;
	private int blgNo;
	
	public ClientSprintDTO() {}

	public ClientSprintDTO(int sprNo, String sprName, Date sprStartDate, Date sprEndDate, String sprGoal,
			String sprDelYn, int blgNo) {
		super();
		this.sprNo = sprNo;
		this.sprName = sprName;
		this.sprStartDate = sprStartDate;
		this.sprEndDate = sprEndDate;
		this.sprGoal = sprGoal;
		this.sprDelYn = sprDelYn;
		this.blgNo = blgNo;
	}

	public int getSprNo() {
		return sprNo;
	}

	public void setSprNo(int sprNo) {
		this.sprNo = sprNo;
	}

	public String getSprName() {
		return sprName;
	}

	public void setSprName(String sprName) {
		this.sprName = sprName;
	}

	public java.sql.Date getSprStartDate() {
		return sprStartDate;
	}

	public void setSprStartDate(java.sql.Date sprStartDate) {
		this.sprStartDate = sprStartDate;
	}

	public java.sql.Date getSprEndDate() {
		return sprEndDate;
	}

	public void setSprEndDate(java.sql.Date sprEndDate) {
		this.sprEndDate = sprEndDate;
	}

	public String getSprGoal() {
		return sprGoal;
	}

	public void setSprGoal(String sprGoal) {
		this.sprGoal = sprGoal;
	}

	public String getSprDelYn() {
		return sprDelYn;
	}

	public void setSprDelYn(String sprDelYn) {
		this.sprDelYn = sprDelYn;
	}

	public int getBlgNo() {
		return blgNo;
	}

	public void setBlgNo(int blgNo) {
		this.blgNo = blgNo;
	}

	@Override
	public String toString() {
		return "ClientSprintDTO [sprNo=" + sprNo + ", sprName=" + sprName + ", sprStartDate=" + sprStartDate
				+ ", sprEndDate=" + sprEndDate + ", sprGoal=" + sprGoal + ", sprDelYn=" + sprDelYn + ", blgNo=" + blgNo
				+ "]";
	}
	
	
}
