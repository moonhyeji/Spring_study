package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
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
		
		if(res != null) {             //로그인하는 비번       //저장된(암호화된)비번 
			if(passwordEncoder.matches(dto.getMemberpw(), res.getMemberpw()))//내가 로그인하면서 넣은 비번이랑 디비에 있는 비번이랑 같은지 확인
			//이제 admin1234는 못씀 -통신실패
		    check = true;
			session.setAttribute("login", res);
		}
		Map<String, Boolean> map = new HashMap<String,Boolean>();
		map.put("check", check);
		
		return map;
	}
    @RequestMapping("/registerform.do")
	public String registerForm() {
		return "memberinsert";
	}
    
    @RequestMapping("/register.do")
    public String registRes(MemberDto dto) {
    	
    	System.out.println(" 암호화 전: " + dto.getMemberpw());
    	
    	dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));
    	
    	System.out.println(" 암호화 후:" +dto.getMemberpw());
    	
    	if(biz.insert(dto) > 0) {
    		return "redirect:loginform.do";
    	}
    	
    	return "redirect:registerform.do";
    }


}














