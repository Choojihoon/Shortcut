package com.greedy.shortcut.mywork.model.dto;

import java.sql.Date;

public class ClientBacklogDTO implements java.io.Serializable {
	
	private int blgNo;
	private String blgName;
	private int blgPri;
	private java.sql.Date blgEnrollDate;
	private int pjtNo;
	private String blgDelYn;
	private String blgDemoMemo;
	private String blgRefMemo;
	
	public ClientBacklogDTO() {}

	public ClientBacklogDTO(int blgNo, String blgName, int blgPri, Date blgEnrollDate, int pjtNo, String blgDelYn,
			String blgDemoMemo, String blgRefMemo) {
		super();
		this.blgNo = blgNo;
		this.blgName = blgName;
		this.blgPri = blgPri;
		this.blgEnrollDate = blgEnrollDate;
		this.pjtNo = pjtNo;
		this.blgDelYn = blgDelYn;
		this.blgDemoMemo = blgDemoMemo;
		this.blgRefMemo = blgRefMemo;
	}

	public int getBlgNo() {
		return blgNo;
	}

	public void setBlgNo(int blgNo) {
		this.blgNo = blgNo;
	}

	public String getBlgName() {
		return blgName;
	}

	public void setBlgName(String blgName) {
		this.blgName = blgName;
	}

	public int getBlgPri() {
		return blgPri;
	}

	public void setBlgPri(int blgPri) {
		this.blgPri = blgPri;
	}

	public java.sql.Date getBlgEnrollDate() {
		return blgEnrollDate;
	}

	public void setBlgEnrollDate(java.sql.Date blgEnrollDate) {
		this.blgEnrollDate = blgEnrollDate;
	}

	public int getPjtNo() {
		return pjtNo;
	}

	public void setPjtNo(int pjtNo) {
		this.pjtNo = pjtNo;
	}

	public String getBlgDelYn() {
		return blgDelYn;
	}

	public void setBlgDelYn(String blgDelYn) {
		this.blgDelYn = blgDelYn;
	}

	public String getBlgDemoMemo() {
		return blgDemoMemo;
	}

	public void setBlgDemoMemo(String blgDemoMemo) {
		this.blgDemoMemo = blgDemoMemo;
	}

	public String getBlgRefMemo() {
		return blgRefMemo;
	}

	public void setBlgRefMemo(String blgRefMemo) {
		this.blgRefMemo = blgRefMemo;
	}

	@Override
	public String toString() {
		return "ClientBacklogDTO [blgNo=" + blgNo + ", blgName=" + blgName + ", blgPri=" + blgPri + ", blgEnrollDate="
				+ blgEnrollDate + ", pjtNo=" + pjtNo + ", blgDelYn=" + blgDelYn + ", blgDemoMemo=" + blgDemoMemo
				+ ", blgRefMemo=" + blgRefMemo + "]";
	}
	
	
}
