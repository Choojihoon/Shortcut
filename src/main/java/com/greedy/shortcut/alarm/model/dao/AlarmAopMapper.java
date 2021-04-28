package com.greedy.shortcut.alarm.model.dao;

import java.util.Map;

import com.greedy.shortcut.board.model.dto.ProjectDTO;

public interface AlarmAopMapper {

	int registProjectAlarm(Map<String, Object> pjtAuthorityMap);

	ProjectDTO selectAlarmPjtName(int pjtNo);

}
