package com.greedy.shortcut.mywork.model.dto;

import java.sql.Date;

public class ClientBoardDTO implements java.io.Serializable {

	private int brdNo;
	private String brdName;
	private java.sql.Date brdEnrollDate;
	private int sprNo;
	private String brdDelYn;
	private int brdOrder;
	
	public ClientBoardDTO() {}

	public ClientBoardDTO(int brdNo, String brdName, Date brdEnrollDate, int sprNo, String brdDelYn, int brdOrder) {
		super();
		this.brdNo = brdNo;
		this.brdName = brdName;
		this.brdEnrollDate = brdEnrollDate;
		this.sprNo = sprNo;
		this.brdDelYn = brdDelYn;
		this.brdOrder = brdOrder;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getBrdName() {
		return brdName;
	}

	public void setBrdName(String brdName) {
		this.brdName = brdName;
	}

	public java.sql.Date getBrdEnrollDate() {
		return brdEnrollDate;
	}

	public void setBrdEnrollDate(java.sql.Date brdEnrollDate) {
		this.brdEnrollDate = brdEnrollDate;
	}

	public int getSprNo() {
		return sprNo;
	}

	public void setSprNo(int sprNo) {
		this.sprNo = sprNo;
	}

	public String getBrdDelYn() {
		return brdDelYn;
	}

	public void setBrdDelYn(String brdDelYn) {
		this.brdDelYn = brdDelYn;
	}

	public int getBrdOrder() {
		return brdOrder;
	}

	public void setBrdOrder(int brdOrder) {
		this.brdOrder = brdOrder;
	}

	@Override
	public String toString() {
		return "ClientBoardDTO [brdNo=" + brdNo + ", brdName=" + brdName + ", brdEnrollDate=" + brdEnrollDate
				+ ", sprNo=" + sprNo + ", brdDelYn=" + brdDelYn + ", brdOrder=" + brdOrder + "]";
	}
	
	
}
