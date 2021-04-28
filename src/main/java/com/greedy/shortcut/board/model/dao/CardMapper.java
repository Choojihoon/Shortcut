package com.greedy.shortcut.board.model.dao;

import java.util.List;

import com.greedy.shortcut.board.model.dto.CardAttendListDTO;
import com.greedy.shortcut.board.model.dto.CardDTO;
import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.board.model.dto.RequestCardDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public interface CardMapper {

	List<ProjectAuthorityDTO> selectMember(int pjtNo);

	boolean registCard(RequestCardDTO card);

	CardDTO currentCardNo();

	List<RequestCardDTO> selctCardList(int brdNo);

	boolean registCardTask(RequestCardDTO card);

	boolean registCardSchedule(RequestCardDTO card);

	boolean registSchAttendList(CardAttendListDTO cal);

	List<RequestCardDTO> selectCardInfo(int cardNo);

	List<CardAttendListDTO> selectCardMember(int crdNo);

	boolean modifyCard(RequestCardDTO card);

	boolean updateCardTask(RequestCardDTO card);

	boolean updateCardSchedule(RequestCardDTO card);

	boolean updateSchAttendList(CardAttendListDTO cal);

	boolean deleteCard(RequestCardDTO card);


}
