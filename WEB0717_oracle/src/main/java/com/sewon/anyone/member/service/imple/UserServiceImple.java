package com.sewon.anyone.member.service.imple;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sewon.anyone.cmn.DTO;
import com.sewon.anyone.member.service.UserDao;
import com.sewon.anyone.member.service.UserService;
import com.sewon.anyone.member.service.UserVO;

import egovframework.example.sample.service.impl.EgovSampleServiceImpl;

@Service("userService")
public class UserServiceImple implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImple.class);

	@Resource(name = "userDAO")
	private UserDao userDao;
	
	
	@Override
	public int idPassCheck(DTO dto) {
		return userDao.idPassCheck(dto);
	}

	@Override
	public int doInsert(DTO dto) {
		return userDao.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		return userDao.doUpdate(dto);
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		return userDao.doSelectOne(dto);
	}

	@Override
	public int doDelete(DTO dto) {
		return userDao.doDelete(dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		return userDao.doRetrieve(dto);
	}

	@Override
	public int add(UserVO user) {
		return 0;
	}

	@Override
	public void upgradeLevels(UserVO userVO) throws Exception {

		
	}

}
