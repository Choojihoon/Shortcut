package com.greedy.shortcut.board.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BoardDTO implements java.io.Serializable {

	private int brdNo;
	private String brdName;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss SSS", timezone = "Asia/Seoul")
	private java.sql.Date date;
	private int sprNo;
	private String del;
	private int brdOrder;
	
	public BoardDTO() {}

	public BoardDTO(int brdNo, String brdName, Date date, int sprNo, String del, int brdOrder) {
		super();
		this.brdNo = brdNo;
		this.brdName = brdName;
		this.date = date;
		this.sprNo = sprNo;
		this.del = del;
		this.brdOrder = brdOrder;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public String getBrdName() {
		return brdName;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public int getSprNo() {
		return sprNo;
	}

	public String getDel() {
		return del;
	}

	public int getBrdOrder() {
		return brdOrder;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public void setBrdName(String brdName) {
		this.brdName = brdName;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public void setSprNo(int sprNo) {
		this.sprNo = sprNo;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public void setBrdOrder(int brdOrder) {
		this.brdOrder = brdOrder;
	}

	@Override
	public String toString() {
		return "BoardDTO [brdNo=" + brdNo + ", brdName=" + brdName + ", date=" + date + ", sprNo=" + sprNo + ", del="
				+ del + ", brdOrder=" + brdOrder + "]";
	}
}
