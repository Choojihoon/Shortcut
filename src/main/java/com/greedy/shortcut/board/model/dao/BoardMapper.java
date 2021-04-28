package com.greedy.shortcut.board.model.dao;

import java.util.List;
import java.util.Map;

import com.greedy.shortcut.board.model.dto.BoardDTO;
import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public interface BoardMapper {

	int newBoard(BoardDTO board);

	List<MemberDTO> selectMember(int pjtNo);

	boolean insertnewBoard(BoardDTO newboard);

	List<BoardDTO> selectboardList(int sprNo);

	int modifyBoardOrder(int brdNo);

	boolean deleteBoard(int brdNo);

	int insertDeleteBoardHistory(BoardDTO board);

	int modifyBoard(BoardDTO board);

	int insertModifyBoardHistory(BoardDTO board);



}
