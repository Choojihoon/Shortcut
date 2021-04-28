package com.greedy.shortcut.alarm.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.greedy.shortcut.alarm.model.dao.AlarmAopMapper;
import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.ProjectDTO;

public class ProjectAfterReturningAdvice {

	private AlarmAopMapper alarmAopMapper;
	
	@Autowired
	public ProjectAfterReturningAdvice(AlarmAopMapper alarmAopMapper) {
		this.alarmAopMapper = alarmAopMapper;
	}
	
	public void projectAfterReturning(JoinPoint joinPoint) {
		
		Object[] args = joinPoint.getArgs();
		String targetName = joinPoint.getTarget().toString();
		String signatureName = joinPoint.getSignature().toLongString();
		
		for(Object a : args) {
			System.out.println(a);
		}
		
	//	ProjectDTO [pjtNo=0, projectName=asdasdasdasdasd, 
	//	projectStartDate=2021-04-23, projectDelYN=null, memberNo=1,
	//	projectEndDate=2021-04-30, projectColor=#f7ef18, pjtAuthorityDTO=null, memberDTO=null]
	//  ProjectAuthorityDTO [projectRole=2, pjtNo=21, MemberNo=5, projectRoleNo=0, memberId=null]
	//  ProjectAuthorityDTO [projectRole=2, pjtNo=21, MemberNo=4, projectRoleNo=0, memberId=null]
	//  http://127.0.0.1:8001/shortcut/board/backlog?pjtNo=1&projectName=PJOJECT1

		System.out.println("targetName : " + targetName);
		System.out.println("singatureName : " + signatureName);
		
		ProjectAuthorityDTO projectAuthorityDTO = (ProjectAuthorityDTO) args[0];
		int memNo = projectAuthorityDTO.getMemberNo();
		int pjtNo = projectAuthorityDTO.getPjtNo();
		
		ProjectDTO projectDTO = alarmAopMapper.selectAlarmPjtName(pjtNo);
		
		String altUri = "http://127.0.0.1:8001/shortcut/board/backlog?pjtNo=" + pjtNo + "&projectName=" + projectDTO.getProjectName();
		String altTxt = projectDTO.getProjectName() + " 프로젝트에 초대되었습니다!"; 
		
		/* 프로젝트 생성자 */
		int constructorMember = projectDTO.getMemberNo();
		
		Map<String, Object> pjtAuthorityMap = new HashMap<>();
		
		if(constructorMember != memNo) {
			pjtAuthorityMap.put("memNo", memNo);
			pjtAuthorityMap.put("altUri", altUri);
			pjtAuthorityMap.put("altTxt", altTxt);
			
			int projectAopSuccess = alarmAopMapper.registProjectAlarm(pjtAuthorityMap);
			
			System.out.println("projectAopSuccess : " + projectAopSuccess);
		}
	}
	
}
