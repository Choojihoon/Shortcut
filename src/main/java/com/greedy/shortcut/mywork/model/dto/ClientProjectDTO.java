package com.greedy.shortcut.mywork.model.dto;

import java.sql.Date;

public class ClientProjectDTO implements java.io.Serializable {

	private int pjtNo;
	private String pjtName;
	private java.sql.Date pjtStartDate;
	private String pjtDelYn;
	private String memNo;
	private java.sql.Date pjtEndDate;
	private String pjtColor;
	
	public ClientProjectDTO() {}

	public ClientProjectDTO(int pjtNo, String pjtName, Date pjtStartDate, String pjtDelYn, String memNo,
			Date pjtEndDate, String pjtColor) {
		super();
		this.pjtNo = pjtNo;
		this.pjtName = pjtName;
		this.pjtStartDate = pjtStartDate;
		this.pjtDelYn = pjtDelYn;
		this.memNo = memNo;
		this.pjtEndDate = pjtEndDate;
		this.pjtColor = pjtColor;
	}

	public int getPjtNo() {
		return pjtNo;
	}

	public void setPjtNo(int pjtNo) {
		this.pjtNo = pjtNo;
	}

	public String getPjtName() {
		return pjtName;
	}

	public void setPjtName(String pjtName) {
		this.pjtName = pjtName;
	}

	public java.sql.Date getPjtStartDate() {
		return pjtStartDate;
	}

	public void setPjtStartDate(java.sql.Date pjtStartDate) {
		this.pjtStartDate = pjtStartDate;
	}

	public String getPjtDelYn() {
		return pjtDelYn;
	}

	public void setPjtDelYn(String pjtDelYn) {
		this.pjtDelYn = pjtDelYn;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public java.sql.Date getPjtEndDate() {
		return pjtEndDate;
	}

	public void setPjtEndDate(java.sql.Date pjtEndDate) {
		this.pjtEndDate = pjtEndDate;
	}

	public String getPjtColor() {
		return pjtColor;
	}

	public void setPjtColor(String pjtColor) {
		this.pjtColor = pjtColor;
	}

	@Override
	public String toString() {
		return "ClientProjectDTO [pjtNo=" + pjtNo + ", pjtName=" + pjtName + ", pjtStartDate=" + pjtStartDate
				+ ", pjtDelYn=" + pjtDelYn + ", memNo=" + memNo + ", pjtEndDate=" + pjtEndDate + ", pjtColor="
				+ pjtColor + "]";
	}
	
	
}
