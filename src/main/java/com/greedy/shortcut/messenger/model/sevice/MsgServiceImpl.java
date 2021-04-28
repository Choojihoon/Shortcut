package com.greedy.shortcut.messenger.model.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.shortcut.board.model.dto.ProjectDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;
import com.greedy.shortcut.messenger.model.dao.MsgMapper;
import com.greedy.shortcut.messenger.model.dto.MessengerDTO;
import com.greedy.shortcut.messenger.model.dto.PmDTO;

@Service("msgService")
public class MsgServiceImpl implements MsgService {

	private final MsgMapper msgMapper;
	
	@Autowired
	public MsgServiceImpl(MsgMapper msgMapper) {
		this.msgMapper = msgMapper;
	}

	@Override
	public List<MemberDTO> selectMember(int userNo) {
		
		return msgMapper.selectMember(userNo);
	}

	

}
