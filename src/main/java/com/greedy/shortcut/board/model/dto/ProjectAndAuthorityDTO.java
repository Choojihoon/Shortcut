package com.greedy.shortcut.board.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjectAndAuthorityDTO {

	
	private int pjtNo;
	private String projectName;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss SSS", timezone = "Asia/Seoul")
	private java.sql.Date projectStartDate;
	private String projectDelYN;
	private int memberNo;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss SSS", timezone = "Asia/Seoul")
	private java.sql.Date projectEndDate;
	private String projectColor;
	
	private int projectRole;	//회원권한
	private int projectRoleNo;	//권한 고유 번호(pk)
	
	public ProjectAndAuthorityDTO() {}

	public ProjectAndAuthorityDTO(int pjtNo, String projectName, Date projectStartDate, String projectDelYN,
			int memberNo, Date projectEndDate, String projectColor, int projectRole, int projectRoleNo) {
		super();
		this.pjtNo = pjtNo;
		this.projectName = projectName;
		this.projectStartDate = projectStartDate;
		this.projectDelYN = projectDelYN;
		this.memberNo = memberNo;
		this.projectEndDate = projectEndDate;
		this.projectColor = projectColor;
		this.projectRole = projectRole;
		this.projectRoleNo = projectRoleNo;
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

	public int getProjectRole() {
		return projectRole;
	}

	public int getProjectRoleNo() {
		return projectRoleNo;
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

	public void setProjectRole(int projectRole) {
		this.projectRole = projectRole;
	}

	public void setProjectRoleNo(int projectRoleNo) {
		this.projectRoleNo = projectRoleNo;
	}

	@Override
	public String toString() {
		return "ProjectAndAuthorityDTO [pjtNo=" + pjtNo + ", projectName=" + projectName + ", projectStartDate="
				+ projectStartDate + ", projectDelYN=" + projectDelYN + ", memberNo=" + memberNo + ", projectEndDate="
				+ projectEndDate + ", projectColor=" + projectColor + ", projectRole=" + projectRole
				+ ", projectRoleNo=" + projectRoleNo + "]";
	}
	
	
}
