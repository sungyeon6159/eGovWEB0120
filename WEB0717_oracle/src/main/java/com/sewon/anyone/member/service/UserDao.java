package com.sewon.anyone.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sewon.anyone.cmn.DTO;




public interface UserDao {
	
	static final Logger LOG = LoggerFactory.getLogger(UserDao.class);
	
	/**
	 * 비번 체크: 성공>0
	 * @param dto
	 * @return int
	 */
	public int passCheck(DTO dto);
	/**
	 * ID 체크: 성공>0
	 * @param dto
	 * @return int
	 */
	public int idCheck(DTO dto);

	/**
	 * 등록
	 * @param dto
	 * @return int
	 */
	public int doInsert(DTO dto);
	/**
	 * 수정
	 * @param dto
	 * @return int
	 */
	public int doUpdate(DTO dto);

	/**
	 * 단건조회
	 * @param dto
	 * @return DTO
	 */
	public DTO doSelectOne(DTO dto);

	/**
	 * 삭제
	 * @param dto
	 * @return int
	 */
	public int doDelete(DTO dto);

	/**
	 * 목록조회
	 * @param dto
	 * @return
	 */
	public List<?> doRetrieve(DTO dto);

	/**
	 * 전체 조회
	 * @param dto
	 * @return
	 */
	public List<?> getAll(DTO dto);
	
	
	/**
	 *  아이디&패스워드 조회
	 * @param dto
	 * @return
	 */
	public int idPassCheck(DTO dto);
}
