package com.greedy.shortcut.alarm.model.dao;

import java.util.List;
import java.util.Map;

import com.greedy.shortcut.alarm.model.dto.AlertDTO;

public interface AlarmMapper {

	String selectGitUrl(int memNo);
	
	int registGitUrl(Map<String, Object> transferMap);
	
	int modifyGitUrl(Map<String, Object> transferMap);
	
	int removeGitUrl(int memNo);

	CharSequence countReceiveNote(String payload);
	
	List<AlertDTO> selectGeneralAlarmList(int no);
	
	int modifyAlarmRead(int no);

	int modifyAlarmRemove(int altDelNo);
}
