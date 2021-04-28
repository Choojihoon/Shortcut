package com.greedy.shortcut.alarm.model.service;

import java.util.List;

import com.greedy.shortcut.alarm.model.dto.AlertDTO;


public interface AlarmService {

	String selectGitUrl(int memNo);

	int registGitUrl(int memNo, String githubInfo);

	int modifyGitUrl(int memNo, String modifyUrl);

	int removeGitUrl(int memNo);

	List<AlertDTO> selectGeneralAlarmList(int no);

	int modifyAlarmRead(int no);

	int modifyAlarmRemove(int altDelNo);
}
