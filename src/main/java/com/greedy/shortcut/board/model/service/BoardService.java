package com.greedy.shortcut.board.model.service;

import java.util.List;

import com.greedy.shortcut.board.model.dto.BoardDTO;
import com.greedy.shortcut.board.model.dto.ProjectAuthorityDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public interface BoardService {

	boolean newBoard(BoardDTO board);

	List<MemberDTO> selectMember(int pjtNo);

	boolean insertnewBoard(BoardDTO newboard);

	List<BoardDTO> selectboardList(int sprNo);

	int modifyBoardOrder(int brdNo);

	boolean deleteBoard(BoardDTO board);

	boolean modifyBoard(BoardDTO board);







}
