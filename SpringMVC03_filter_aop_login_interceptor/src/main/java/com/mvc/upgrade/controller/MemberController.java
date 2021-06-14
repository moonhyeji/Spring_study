package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberBiz biz;
	
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("[Controller] loginform.do");
		
		return "memberlogin";
	}
	
	@ResponseBody
	@RequestMapping(value="/ajaxlogin.do",method=RequestMethod.POST)
	public Map<String,Boolean> ajaxLogin(@RequestBody MemberDto dto, HttpSession session){
		logger.info("[Controller] ajaxlogin.do");
		/*
		 * @RequestBody: request 객체의 body 에 저장되어 넘어오는 데이터 -> java object 에 binding 
		 *              :json  객체(java가 아닌 애를 ) 를 자바로 바꿔준다.
		 *              
		 * @ResponseBody: java object -> response 객체의 body 에 binding 
		 *              :자바 객체가 response 객체에 바로 담겨버림 
		 *              
		 *              
		 *       
		 * */
		MemberDto res = biz.login(dto);
		boolean check = false;
		
		if(res != null) {
			check = true;
			session.setAttribute("login", res);
		}
		Map<String, Boolean> map = new HashMap<String,Boolean>();
		map.put("check", check);
		
		return map;
	}
}














