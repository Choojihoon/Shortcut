package com.greedy.shortcut.retrospect.model.dto;

import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public class ReviewAndProjectMemberDTO implements java.io.Serializable {

	private ProjectAuthorityDTO projectAuthorityDTO;
	private ProjectDTO projectDTO;
	private MemberDTO memberDTO;
	
	public ReviewAndProjectMemberDTO() {}

	public ReviewAndProjectMemberDTO(ProjectAuthorityDTO projectAuthorityDTO, ProjectDTO projectDTO,
			MemberDTO memberDTO) {
		super();
		this.projectAuthorityDTO = projectAuthorityDTO;
		this.projectDTO = projectDTO;
		this.memberDTO = memberDTO;
	}

	public ProjectAuthorityDTO getProjectAuthorityDTO() {
		return projectAuthorityDTO;
	}

	public void setProjectAuthorityDTO(ProjectAuthorityDTO projectAuthorityDTO) {
		this.projectAuthorityDTO = projectAuthorityDTO;
	}

	public ProjectDTO getProjectDTO() {
		return projectDTO;
	}

	public void setProjectDTO(ProjectDTO projectDTO) {
		this.projectDTO = projectDTO;
	}

	public MemberDTO getMemberDTO() {
		return memberDTO;
	}

	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	@Override
	public String toString() {
		return "ReviewAndProjectMemberDTO [projectAuthorityDTO=" + projectAuthorityDTO + ", projectDTO=" + projectDTO
				+ ", memberDTO=" + memberDTO + "]";
	}
	
	
	
}
