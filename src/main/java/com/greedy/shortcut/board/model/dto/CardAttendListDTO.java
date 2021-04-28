package com.greedy.shortcut.board.model.dto;

public class CardAttendListDTO {

	private int sign;         //참석여부
	private int crdNo;        //카드번호
	private int memNo;        //회원번호
	
	public CardAttendListDTO() {}

	public CardAttendListDTO(int sign, int crdNo, int memNo) {
		super();
		this.sign = sign;
		this.crdNo = crdNo;
		this.memNo = memNo;
	}

	public int getSign() {
		return sign;
	}

	public int getCrdNo() {
		return crdNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	public void setCrdNo(int crdNo) {
		this.crdNo = crdNo;
	}

	public void setMemNo(int cardAttendListDTO) {
		this.memNo = cardAttendListDTO;
	}

	@Override
	public String toString() {
		return "CardAttendListDTO [sign=" + sign + ", crdNo=" + crdNo + ", memNo=" + memNo + "]";
	}
}
