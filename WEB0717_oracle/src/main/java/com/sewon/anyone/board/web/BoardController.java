/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sewon.anyone.board.web;

import java.util.List;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.example.sample.service.impl.EgovSampleServiceImpl;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.google.gson.Gson;
import com.sewon.anyone.cmn.MessageVO;
import com.sewon.anyone.member.service.UserService;
import com.sewon.anyone.member.service.UserVO;

/**
 * @Class Name : BoardController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @
 *   2009.03.16 최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 * 		Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class BoardController {

	final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

	// ERROR -> context-common.xml 수정
	@Resource(name = "userService")
	private UserService userService;

	/** EgovSampleService */
	@Resource(name = "sampleService")
	private EgovSampleService sampleService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	// http://localhost:8080/WEB0716/member/login.do
	/**
	 * 
	 * @param searchVO
	 * @param user
	 * @param model
	 * @return json
	 * @throws Exception
	 */
	@RequestMapping(value ="/board/board.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String dologin(@ModelAttribute("searchVO") SampleDefaultVO searchVO, UserVO user, ModelMap model)
			throws Exception {

		LOGGER.debug("------dologin-------");
		LOGGER.debug("------dologin-------" + searchVO);
		LOGGER.debug("------dologin-------" + user);

		 /** EgovPropertyService.sample */
		 searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		 searchVO.setPageSize(propertiesService.getInt("pageSize"));
		
		 /** pageing setting */
		 PaginationInfo paginationInfo = new PaginationInfo();
		 paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		 paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		 paginationInfo.setPageSize(searchVO.getPageSize());
		
		 searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		 searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		 searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		 List<?> sampleList = sampleService.selectSampleList(searchVO);
		 model.addAttribute("resultList", sampleList);
		
		 int totCnt = sampleService.selectSampleListTotCnt(searchVO);
		 paginationInfo.setTotalRecordCount(totCnt);
		 model.addAttribute("paginationInfo", paginationInfo);

		// mybatis debug Url :
		// http://localhost:8080/WEB0716/login/login.do?userId=psy&passwd=1234

		// 1.idPassCheck() call
		// 1.1. return 10 -> "아이디를 확인하세요."
		// 1.2. return 20 -> "비밀번호를 확인하세요."
		// 1.3. return 30 -> "로그인 성공"

		LOGGER.debug("1===================");
		LOGGER.debug("1=user=" + user);
		LOGGER.debug("1===================");

		// userId & passWd == null
		String message = "";
		if (null == user.getUserId() || "".equals(user.getUserId().trim())) {
			message = "아이디를 입력하세요.";
			throw new IllegalArgumentException(message);
		}

		// 비밀번호가 널이면
		if (null == user.getPasswd() || "".equals(user.getPasswd().trim())) {
			message = "비밀번호를 확인하세요.";
			throw new IllegalArgumentException(message);
		}

		// 아이디와 비밀번호가 맞는지 체크
		int flag = this.userService.idPassCheck(user);
		LOGGER.debug("-----idpasscheck COUNT(*)== " + flag);
		MessageVO messageVO = new MessageVO();
		messageVO.setMsgId(String.valueOf(flag));

		// 아이디가 맞지 않음
		if (10 == flag) {
			messageVO.setMsgMsg("아이디를 확인하세요.");
			// 비밀번호가 맞지 않음
		} else if (20 == flag) {
			messageVO.setMsgMsg("비밀번호를 확인하세요.");
			// 로그인에 성공
		} else if (30 == flag) {
			messageVO.setMsgMsg("로그인을 성공했습니다.");

			// 사용자 정보 조회
			UserVO userInfo = (UserVO) this.userService.doSelectOne(user);
			LOGGER.debug("2===================");
			LOGGER.debug("2=userInfo=" + userInfo);
			LOGGER.debug("2===================");

			model.addAttribute("user", userInfo);
		}

		Gson gson = new Gson();
		String json = gson.toJson(messageVO);
		LOGGER.debug("2===================");
		LOGGER.debug("2=json=" + json);
		LOGGER.debug("2===================");

		return json;

	}

	/**
	 * 아이디 비밀번호 찾기
	 * 
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/board01.do")
	public String idpassCheck(@ModelAttribute("searchVO") SampleDefaultVO searchVO, ModelMap model) throws Exception {

		LOGGER.debug("------idpassCheck()-------");

		// /** EgovPropertyService.sample */
		// searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		// searchVO.setPageSize(propertiesService.getInt("pageSize"));
		//
		// /** pageing setting */
		// PaginationInfo paginationInfo = new PaginationInfo();
		// paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		// paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		// paginationInfo.setPageSize(searchVO.getPageSize());
		//
		// searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		// searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		// searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		//
		// List<?> sampleList = sampleService.selectSampleList(searchVO);
		// model.addAttribute("resultList", sampleList);
		//
		// int totCnt = sampleService.selectSampleListTotCnt(searchVO);
		// paginationInfo.setTotalRecordCount(totCnt);
		// model.addAttribute("paginationInfo", paginationInfo);

		return "sample/egovSampleList";
	}

}
