package com.greedy.shortcut.retrospect.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.shortcut.board.model.dto.BacklogDTO;
import com.greedy.shortcut.common.paging.PageInfoDTO;
import com.greedy.shortcut.retrospect.model.dao.RetrospectMapper;
import com.greedy.shortcut.retrospect.model.dto.ProjectAndSprintDTO;
import com.greedy.shortcut.retrospect.model.dto.ReviewAndProjectMemberDTO;
import com.greedy.shortcut.retrospect.model.dto.ReviewDTO;

@Service("retrospectService")
public class RetrospectServiceImpl implements RetrospectService {

	private RetrospectMapper retrospectMapper;
	
	@Autowired
	public RetrospectServiceImpl(RetrospectMapper retrospectMapper) {
		this.retrospectMapper = retrospectMapper;
	}
	
	@Override
	public List<ReviewDTO> selectReview(int blgNo) {
		return retrospectMapper.selectReview(blgNo);
	}
	
	@Override
	public List<BacklogDTO> selectFinishSprint(int pjtNo) {
		return retrospectMapper.selectFinishSprint(pjtNo);
	}
	
	@Override
	public List<BacklogDTO> selectPagingFinishSprint(int pjtNo, PageInfoDTO pageInfo) {
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("pjtNo", pjtNo);
		pagingMap.put("startRow", pageInfo.getStartRow());
		pagingMap.put("endRow", pageInfo.getEndRow());
		
		return retrospectMapper.selectPagingFinishSprint(pagingMap);
	}

	@Override
	public int selectReviewRegistYn(int blgNo) {
		return retrospectMapper.selectReviewRegistYn(blgNo);
	}

	@Override
	public ProjectAndSprintDTO selectPtjAndSprName(int blgNo) {
		return retrospectMapper.selectPtjAndSprName(blgNo);
	}

	@Override
	public List<ReviewAndProjectMemberDTO> selectReviewAndProjectMember(int pjtNo) {
		return retrospectMapper.selectReviewAndProjectMember(pjtNo);
	}

	@Override
	public int selectPjtNo(int blgNo) {
		return retrospectMapper.selectPjtNo(blgNo);
	}

	@Override
	public int registReview(ReviewDTO reviewDTO) {
		return retrospectMapper.registReview(reviewDTO);
	}

	@Override
	public int updateReview(ReviewDTO reviewDTO) {
		return retrospectMapper.updateReview(reviewDTO);
	}

	@Override
	public int removeReview(ReviewDTO reviewDTO) {
		return retrospectMapper.removeReview(reviewDTO);
	}

	@Override
	public int selectSprintNo(int blgNo) {
		return retrospectMapper.selectSprintNo(blgNo);
	}

}
