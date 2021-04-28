package com.greedy.shortcut.alarm.model.dto;

import java.sql.Date;

public class AlertDTO implements java.io.Serializable {

	private String altNo;
	private java.sql.Date altEnrollDate;
	private String altTxt;
	private String altUri;
	private String altDelYn;
	private String altReadYn;
	private int memNo;
	
	public AlertDTO() {}

	public AlertDTO(String altNo, Date altEnrollDate, String altTxt, String altUri, String altDelYn, String altReadYn,
			int memNo) {
		super();
		this.altNo = altNo;
		this.altEnrollDate = altEnrollDate;
		this.altTxt = altTxt;
		this.altUri = altUri;
		this.altDelYn = altDelYn;
		this.altReadYn = altReadYn;
		this.memNo = memNo;
	}

	public String getAltNo() {
		return altNo;
	}

	public void setAltNo(String altNo) {
		this.altNo = altNo;
	}

	public java.sql.Date getAltEnrollDate() {
		return altEnrollDate;
	}

	public void setAltEnrollDate(java.sql.Date altEnrollDate) {
		this.altEnrollDate = altEnrollDate;
	}

	public String getAltTxt() {
		return altTxt;
	}

	public void setAltTxt(String altTxt) {
		this.altTxt = altTxt;
	}

	public String getAltUri() {
		return altUri;
	}

	public void setAltUri(String altUri) {
		this.altUri = altUri;
	}

	public String getAltDelYn() {
		return altDelYn;
	}

	public void setAltDelYn(String altDelYn) {
		this.altDelYn = altDelYn;
	}

	public String getAltReadYn() {
		return altReadYn;
	}

	public void setAltReadYn(String altReadYn) {
		this.altReadYn = altReadYn;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	@Override
	public String toString() {
		return "AlertDTO [altNo=" + altNo + ", altEnrollDate=" + altEnrollDate + ", altTxt=" + altTxt + ", altUri="
				+ altUri + ", altDelYn=" + altDelYn + ", altReadYn=" + altReadYn + ", memNo=" + memNo + "]";
	}
	
	
}
