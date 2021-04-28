package com.greedy.shortcut.mywork.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.shortcut.member.model.dto.MemberDTO;
import com.greedy.shortcut.mywork.model.dao.ClientMapper;
import com.greedy.shortcut.mywork.model.dto.ClientCardTaskAndCardAndMemberDTO;
import com.greedy.shortcut.mywork.model.dto.ClientProjectAndSprintDTO;
import com.greedy.shortcut.mywork.model.dto.ClientProjectDTO;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	private ClientMapper clientMapper;
	
	@Autowired
	public ClientServiceImpl(ClientMapper clientMapper) {
		this.clientMapper = clientMapper;
	}
	
	@Override
	public ClientProjectDTO selectProjectList(int pjtNo) {
		return clientMapper.selectProjectList(pjtNo);
	}

	@Override
	public ClientProjectAndSprintDTO selectOneProjectByPjNo(int pjtNo) {
		return clientMapper.selectOneProjectByPjNo(pjtNo);
	}

	@Override
	public List<ClientProjectDTO> selectProjectList2(int pjtNo) {
		return clientMapper.selectProjectList2(pjtNo);
	}

	@Override
	public int selectSprintCount(int pjtNo) {
		return clientMapper.selectSprintCount(pjtNo);
	}

	@Override
	public List<ClientCardTaskAndCardAndMemberDTO> selectBarInfo(int sprNo) {
		return clientMapper.selectBarInfo(sprNo);
	}

	@Override
	public List<Integer> selectProjectNuber(String email) {
		return clientMapper.selectProjectNuber(email);
	}



}
