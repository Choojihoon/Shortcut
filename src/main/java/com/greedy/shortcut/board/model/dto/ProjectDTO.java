package com.greedy.shortcut.board.model.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public class ProjectDTO {

	private int pjtNo;
	private String projectName;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private java.sql.Date projectStartDate;
	private String projectDelYN;
	private int memberNo;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private java.sql.Date projectEndDate;
	private String projectColor;
	
	private List<ProjectAuthorityDTO> pjtAuthorityDTO;
	private List<MemberDTO> memberDTO;
	
	public ProjectDTO() {}

	public ProjectDTO(int pjtNo, String projectName, Date projectStartDate, String projectDelYN, int memberNo,
			Date projectEndDate, String projectColor, List<ProjectAuthorityDTO> pjtAuthorityDTO,
			List<MemberDTO> memberDTO) {
		super();
		this.pjtNo = pjtNo;
		this.projectName = projectName;
		this.projectStartDate = projectStartDate;
		this.projectDelYN = projectDelYN;
		this.memberNo = memberNo;
		this.projectEndDate = projectEndDate;
		this.projectColor = projectColor;
		this.pjtAuthorityDTO = pjtAuthorityDTO;
		this.memberDTO = memberDTO;
	}

	public int getPjtNo() {
		return pjtNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public java.sql.Date getProjectStartDate() {
		return projectStartDate;
	}

	public String getProjectDelYN() {
		return projectDelYN;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public java.sql.Date getProjectEndDate() {
		return projectEndDate;
	}

	public String getProjectColor() {
		return projectColor;
	}

	public List<ProjectAuthorityDTO> getPjtAuthorityDTO() {
		return pjtAuthorityDTO;
	}

	public List<MemberDTO> getMemberDTO() {
		return memberDTO;
	}

	public void setPjtNo(int pjtNo) {
		this.pjtNo = pjtNo;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectStartDate(java.sql.Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public void setProjectDelYN(String projectDelYN) {
		this.projectDelYN = projectDelYN;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public void setProjectEndDate(java.sql.Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public void setProjectColor(String projectColor) {
		this.projectColor = projectColor;
	}

	public void setPjtAuthorityDTO(List<ProjectAuthorityDTO> pjtAuthorityDTO) {
		this.pjtAuthorityDTO = pjtAuthorityDTO;
	}

	public void setMemberDTO(List<MemberDTO> memberDTO) {
		this.memberDTO = memberDTO;
	}

	@Override
	public String toString() {
		return "ProjectDTO [pjtNo=" + pjtNo + ", projectName=" + projectName + ", projectStartDate=" + projectStartDate
				+ ", projectDelYN=" + projectDelYN + ", memberNo=" + memberNo + ", projectEndDate=" + projectEndDate
				+ ", projectColor=" + projectColor + ", pjtAuthorityDTO=" + pjtAuthorityDTO + ", memberDTO=" + memberDTO
				+ "]";
	}
}
