package com.greedy.shortcut.mywork.model.dto;

import java.util.List;

public class ClientSprintAndCardTask implements java.io.Serializable {

	private int sprintNo;
	private String sprintName;
	private List<ClientCardTaskAndCardAndMemberDTO> sprintAndCardTaskList; 
	
	public ClientSprintAndCardTask() {}

	public ClientSprintAndCardTask(int sprintNo, String sprintName,
			List<ClientCardTaskAndCardAndMemberDTO> sprintAndCardTaskList) {
		super();
		this.sprintNo = sprintNo;
		this.sprintName = sprintName;
		this.sprintAndCardTaskList = sprintAndCardTaskList;
	}

	public int getSprintNo() {
		return sprintNo;
	}

	public void setSprintNo(int sprintNo) {
		this.sprintNo = sprintNo;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public List<ClientCardTaskAndCardAndMemberDTO> getSprintAndCardTaskList() {
		return sprintAndCardTaskList;
	}

	public void setSprintAndCardTaskList(List<ClientCardTaskAndCardAndMemberDTO> sprintAndCardTaskList) {
		this.sprintAndCardTaskList = sprintAndCardTaskList;
	}

	@Override
	public String toString() {
		return "ClientSprintAndCardTask [sprintNo=" + sprintNo + ", sprintName=" + sprintName
				+ ", sprintAndCardTaskList=" + sprintAndCardTaskList + "]";
	}

	
	
	
	
}
