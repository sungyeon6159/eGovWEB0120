/**
 *<pre>
 * com.sewon.it.member.service
 * Class Name : UserVO.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-07-08           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-07-08 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.sewon.anyone.member.service;

import org.springframework.stereotype.Repository;

import com.sewon.anyone.cmn.DTO;


/**
 * @author Sewonit
 *
 */
public class UserVO extends DTO {
	
	private int userNo			;	/**1. 사용자번호   */
	private String userId		;	/**2. 사용자ID    */
	private String nickName		;	/**3. 닉네임      */
	private String userName		;	/**4. 사용자이름   */
	private String passwd		;	/**5. 비밀번호    */
	private Level authLevel		;	/**6. 권한레벨    */
	private int loginCnt		;	/**7. 로그인회수   */
	private String mobile		;	/**8. 전화번호    */
	private String email		;	/**9. 이메일주소   */
	private String addr			;	/**10.거주지주소   */
	private String modId		;	/**11.수정자      */
	private String regId		;	/**12.작성자      */
	private String modDate		;	/**13.수정일      */
	private String regDate		;	/**14.작성일      */
	
	public UserVO(){}

	public UserVO(int userNo, String userId, String nickName, String userName, String passwd, Level authLevel,
			int loginCnt, String mobile, String email, String addr, String modId, String regId, String modDate,
			String regDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.nickName = nickName;
		this.userName = userName;
		this.passwd = passwd;
		this.authLevel = authLevel;
		this.loginCnt = loginCnt;
		this.mobile = mobile;
		this.email = email;
		this.addr = addr;
		this.modId = modId;
		this.regId = regId;
		this.modDate = modDate;
		this.regDate = regDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Level getAuthLevel() {
		return authLevel;
	}

	public void setAuthLevel(Level authLevel) {
		this.authLevel = authLevel;
	}

	public int getLoginCnt() {
		return loginCnt;
	}

	public void setLoginCnt(int loginCnt) {
		this.loginCnt = loginCnt;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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
		return "UserVO [userNo=" + userNo + ", userId=" + userId + ", nickName=" + nickName + ", userName=" + userName
				+ ", passwd=" + passwd + ", authLevel=" + authLevel + ", loginCnt=" + loginCnt + ", mobile=" + mobile
				+ ", email=" + email + ", addr=" + addr + ", modId=" + modId + ", regId=" + regId + ", modDate="
				+ modDate + ", regDate=" + regDate + ", toString()=" + super.toString() + "]";
	}

	
	
}