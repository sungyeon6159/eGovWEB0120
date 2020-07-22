/**
 * 
 */
package com.sewon.anyone.board.service.imple;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.sewon.anyone.board.service.BoardDao;
import com.sewon.anyone.cmn.DTO;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

/**
 * @author Sewonit
 *
 */
@Repository("boardMapper")
public class BoardMapper extends EgovAbstractMapper implements BoardDao {

	@Resource(name = "sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}
	
	
	@Override
	public int doUpdateReadCnt(DTO dto) throws NullPointerException, Exception  {
		return (int) update("doUpdateReadCnt",dto);
	}

	@Override
	public int doInsert(DTO dto) throws NullPointerException, Exception {
		return (int) insert("doInsert",dto);
	}

	@Override
	public int doUpdate(DTO dto) throws NullPointerException, Exception {
		return (int) update("doUpdate",dto);
	}

	@Override
	public DTO doSelectOne(DTO dto) throws NullPointerException, Exception {
		return (DTO) selectOne("doSelectOne", dto);
	}

	@Override
	public int doDelete(DTO dto) throws NullPointerException, Exception {
		return (int) delete("doDelete", dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) throws NullPointerException, Exception {
		return  list("doRetrieve", dto);
	}

	@Override
	public List<?> getAll(DTO dto) throws NullPointerException, Exception {
		return list("getAll", dto);
	}

}
