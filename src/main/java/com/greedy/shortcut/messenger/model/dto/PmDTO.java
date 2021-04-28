package com.greedy.shortcut.messenger.model.dto;

	public class PmDTO {

	private int pjtNo;
	private int memNo;
	private String pjtName;
	private String memName;

	public PmDTO() {}

	public PmDTO(int pjtNo, int memNo, String pjtName, String memName) {
		super();
		this.pjtNo = pjtNo;
		this.memNo = memNo;
		this.pjtName = pjtName;
		this.memName = memName;
	}

	public int getPjtNo() {
		return pjtNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public String getPjtName() {
		return pjtName;
	}

	public String getMemName() {
		return memName;
	}

	public void setPjtNo(int pjtNo) {
		this.pjtNo = pjtNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public void setPjtName(String pjtName) {
		this.pjtName = pjtName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	@Override
	public String toString() {
		return "PmDTO [pjtNo=" + pjtNo + ", memNo=" + memNo + ", pjtName=" + pjtName + ", memName=" + memName + "]";
	}
}
