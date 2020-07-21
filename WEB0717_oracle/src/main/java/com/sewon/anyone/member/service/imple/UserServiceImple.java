package com.sewon.anyone.member.service.imple;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sewon.anyone.cmn.DTO;
import com.sewon.anyone.member.service.UserDao;
import com.sewon.anyone.member.service.UserService;
import com.sewon.anyone.member.service.UserVO;

import egovframework.example.sample.service.impl.EgovSampleServiceImpl;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("userService")
public class UserServiceImple extends EgovAbstractServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImple.class);
	
	@Resource(name = "userMapper")
	private UserMapper userMapper;
	
	
	@Override
	public int idPassCheck(DTO dto) throws NullPointerException, Exception  {
		return userMapper.idPassCheck(dto);
	}

	@Override
	public int doInsert(DTO dto) throws NullPointerException, Exception {
		return userMapper.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) throws NullPointerException, Exception {
		return userMapper.doUpdate(dto);
	}

	@Override
	public DTO doSelectOne(DTO dto) throws NullPointerException, Exception {
		return userMapper.doSelectOne(dto);
	}

	@Override
	public int doDelete(DTO dto) throws NullPointerException, Exception {
		return userMapper.doDelete(dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) throws NullPointerException, Exception {
		return userMapper.doRetrieve(dto);
	}

	@Override
	public int add(UserVO user) {
		return 0;
	}

	@Override
	public void upgradeLevels(UserVO userVO) throws Exception {

		
	}

}
