package com.greedy.shortcut.retrospect.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greedy.shortcut.board.model.dto.BacklogDTO;
import com.greedy.shortcut.common.paging.PageInfoDTO;
import com.greedy.shortcut.common.paging.Pagenation;
import com.greedy.shortcut.retrospect.model.dto.ProjectAndSprintDTO;
import com.greedy.shortcut.retrospect.model.dto.ReviewAndProjectMemberDTO;
import com.greedy.shortcut.retrospect.model.dto.ReviewDTO;
import com.greedy.shortcut.retrospect.model.service.RetrospectService;

@Controller
@RequestMapping("/*")
public class RetrospectController {

	private final RetrospectService retrospectService;

	@Autowired
	public RetrospectController(RetrospectService retrospectService) {
		this.retrospectService = retrospectService;
	}

	@GetMapping(value="board/backlog/reviewPaging", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String reviewPaging(Model model, @RequestParam Map<String, String> parameters) throws JsonProcessingException {

		int pjtNo = Integer.parseInt(parameters.get("pjtNo")); 
		String currentPage = parameters.get("currentPage"); 
		int limit = 5;
		int buttonAmount = 3;

		int pageNo = 1;
		int totalCount = 0;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		if(pageNo <= 0) {
			pageNo = 1;
		}

		List<BacklogDTO> allfinishSprintList = retrospectService.selectFinishSprint(pjtNo);
		for(BacklogDTO backlog : allfinishSprintList) {
			System.out.println(backlog);
		}

		/* 총 개수 */
		totalCount = allfinishSprintList.size();

		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		System.out.println(pageInfo);

		List<BacklogDTO> finishSprintList = retrospectService.selectPagingFinishSprint(pjtNo, pageInfo);
		for(int i = 0; i < finishSprintList.size(); i++ ) {
			/* 등록된 리뷰인지 수정해야할 리뷰인지 검색(버튼에 표기하기 위해) */
			int reviewRegistYn = retrospectService.selectReviewRegistYn(finishSprintList.get(i).getSprNo());
			/* 0보다 크면 null이 아니기에 리뷰 수정 버튼  */
			if(reviewRegistYn > 0) {
				finishSprintList.get(i).setReviewRegistYn(reviewRegistYn);
			} else {
				finishSprintList.get(i).setReviewRegistYn(0);
			}

			finishSprintList.get(i).setStartPage(pageInfo.getStartPage());
			finishSprintList.get(i).setEndPage(pageInfo.getEndPage());
			finishSprintList.get(i).setMaxPage(pageInfo.getMaxPage());
			System.out.println("finishSprintList " + i + " : " + finishSprintList.get(i));
		}

		return new ObjectMapper().writeValueAsString(finishSprintList);
	}

	@GetMapping("board/backlog/retrospect/{blgNo}")
	public ModelAndView retrospect(@PathVariable("blgNo") int blgNo, ModelAndView mv) {

		System.out.println("blgNo : " + blgNo);
		/* 리뷰 리스트 */
		List<ReviewDTO> review = retrospectService.selectReview(blgNo);
		for(ReviewDTO rv : review) {
			System.out.println(rv);
		}
		/* 프로젝트 이름과, 각 스프린트 이름 조회 */
		ProjectAndSprintDTO projectAndSprintName = retrospectService.selectPtjAndSprName(blgNo);
		String pjtName = projectAndSprintName.getProjectDTO().getProjectName();
		String sprName = projectAndSprintName.getSprintDTO().getSprName();
		int pjtNo = projectAndSprintName.getProjectDTO().getPjtNo();

		/* 프로젝트 전체 참여 인원 조회 */
		List<ReviewAndProjectMemberDTO> reviewAndProjectMemberList = retrospectService.selectReviewAndProjectMember(pjtNo);
		for(ReviewAndProjectMemberDTO rpm : reviewAndProjectMemberList) {
			System.out.println(rpm);
		}

		mv.addObject("blgNo", blgNo);
		mv.addObject("review", review);
		mv.addObject("pjtName", pjtName);
		mv.addObject("sprName", sprName);
		mv.addObject("reviewAndProjectMemberList", reviewAndProjectMemberList);
		mv.setViewName("retrospect/retrospect");

		return mv;
	}

	@PostMapping("/board/backlog/retrospect/regist")
	public ModelAndView registReview(ModelAndView mv, @ModelAttribute ReviewDTO review, HttpServletRequest request) {

		String blgNo = request.getParameter("blgNo");
		int blgNo2 = Integer.parseInt(request.getParameter("blgNo"));
		String pjtName = request.getParameter("pjtName");
		
		System.out.println(blgNo);
		System.out.println(pjtName);
		System.out.println(review);
		
		int pjtNo = retrospectService.selectPjtNo(blgNo2);
		System.out.println(pjtNo);

		String[] reviewLikeTxt = review.getReviewLikeTxt().split(",", -1);
		String[] reviewLearnTxt = review.getReviewLearnTxt().split(",", -1);
		String[] reviewMissTxt = review.getReviewMissTxt().split(",", -1);
		String[] memName = review.getMemName().split(",", -1);

		System.out.println("memName.length : " + memName.length);

		List<ReviewDTO> insertReviewList = new ArrayList<>();
		int blgNumber = retrospectService.selectSprintNo(blgNo2);
		for(int i = 0; i < memName.length; i++) {
			ReviewDTO rv = new ReviewDTO();
			rv.setReviewLikeTxt(reviewLikeTxt[i]);
			rv.setReviewLearnTxt(reviewLearnTxt[i]);
			rv.setReviewMissTxt(reviewMissTxt[i]);
			rv.setMemName(memName[i]);
			rv.setSprNo(blgNumber);
			
			insertReviewList.add(rv);
		}

		for(ReviewDTO ird : insertReviewList) {
			System.out.println(ird);
		}
		
		List<ReviewAndProjectMemberDTO> reviewAndProjectMemberList = retrospectService.selectReviewAndProjectMember(pjtNo);
		for(int i = 0; i < reviewAndProjectMemberList.size(); i++) {
			if(reviewAndProjectMemberList.get(i).getMemberDTO().getName().equals(insertReviewList.get(i).getMemName())) {
				insertReviewList.get(i).setMemNo(reviewAndProjectMemberList.get(i).getMemberDTO().getNo());
			}
		}
		
		int success = 0;
		for(int i = 0; i < insertReviewList.size(); i++) {
			success += retrospectService.registReview(insertReviewList.get(i));
		}
		
		if(success > 0 && insertReviewList.size() == success) {
			System.out.println("성공");
		}
		
		mv.setViewName("redirect:/board/backlog/?pjtNo=" + pjtNo +"&projectName=" + pjtName);
		return mv;
	}
	
	@PostMapping("/board/backlog/retrospect/modify")
	public ModelAndView modifyReview(ModelAndView mv, @ModelAttribute ReviewDTO review, HttpServletRequest request) {
		
		String blgNo = request.getParameter("blgNo");
		int blgNo2 = Integer.parseInt(request.getParameter("blgNo"));
		String pjtName = request.getParameter("pjtName");
		
		System.out.println(blgNo);
		System.out.println(pjtName);
		System.out.println(review);
		
		int pjtNo = retrospectService.selectPjtNo(blgNo2);
		System.out.println(pjtNo);

		String[] reviewLikeTxt = review.getReviewLikeTxt().split(",", -1);
		String[] reviewLearnTxt = review.getReviewLearnTxt().split(",", -1);
		String[] reviewMissTxt = review.getReviewMissTxt().split(",", -1);
		String[] memName = review.getMemName().split(",", -1);

		System.out.println("memName.length : " + memName.length);

		List<ReviewDTO> updateReviewList = new ArrayList<>();
		int blgNumber = retrospectService.selectSprintNo(blgNo2);
		for(int i = 0; i < memName.length; i++) {
			ReviewDTO rv = new ReviewDTO();
			rv.setReviewLikeTxt(reviewLikeTxt[i]);
			rv.setReviewLearnTxt(reviewLearnTxt[i]);
			rv.setReviewMissTxt(reviewMissTxt[i]);
			rv.setMemName(memName[i]);
			rv.setSprNo(blgNumber);
			
			updateReviewList.add(rv);
		}

		for(ReviewDTO ird : updateReviewList) {
			System.out.println(ird);
		}
		
		List<ReviewAndProjectMemberDTO> reviewAndProjectMemberList = retrospectService.selectReviewAndProjectMember(pjtNo);
		for(int i = 0; i < reviewAndProjectMemberList.size(); i++) {
			if(reviewAndProjectMemberList.get(i).getMemberDTO().getName().equals(updateReviewList.get(i).getMemName())) {
				updateReviewList.get(i).setMemNo(reviewAndProjectMemberList.get(i).getMemberDTO().getNo());
			}
		}
		
		int success = 0;
		for(int i = 0; i < updateReviewList.size(); i++) {
			success += retrospectService.updateReview(updateReviewList.get(i));
		}
		
		if(success > 0 && updateReviewList.size() == success) {
			System.out.println("성공");
		}
		
		mv.setViewName("redirect:/board/backlog/?pjtNo=" + pjtNo +"&projectName=" + pjtName);
		
		return mv;
	}

	@PostMapping("/board/backlog/retrospect/remove")
	public ModelAndView removeReview(ModelAndView mv, @ModelAttribute ReviewDTO review, HttpServletRequest request) {
		
		String blgNo = request.getParameter("blgNo");
		int blgNo2 = Integer.parseInt(request.getParameter("blgNo"));
		String pjtName = request.getParameter("pjtName");
		
		System.out.println(blgNo);
		System.out.println(pjtName);
		System.out.println(review);
		
		int pjtNo = retrospectService.selectPjtNo(blgNo2);
		System.out.println(pjtNo);

		String[] memName = review.getMemName().split(",", -1);

		System.out.println("memName.length : " + memName.length);
		
		List<ReviewDTO> removeReviewList = new ArrayList<>();
		int blgNumber = retrospectService.selectSprintNo(blgNo2);
		for(int i = 0; i < memName.length; i++) {
			ReviewDTO rv = new ReviewDTO();
			rv.setMemName(memName[i]);
			rv.setSprNo(blgNumber);
			
			removeReviewList.add(rv);
		}

		for(ReviewDTO ird : removeReviewList) {
			System.out.println(ird);
		}
		
		List<ReviewAndProjectMemberDTO> reviewAndProjectMemberList = retrospectService.selectReviewAndProjectMember(pjtNo);
		for(int i = 0; i < reviewAndProjectMemberList.size(); i++) {
			if(reviewAndProjectMemberList.get(i).getMemberDTO().getName().equals(removeReviewList.get(i).getMemName())) {
				removeReviewList.get(i).setMemNo(reviewAndProjectMemberList.get(i).getMemberDTO().getNo());
			}
		}
		
		int success = 0;
		for(int i = 0; i < removeReviewList.size(); i++) {
			success += retrospectService.removeReview(removeReviewList.get(i));
		}
		System.out.println("success : " + success);
		
		if(success > 0 && removeReviewList.size() == success) {
			System.out.println("성공");
		}
		
		mv.setViewName("redirect:/board/backlog/?pjtNo=" + pjtNo +"&projectName=" + pjtName);
		
		return mv;
	}
	
		
}
