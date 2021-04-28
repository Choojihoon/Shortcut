package com.greedy.shortcut.member.model.dto;

import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;

public class MemberDTO {
	
	private Integer no;
	private String email;
	private String password;
	private String phone;
	private String name;
	private String gitUrl;
	
	private ProjectDTO projectDTO;
	private int projectNo;
	private ProjectAuthorityDTO projectAuthorityDTO;
	
	
	public MemberDTO() {}


	public MemberDTO(Integer no, String email, String password, String phone, String name, ProjectDTO projectDTO,
			int projectNo, ProjectAuthorityDTO projectAuthorityDTO, String gitUrl) {
		super();
		this.no = no;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.name = name;
		this.projectDTO = projectDTO;
		this.projectNo = projectNo;
		this.projectAuthorityDTO = projectAuthorityDTO;
		this.gitUrl = gitUrl;
	}

	public String getGitUrl() {
		return gitUrl;
	}
	
	public void setGitUrl(String gitUrl) {
		this.gitUrl = gitUrl;
	}
	
	public Integer getNo() {
		return no;
	}


	public void setNo(Integer no) {
		this.no = no;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ProjectDTO getProjectDTO() {
		return projectDTO;
	}


	public void setProjectDTO(ProjectDTO projectDTO) {
		this.projectDTO = projectDTO;
	}


	public int getProjectNo() {
		return projectNo;
	}


	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}


	public ProjectAuthorityDTO getProjectAuthorityDTO() {
		return projectAuthorityDTO;
	}


	public void setProjectAuthorityDTO(ProjectAuthorityDTO projectAuthorityDTO) {
		this.projectAuthorityDTO = projectAuthorityDTO;
	}


	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", email=" + email + ", password=" + password + ", phone=" + phone + ", name="
				+ name + ", projectDTO=" + projectDTO + ", projectNo=" + projectNo + ", projectAuthorityDTO="
				+ projectAuthorityDTO + "]";
	}


	
	
	
}
