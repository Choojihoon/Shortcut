package com.greedy.shortcut.board.model.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public class CardDTO {

	private int no;
	private String title;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss SSS", timezone = "Asia/Seoul")
	private java.sql.Date EnrollDate;
	private String delNo;
	private int brdNo;
	private int order;
	private int type;
	private int memNo;
	private String txt;
	private List<Integer> memberList;
	private int member; //담당자

	private List<CardScheduleDTO> cardScheduleDTO;
	private List<CardTaskDTO> cardTaskDTO;
	private MemberDTO cardMemberList;
	
	public CardDTO() {}

	public CardDTO(int no, String title, Date enrollDate, String delNo, int brdNo, int order, int type, int memNo,
			String txt, List<Integer> memberList, int member, List<CardScheduleDTO> cardScheduleDTO,
			List<CardTaskDTO> cardTaskDTO, MemberDTO cardMemberList) {
		super();
		this.no = no;
		this.title = title;
		EnrollDate = enrollDate;
		this.delNo = delNo;
		this.brdNo = brdNo;
		this.order = order;
		this.type = type;
		this.memNo = memNo;
		this.txt = txt;
		this.memberList = memberList;
		this.member = member;
		this.cardScheduleDTO = cardScheduleDTO;
		this.cardTaskDTO = cardTaskDTO;
		this.cardMemberList = cardMemberList;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public java.sql.Date getEnrollDate() {
		return EnrollDate;
	}

	public void setEnrollDate(java.sql.Date enrollDate) {
		EnrollDate = enrollDate;
	}

	public String getDelNo() {
		return delNo;
	}

	public void setDelNo(String delNo) {
		this.delNo = delNo;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public List<Integer> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Integer> memberList) {
		this.memberList = memberList;
	}

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}

	public List<CardScheduleDTO> getCardScheduleDTO() {
		return cardScheduleDTO;
	}

	public void setCardScheduleDTO(List<CardScheduleDTO> cardScheduleDTO) {
		this.cardScheduleDTO = cardScheduleDTO;
	}

	public List<CardTaskDTO> getCardTaskDTO() {
		return cardTaskDTO;
	}

	public void setCardTaskDTO(List<CardTaskDTO> cardTaskDTO) {
		this.cardTaskDTO = cardTaskDTO;
	}

	public MemberDTO getCardMemberList() {
		return cardMemberList;
	}

	public void setCardMemberList(MemberDTO cardMemberList) {
		this.cardMemberList = cardMemberList;
	}

	@Override
	public String toString() {
		return "CardDTO [no=" + no + ", title=" + title + ", EnrollDate=" + EnrollDate + ", delNo=" + delNo + ", brdNo="
				+ brdNo + ", order=" + order + ", type=" + type + ", memNo=" + memNo + ", txt=" + txt + ", memberList="
				+ memberList + ", member=" + member + ", cardScheduleDTO=" + cardScheduleDTO + ", cardTaskDTO="
				+ cardTaskDTO + ", cardMemberList=" + cardMemberList + "]";
	}

	
}
