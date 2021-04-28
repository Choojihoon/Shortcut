package com.greedy.shortcut.mywork.model.dao;

import java.util.HashMap;
import java.util.List;

import com.greedy.shortcut.member.model.dto.MemberDTO;
import com.greedy.shortcut.mywork.model.dto.ClientCardDTO;
import com.greedy.shortcut.mywork.model.dto.ClientTaskDTO;
import com.greedy.shortcut.mywork.model.dto.MyworkResponseCardAndScheduleDTO;
import com.greedy.shortcut.mywork.model.dto.MyworkResponseCardAndTaskDTO;

public interface MyworkMapper {

	MemberDTO selectUserInfoOne(String userName);

	List<MyworkResponseCardAndTaskDTO> selectTaskList(Integer no);

	List<ClientCardDTO> selectCardList(Integer no);


	int selectTaskTypeCount(HashMap<String, Object> map);

	List<MyworkResponseCardAndTaskDTO> selectTaskTypeList(HashMap<String, Object> map);

	boolean updateProgress(HashMap<String, Object> map);

	List<MyworkResponseCardAndScheduleDTO> selectMeetingList(HashMap<String, Object> map);
	

}
