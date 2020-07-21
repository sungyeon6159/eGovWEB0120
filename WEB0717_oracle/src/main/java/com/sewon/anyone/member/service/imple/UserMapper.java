package com.sewon.anyone.member.service.imple;

import java.sql.SQLException;
import java.util.List;

import com.sewon.anyone.cmn.DTO;
import com.sewon.anyone.member.service.UserVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;




@Mapper("userMapper")
public interface UserMapper {
    /**
     * ID check, 비번 Check
     * @param dto
     * @return int
     */
	public int idPassCheck(DTO dto) throws Exception;;

	/**
	 * 등록
	 * @param dto
	 * @return int
	 */
	public int doInsert(DTO dto) throws Exception;;
	/**
	 * 수정
	 * @param dto
	 * @return int
	 */
	public int doUpdate(DTO dto) throws Exception;;

	/**
	 * 단건조회
	 * @param dto
	 * @return DTO
	 */
	public DTO doSelectOne(DTO dto) throws Exception;;

	/**
	 * 삭제
	 * @param dto
	 * @return int
	 */
	public int doDelete(DTO dto) throws Exception;;

	/**
	 * 목록조회
	 * @param dto
	 * @return
	 */
	public List<?> doRetrieve(DTO dto) throws Exception;;

	/**
	   * 최초가입시 : Level.BASIC
	   * @param user
	   */
	int add(UserVO user) throws Exception;;

	/**
	   * 사용자 등업
	   * 1. 전체 사용자를 읽어 들인다.
	   * 2. 등업 대상자를 선별한다.
	   *    2.1. BASIC사용자 : 로그인CNT 50이상(=포함)이면 : SILVER
	   *    2.2. SILVER사용자: 추천CNT 30이상(=포함): GOLD
	   *    2.3. GOLD대상 아님.
	   * 3. 등업한다.
	 * @throws SQLException
	   */
	void upgradeLevels(UserVO userVO) throws Exception;

}