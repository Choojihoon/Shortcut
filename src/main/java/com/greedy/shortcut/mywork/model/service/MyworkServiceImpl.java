package com.greedy.shortcut.mywork.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.shortcut.common.paging.PageInfoDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;
import com.greedy.shortcut.mywork.model.dao.MyworkMapper;
import com.greedy.shortcut.mywork.model.dto.ClientCardDTO;
import com.greedy.shortcut.mywork.model.dto.ClientTaskDTO;
import com.greedy.shortcut.mywork.model.dto.MyworkResponseCardAndScheduleDTO;
import com.greedy.shortcut.mywork.model.dto.MyworkResponseCardAndTaskDTO;

@Service
public class MyworkServiceImpl implements MyworkService{
	
	private MyworkMapper myworkMapper; 
	
	@Autowired
	public MyworkServiceImpl(MyworkMapper myworkMapper) {
		this.myworkMapper = myworkMapper;
	}

	@Override
	public MemberDTO selectUserInfoOne(String userName) {
		
		return myworkMapper.selectUserInfoOne(userName);
	}

	@Override
	public List<ClientCardDTO> selectCardList(Integer no) {
		
		
		return myworkMapper.selectCardList(no);
	}


	@Override
	public List<MyworkResponseCardAndTaskDTO> selectTaskList(Integer no) {
		
		return myworkMapper.selectTaskList(no);
	}

	@Override
	public int selectTaskTypeCount(Integer no, int i) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("memNo", no);
		map.put("type", i);
		
		System.out.println("no: " + no + ", type: "+ i);
		
		return myworkMapper.selectTaskTypeCount(map);
	}

	@Override
	public List<MyworkResponseCardAndTaskDTO> selectTaskTypeList(Integer no, int i, PageInfoDTO PageInfo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("memNo", no);
		map.put("type", i);
		map.put("startRow", PageInfo.getStartRow());
		map.put("endRow",  PageInfo.getEndRow());

		
		return myworkMapper.selectTaskTypeList(map);
	}

	@Override
	public boolean updateProgress(int crdNo, int type, int intenType) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("crdNo", crdNo);
		map.put("type", type);
		map.put("intenType",intenType);
		
		return myworkMapper.updateProgress(map);
	}

	@Override
	public List<MyworkResponseCardAndScheduleDTO> selectMeetingList(Integer no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("memNo", no);


		
		return myworkMapper.selectMeetingList(map);
	
	}



}
