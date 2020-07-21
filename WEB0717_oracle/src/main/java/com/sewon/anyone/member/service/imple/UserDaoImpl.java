package com.sewon.anyone.member.service.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sewon.anyone.cmn.DTO;
import com.sewon.anyone.member.service.UserDao;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("userDAO")
public class UserDaoImpl extends EgovAbstractDAO implements UserDao {

	//Logger
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	
	public UserDaoImpl() {}

	@Override
	public int passCheck(DTO dto) {
		return (int) select("userDAO.passCheck", dto);
	}

	@Override
	public int idCheck(DTO dto) {
		return (int) select("userDAO.idCheck", dto);
	}

	@Override
	public int doInsert(DTO dto) {
		return (int) insert("userDAO.doInsert", dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		return (int) update("userDAO.doUpdate", dto);
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		return (DTO) select("userDAO.doSelectOne", dto);
	}

	@Override
	public int doDelete(DTO dto) {
		return (int) delete("userDAO.doDelete", dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		return  list("userDAO.doRetrieve", dto);
	}

	@Override
	public List<?> getAll(DTO dto) {
		return list("userDAO.getAll", dto);
	}

	@Override
	public int idPassCheck(DTO dto) {
		return (int) select("userDAO.idPassCheck", dto);
	}

}
