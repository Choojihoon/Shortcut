package com.greedy.shortcut.retrospect.model.dto;

import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.board.model.dto.SprintDTO;
import com.greedy.shortcut.mywork.model.dto.ClientSprintDTO;
import com.greedy.shortcut.mywork.model.dto.ClientSprintDTO;

public class ProjectAndSprintDTO implements java.io.Serializable {

	private ProjectDTO projectDTO;
	private ClientSprintDTO sprintDTO;
	
	public ProjectAndSprintDTO() {
		
	}

	public ProjectAndSprintDTO(ProjectDTO projectDTO, ClientSprintDTO sprintDTO) {
		super();
		this.projectDTO = projectDTO;
		this.sprintDTO = sprintDTO;
	}

	public ProjectDTO getProjectDTO() {
		return projectDTO;
	}

	public void setProjectDTO(ProjectDTO projectDTO) {
		this.projectDTO = projectDTO;
	}

	public ClientSprintDTO getSprintDTO() {
		return sprintDTO;
	}

	public void setSprintDTO(ClientSprintDTO sprintDTO) {
		this.sprintDTO = sprintDTO;
	}

	@Override
	public String toString() {
		return "ProjectAndSprintDTO [projectDTO=" + projectDTO + ", sprintDTO=" + sprintDTO + "]";
	}
	
	
	
}
