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
	
	@ResponseBody                         //값을 넘기는 방식을 고정 (무조건 post로만 넘겨야!)
	@RequestMapping(value="/ajaxlogin.do", method=RequestMethod.POST)
   // 바로 주소창에ajaxlogin.do 치면, @RequestBody는 body 에 저장된 값을 변환시켜주는데 ,주소창 주소(get방식)는 header에 담겨서 가는 거니까,415에러 뜸. 
	public Map<String,Boolean> ajaxLogin(@RequestBody MemberDto dto, HttpSession session){
		logger.info("[Controller] ajaxlogin.do");
		/*
		 * @RequestBody: request 객체의 body 에 저장되어 넘어오는 데이터 -> java object 에 binding 
		 *              :json  객체(java가 아닌 애를 ) 를 자바로 바꿔준다.
		 *               
		 *             //****get으로 바꾸면 값이 header로 들어가니까. get형태로 넘기면 오류난다!  
		 * RequestBody  :client 에서 server로 값을 넘겨줄 때 값이 body에 저장되는데. post의 json형태의 값이다.
		 * (  : post 형태로 넘기면 값은 바디에 저장 ,바디에 저장된 값은 json 형태이다.
		 *  json형태로 넘어온 값을 자기들이 쓸수 있도록 자바 객체로 바꿔주는 애. + 값을 담아줌.   
		 *              이 jason형태의 값을 java형태로 바꿔서 server에서 사용할 수 있도록 해주는 애가  @RequestBody.
		 *              :이 자바객체로 만든 값을 MemberDto 형태의 dto에 값을 담아줌. 
		 *               
		 *               
		 *               
		 * @ResponseBody를  @RequestMapping 메소드에 적용시키면, 해당 메소드의 리턴 값을 json 형태로 바꿔서 client로 바로 전송한다.                 
		 * @ResponseBody:
                        :java object -> response 객체의 body 에 binding 
		 *              :  @ResponseBody를 메소드에 적용시키면 리턴값을 response객체에 담아주고, 바로 클라이언트로 보낸다.
		 *              (modelandview에 담아서 viewresolver를 거치는 작업을 안하고)
		 *              +client로  response 해주는 거는  responsebody고, java를 jason으로 바꿔주는건 jackson이 해준다.
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














