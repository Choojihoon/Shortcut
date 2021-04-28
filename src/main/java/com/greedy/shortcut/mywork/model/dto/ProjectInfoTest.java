package com.greedy.shortcut.mywork.model.dto;

import java.sql.Date;

public class ProjectInfoTest {

	private String projectName;
	private String content;
	private java.util.Date startDate;
	private java.util.Date endDate;
	
	public ProjectInfoTest() {}

	public ProjectInfoTest(String projectName, String content, java.util.Date startDate, java.util.Date endDate) {
		super();
		this.projectName = projectName;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public java.util.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "ProjectInfoTest [projectName=" + projectName + ", content=" + content + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}


	
}
