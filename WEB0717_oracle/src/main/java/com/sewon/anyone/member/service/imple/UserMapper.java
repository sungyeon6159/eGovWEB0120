package com.sewon.anyone.member.service.imple;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.sewon.anyone.cmn.DTO;
import com.sewon.anyone.member.service.UserDao;
import com.sewon.anyone.member.service.UserVO;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("userMapper")
public class UserMapper extends EgovAbstractMapper implements UserDao {
	
	/**@Resource (name = "context-mapper.xml에서  SqlSession의 id와 매칭 ->> SqlSessionFactoryBean 안에 dataSource
	& mapperLocation의 위치
	& typeAlias를 사용할 config.xml 의 configLocation 설정   ")
	*/
    @Resource(name = "sqlSession")
    public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
    	super.setSqlSessionFactory(sqlSession);
    }
	
	
	@Override
	public int passCheck(DTO dto) throws NullPointerException, Exception {
		return (int) selectOne("passCheck", dto);
	}

	@Override
	public int idCheck(DTO dto) throws NullPointerException, Exception {
		return (int) selectOne("idCheck", dto);
	}

	@Override
	public int doInsert(DTO dto) throws NullPointerException, Exception {
		return (int) insert("doInsert", dto);
	}

	@Override
	public int doUpdate(DTO dto) throws NullPointerException, Exception {
		return (int) update("doUpdate", dto);
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

	@Override
	public int idPassCheck(DTO dto) throws NullPointerException, Exception {
		return (int) selectOne("idPassCheck", dto);
	}

}
