/**
 *  BoardVO
 */
package com.sewon.anyone.board.service;

import com.sewon.anyone.cmn.DTO;

/**
 * @author Sewonit
 *
 */
public class BoardVO extends DTO {

	/** 게시글번호 */
	private int postNo;
	/** 게시판번호 */
	private int bbsNo;
	/** 게시글제목 */
	private String postTitle;
	/** 게시글내용 */
	private String postContents;
	/** 공지여부 */
	private int topPostYn;
	/** 전시여부 */
	private int dispYn;
	/** 조회수 */
	private int readCnt;
	/** 댓글가능여부 */
	private int replyYn;
	/** 사용자ID */
	private String userId;
	/** 수정자 */
	private String modId;
	/** 작성자 */
	private String regId;
	/** 수정일 */
	private String modDate;
	/** 작성일 */
	private String regDate;

	public BoardVO() {
	}

	public BoardVO(int postNo, int bbsNo, String postTitle, String postContents, int topPostYn, int dispYn, int readCnt,
			int replyYn, String userId, String modId, String regId, String modDate, String regDate) {
		super();
		this.postNo = postNo;
		this.bbsNo = bbsNo;
		this.postTitle = postTitle;
		this.postContents = postContents;
		this.topPostYn = topPostYn;
		this.dispYn = dispYn;
		this.readCnt = readCnt;
		this.replyYn = replyYn;
		this.userId = userId;
		this.modId = modId;
		this.regId = regId;
		this.modDate = modDate;
		this.regDate = regDate;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public int getBbsNo() {
		return bbsNo;
	}

	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContents() {
		return postContents;
	}

	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}

	public int getTopPostYn() {
		return topPostYn;
	}

	public void setTopPostYn(int topPostYn) {
		this.topPostYn = topPostYn;
	}

	public int getDispYn() {
		return dispYn;
	}

	public void setDispYn(int dispYn) {
		this.dispYn = dispYn;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	public int getReplyYn() {
		return replyYn;
	}

	public void setReplyYn(int replyYn) {
		this.replyYn = replyYn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getModId() {
		return modId;
	}

	public void setModId(String modId) {
		this.modId = modId;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardVO [postNo=" + postNo + ", bbsNo=" + bbsNo + ", postTitle=" + postTitle + ", postContents="
				+ postContents + ", topPostYn=" + topPostYn + ", dispYn=" + dispYn + ", readCnt=" + readCnt
				+ ", replyYn=" + replyYn + ", userId=" + userId + ", modId=" + modId + ", regId=" + regId + ", modDate="
				+ modDate + ", regDate=" + regDate + ", toString()=" + super.toString() + "]";
	}

	
}
