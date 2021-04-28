package com.greedy.shortcut.mywork.model.service;

import java.util.List;

import com.greedy.shortcut.common.paging.PageInfoDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;
import com.greedy.shortcut.mywork.model.dto.ClientCardDTO;
import com.greedy.shortcut.mywork.model.dto.ClientTaskDTO;
import com.greedy.shortcut.mywork.model.dto.MyworkResponseCardAndScheduleDTO;
import com.greedy.shortcut.mywork.model.dto.MyworkResponseCardAndTaskDTO;

public interface MyworkService {

	MemberDTO selectUserInfoOne(String userName);

	List<ClientCardDTO> selectCardList(Integer no);

	List<MyworkResponseCardAndTaskDTO> selectTaskList(Integer no);

	int selectTaskTypeCount(Integer no, int i);

	List<MyworkResponseCardAndTaskDTO> selectTaskTypeList(Integer no, int i, PageInfoDTO reqPageInfo);

	boolean updateProgress(int crdNo, int type, int intenType);

	List<MyworkResponseCardAndScheduleDTO> selectMeetingList(Integer no);

	

}
