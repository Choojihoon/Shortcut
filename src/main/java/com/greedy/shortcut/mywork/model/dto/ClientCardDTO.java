package com.greedy.shortcut.mywork.model.dto;

import java.sql.Date;

public class ClientCardDTO implements java.io.Serializable {

	private int crdNo;
	private String crdName;
	private java.sql.Date crdEnrollDate;
	private String crdDelYn;
	private int brdNo;
	private int crdOrder;
	private int crdType;
	private int memNo;
	private String crdTxt;
	
	public ClientCardDTO() {}

	public ClientCardDTO(int crdNo, String crdName, Date crdEnrollDate, String crdDelYn, int brdNo, int crdOrder,
			int crdType, int memNo, String crdTxt) {
		super();
		this.crdNo = crdNo;
		this.crdName = crdName;
		this.crdEnrollDate = crdEnrollDate;
		this.crdDelYn = crdDelYn;
		this.brdNo = brdNo;
		this.crdOrder = crdOrder;
		this.crdType = crdType;
		this.memNo = memNo;
		this.crdTxt = crdTxt;
	}

	public int getCrdNo() {
		return crdNo;
	}

	public void setCrdNo(int crdNo) {
		this.crdNo = crdNo;
	}

	public String getCrdName() {
		return crdName;
	}

	public void setCrdName(String crdName) {
		this.crdName = crdName;
	}

	public java.sql.Date getCrdEnrollDate() {
		return crdEnrollDate;
	}

	public void setCrdEnrollDate(java.sql.Date crdEnrollDate) {
		this.crdEnrollDate = crdEnrollDate;
	}

	public String getCrdDelYn() {
		return crdDelYn;
	}

	public void setCrdDelYn(String crdDelYn) {
		this.crdDelYn = crdDelYn;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public int getCrdOrder() {
		return crdOrder;
	}

	public void setCrdOrder(int crdOrder) {
		this.crdOrder = crdOrder;
	}

	public int getCrdType() {
		return crdType;
	}

	public void setCrdType(int crdType) {
		this.crdType = crdType;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getCrdTxt() {
		return crdTxt;
	}

	public void setCrdTxt(String crdTxt) {
		this.crdTxt = crdTxt;
	}

	@Override
	public String toString() {
		return "ClientCardDTO [crdNo=" + crdNo + ", crdName=" + crdName + ", crdEnrollDate=" + crdEnrollDate
				+ ", crdDelYn=" + crdDelYn + ", brdNo=" + brdNo + ", crdOrder=" + crdOrder + ", crdType=" + crdType
				+ ", memNo=" + memNo + ", crdTxt=" + crdTxt + "]";
	}
	
	
}
