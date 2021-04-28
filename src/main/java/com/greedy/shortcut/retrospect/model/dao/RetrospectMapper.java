package com.greedy.shortcut.retrospect.model.dao;

import java.util.List;
import java.util.Map;

import com.greedy.shortcut.board.model.dto.BacklogDTO;
import com.greedy.shortcut.retrospect.model.dto.ProjectAndSprintDTO;
import com.greedy.shortcut.retrospect.model.dto.ReviewAndProjectMemberDTO;
import com.greedy.shortcut.retrospect.model.dto.ReviewDTO;

public interface RetrospectMapper {

	List<ReviewDTO> selectReview(int blgNo);
	
	List<BacklogDTO> selectFinishSprint(int pjtNo);
	
	List<BacklogDTO> selectPagingFinishSprint(Map<String, Object> pagingMap);

	int selectReviewRegistYn(int blgNo); 
	
	ProjectAndSprintDTO selectPtjAndSprName(int blgNo);
	
	List<ReviewAndProjectMemberDTO> selectReviewAndProjectMember(int pjtNo);
	
	int selectPjtNo(int blgNo);
	
	int registReview(ReviewDTO reviewDTO);

	int updateReview(ReviewDTO reviewDTO);

	int removeReview(ReviewDTO reviewDTO);
	
	int selectSprintNo(int blgNo);
}
