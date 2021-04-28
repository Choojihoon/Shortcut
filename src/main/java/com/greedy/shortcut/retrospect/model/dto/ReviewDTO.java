package com.greedy.shortcut.retrospect.model.dto;

public class ReviewDTO implements java.io.Serializable {

	private String reviewLikeTxt;
	private String reviewLearnTxt;
	private String reviewMissTxt;
	private int reviewNo;
	private int sprNo;
	private int memNo;
	private String memName;
	
	public ReviewDTO() {}

	public ReviewDTO(String reviewLikeTxt, String reviewLearnTxt, String reviewMissTxt, int reviewNo, int sprNo,
			int memNo, String memName) {
		super();
		this.reviewLikeTxt = reviewLikeTxt;
		this.reviewLearnTxt = reviewLearnTxt;
		this.reviewMissTxt = reviewMissTxt;
		this.reviewNo = reviewNo;
		this.sprNo = sprNo;
		this.memNo = memNo;
		this.memName = memName;
	}

	public String getReviewLikeTxt() {
		return reviewLikeTxt;
	}

	public void setReviewLikeTxt(String reviewLikeTxt) {
		this.reviewLikeTxt = reviewLikeTxt;
	}

	public String getReviewLearnTxt() {
		return reviewLearnTxt;
	}

	public void setReviewLearnTxt(String reviewLearnTxt) {
		this.reviewLearnTxt = reviewLearnTxt;
	}

	public String getReviewMissTxt() {
		return reviewMissTxt;
	}

	public void setReviewMissTxt(String reviewMissTxt) {
		this.reviewMissTxt = reviewMissTxt;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getSprNo() {
		return sprNo;
	}

	public void setSprNo(int sprNo) {
		this.sprNo = sprNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	@Override
	public String toString() {
		return "ReviewDTO [reviewLikeTxt=" + reviewLikeTxt + ", reviewLearnTxt=" + reviewLearnTxt + ", reviewMissTxt="
				+ reviewMissTxt + ", reviewNo=" + reviewNo + ", sprNo=" + sprNo + ", memNo=" + memNo + ", memName="
				+ memName + "]";
	}

	
	
}
