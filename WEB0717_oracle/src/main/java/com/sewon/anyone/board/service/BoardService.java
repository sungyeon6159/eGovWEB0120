/**
 *  BoardService Interface
 */
package com.sewon.anyone.board.service;

import java.util.List;

import com.sewon.anyone.cmn.DTO;

/**
 * @author Sewonit
 *
 */
public interface BoardService {
	/**
	 * 등록
	 * 
	 * @param dto
	 * @return int
	 */
	public int doInsert(DTO dto) throws NullPointerException, Exception;

	/**
	 * 수정
	 * 
	 * @param dto
	 * @return int
	 */
	public int doUpdate(DTO dto) throws NullPointerException, Exception;

	/**
	 * 단건조회
	 * 
	 * @param dto
	 * @return DTO
	 */
	public DTO doSelectOne(DTO dto) throws NullPointerException, Exception;

	/**
	 * 삭제
	 * 
	 * @param dto
	 * @return int
	 */
	public int doDelete(DTO dto) throws NullPointerException, Exception;

	/**
	 * 목록조회
	 * 
	 * @param dto
	 * @return
	 */
	public List<?> doRetrieve(DTO dto) throws NullPointerException, Exception;

	/**
	 * 전체 조회
	 * 
	 * @param dto
	 * @return
	 */
	public List<?> getAll(DTO dto) throws NullPointerException, Exception;
}
