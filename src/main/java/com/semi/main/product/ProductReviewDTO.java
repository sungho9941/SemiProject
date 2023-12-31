package com.semi.main.product;

public class ProductReviewDTO {

	private Long reviewNo;
	private Long proNo;
	private Long userNo;
	private String contents;
	private Double score;
	private String userId;
	private String fileName;
	private String proName;
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Double getScore() {
		if(score==null) {
			score=0.0;
		}
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(Long reviewNo) {
		this.reviewNo = reviewNo;
	}
	public Long getProNo() {
		return proNo;
	}
	public void setProNo(Long proNo) {
		this.proNo = proNo;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
}


