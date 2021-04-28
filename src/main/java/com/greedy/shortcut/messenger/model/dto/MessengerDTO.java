package com.greedy.shortcut.messenger.model.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public class MessengerDTO {

	private int type;                 //구분
	private int no;                   //쪽지번호
	private int pjtNo;                //프로젝트번호
	private String msgFrom;           //보낸사람
	private String msgTo;             //받은사람
	private String txt;               //내용
	private String del;               //삭제여부
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss SSS", timezone = "Asia/Seoul")
	private java.sql.Date date;       //생성날짜
	
	private String memName;           //회원이름
	private String pjtName;           //프로젝트명
	private List<ProjectDTO> pjtDTO;
	private List<MemberDTO> memDTO;
	
	public MessengerDTO() {}

	public MessengerDTO(int type, int no, int pjtNo, String msgFrom, String msgTo, String txt, String del, Date date,
			String memName, String pjtName, List<ProjectDTO> pjtDTO, List<MemberDTO> memDTO) {
		super();
		this.type = type;
		this.no = no;
		this.pjtNo = pjtNo;
		this.msgFrom = msgFrom;
		this.msgTo = msgTo;
		this.txt = txt;
		this.del = del;
		this.date = date;
		this.memName = memName;
		this.pjtName = pjtName;
		this.pjtDTO = pjtDTO;
		this.memDTO = memDTO;
	}

	public int getType() {
		return type;
	}

	public int getNo() {
		return no;
	}

	public int getPjtNo() {
		return pjtNo;
	}

	public String getMsgFrom() {
		return msgFrom;
	}

	public String getMsgTo() {
		return msgTo;
	}

	public String getTxt() {
		return txt;
	}

	public String getDel() {
		return del;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public String getMemName() {
		return memName;
	}

	public String getPjtName() {
		return pjtName;
	}

	public List<ProjectDTO> getPjtDTO() {
		return pjtDTO;
	}

	public List<MemberDTO> getMemDTO() {
		return memDTO;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setPjtNo(int pjtNo) {
		this.pjtNo = pjtNo;
	}

	public void setMsgFrom(String msgFrom) {
		this.msgFrom = msgFrom;
	}

	public void setMsgTo(String msgTo) {
		this.msgTo = msgTo;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public void setPjtName(String pjtName) {
		this.pjtName = pjtName;
	}

	public void setPjtDTO(List<ProjectDTO> pjtDTO) {
		this.pjtDTO = pjtDTO;
	}

	public void setMemDTO(List<MemberDTO> memDTO) {
		this.memDTO = memDTO;
	}

	@Override
	public String toString() {
		return "MessengerDTO [type=" + type + ", no=" + no + ", pjtNo=" + pjtNo + ", msgFrom=" + msgFrom + ", msgTo="
				+ msgTo + ", txt=" + txt + ", del=" + del + ", date=" + date + ", memName=" + memName + ", pjtName="
				+ pjtName + ", pjtDTO=" + pjtDTO + ", memDTO=" + memDTO + "]";
	}
}
