package com.sewon.anyone.board.service.imple;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sewon.anyone.board.service.BoardService;
import com.sewon.anyone.cmn.DTO;
import com.sewon.anyone.member.service.imple.UserServiceImple;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


@Service("boardService")
public class BoardServiceImple extends EgovAbstractServiceImpl implements BoardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImple.class);
	
	@Resource(name = "boardMapper")
	private BoardMapper boardMapper;
	
	@Override
	public int doInsert(DTO dto) throws NullPointerException, Exception  {
		return boardMapper.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) throws NullPointerException, Exception {
		return boardMapper.doUpdate(dto);
	}

	@Override
	public DTO doSelectOne(DTO dto) throws NullPointerException, Exception {
		return boardMapper.doSelectOne(dto);
	}

	@Override
	public int doDelete(DTO dto) throws NullPointerException, Exception {
		return boardMapper.doDelete(dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) throws NullPointerException, Exception {
		return boardMapper.doRetrieve(dto);
	}

	@Override
	public List<?> getAll(DTO dto) throws NullPointerException, Exception {
		return boardMapper.getAll(dto);
	}

}
