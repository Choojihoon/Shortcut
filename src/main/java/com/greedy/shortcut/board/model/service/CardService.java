package com.greedy.shortcut.board.model.service;

import java.util.HashMap;
import java.util.List;

import com.greedy.shortcut.board.model.dto.BoardDTO;
import com.greedy.shortcut.board.model.dto.CardAttendListDTO;
import com.greedy.shortcut.board.model.dto.CardDTO;
import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.RequestCardDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public interface CardService {

	List<ProjectAuthorityDTO> selectMember(int pjtNo);

	boolean createCard(CardDTO card);

	boolean cardMember(int memberNo, int cNo);

	boolean registCard(RequestCardDTO card);

	CardDTO currentCardNo();

	List<RequestCardDTO> selectCardList(List<BoardDTO> boardList);

	
	List<RequestCardDTO> selectCardInfo(int cardNo);

	List<CardAttendListDTO> selectCardMember(int crdNo);

	boolean modifyCard(RequestCardDTO card);

	boolean deleteCard(RequestCardDTO card);



}
