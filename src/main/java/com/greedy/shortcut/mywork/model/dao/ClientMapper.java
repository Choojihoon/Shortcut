package com.greedy.shortcut.mywork.model.dao;

import java.util.List;

import com.greedy.shortcut.member.model.dto.MemberDTO;
import com.greedy.shortcut.mywork.model.dto.ClientCardTaskAndCardAndMemberDTO;
import com.greedy.shortcut.mywork.model.dto.ClientProjectAndSprintDTO;
import com.greedy.shortcut.mywork.model.dto.ClientProjectDTO;

public interface ClientMapper {

	ClientProjectDTO selectProjectList(int pjtNo);
	
	ClientProjectAndSprintDTO selectOneProjectByPjNo(int pjtNo);
	
	List<ClientProjectDTO> selectProjectList2(int pjtNo);
	
	int selectSprintCount(int pjtNo);
	
	List<ClientCardTaskAndCardAndMemberDTO> selectBarInfo(int sprNo);

	List<Integer> selectProjectNuber(String email);
}

