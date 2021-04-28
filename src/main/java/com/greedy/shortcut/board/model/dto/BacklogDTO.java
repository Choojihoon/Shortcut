package com.greedy.shortcut.board.model.dto;

import java.sql.Date;

public class BacklogDTO implements java.io.Serializable {

	private int rnum;
	
	private int blgNo;
	private String blgName;
	private int blgPri;
	private java.sql.Date blgEnrollDate;
	private java.sql.Date sprEndDate;
	private int pjtNo;
	private String blgDelYn;
	private String blgDemoMemo;
	private String blgRefMemo;
	
	private int startPage; 
	private int endPage;
	private int maxPage;
	
	private int reviewRegistYn;
	private int sprNo;
	
	public BacklogDTO() {}
	
	public BacklogDTO(int blgNo, String blgName, int blgPri, String blgDemoMemo, String blgRefMemo) {
		this.blgNo = blgNo;
		this.blgName = blgName;
		this.blgPri = blgPri;
		this.blgDemoMemo = blgDemoMemo;
		this.blgRefMemo = blgRefMemo;
	}

	public BacklogDTO(int rnum, int blgNo, String blgName, int blgPri, Date blgEnrollDate, Date sprEndDate, int pjtNo,
			String blgDelYn, String blgDemoMemo, String blgRefMemo, int startPage, int endPage, int maxPage,
			int reviewRegistYn, int sprNo) {
		super();
		this.rnum = rnum;
		this.blgNo = blgNo;
		this.blgName = blgName;
		this.blgPri = blgPri;
		this.blgEnrollDate = blgEnrollDate;
		this.sprEndDate = sprEndDate;
		this.pjtNo = pjtNo;
		this.blgDelYn = blgDelYn;
		this.blgDemoMemo = blgDemoMemo;
		this.blgRefMemo = blgRefMemo;
		this.startPage = startPage;
		this.endPage = endPage;
		this.maxPage = maxPage;
		this.reviewRegistYn = reviewRegistYn;
		this.sprNo = sprNo;
	}

	public int getRnum() {
		return rnum;
	}

	public int getBlgNo() {
		return blgNo;
	}

	public String getBlgName() {
		return blgName;
	}

	public int getBlgPri() {
		return blgPri;
	}

	public java.sql.Date getBlgEnrollDate() {
		return blgEnrollDate;
	}

	public java.sql.Date getSprEndDate() {
		return sprEndDate;
	}

	public int getPjtNo() {
		return pjtNo;
	}

	public String getBlgDelYn() {
		return blgDelYn;
	}

	public String getBlgDemoMemo() {
		return blgDemoMemo;
	}

	public String getBlgRefMemo() {
		return blgRefMemo;
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

	public int getReviewRegistYn() {
		return reviewRegistYn;
	}

	public int getSprNo() {
		return sprNo;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public void setBlgNo(int blgNo) {
		this.blgNo = blgNo;
	}

	public void setBlgName(String blgName) {
		this.blgName = blgName;
	}

	public void setBlgPri(int blgPri) {
		this.blgPri = blgPri;
	}

	public void setBlgEnrollDate(java.sql.Date blgEnrollDate) {
		this.blgEnrollDate = blgEnrollDate;
	}

	public void setSprEndDate(java.sql.Date sprEndDate) {
		this.sprEndDate = sprEndDate;
	}

	public void setPjtNo(int pjtNo) {
		this.pjtNo = pjtNo;
	}

	public void setBlgDelYn(String blgDelYn) {
		this.blgDelYn = blgDelYn;
	}

	public void setBlgDemoMemo(String blgDemoMemo) {
		this.blgDemoMemo = blgDemoMemo;
	}

	public void setBlgRefMemo(String blgRefMemo) {
		this.blgRefMemo = blgRefMemo;
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

	public void setReviewRegistYn(int reviewRegistYn) {
		this.reviewRegistYn = reviewRegistYn;
	}

	public void setSprNo(int sprNo) {
		this.sprNo = sprNo;
	}

	@Override
	public String toString() {
		return "BacklogDTO [rnum=" + rnum + ", blgNo=" + blgNo + ", blgName=" + blgName + ", blgPri=" + blgPri
				+ ", blgEnrollDate=" + blgEnrollDate + ", sprEndDate=" + sprEndDate + ", pjtNo=" + pjtNo + ", blgDelYn="
				+ blgDelYn + ", blgDemoMemo=" + blgDemoMemo + ", blgRefMemo=" + blgRefMemo + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", maxPage=" + maxPage + ", reviewRegistYn=" + reviewRegistYn + ", sprNo="
				+ sprNo + "]";
	}



	
}
