package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.HelloBiz;


@Controller
public class HelloController {

	@Autowired  //자동으로 객체값 주입 
	private HelloBiz biz;
	
	//TODO : 03. handlerMapping(/hello.do)을 통해 해당 컨트롤러의 메소드로 request전달 
	@RequestMapping("/hello.do")
	public String getHello(Model model) {    //모델객체 만든적은 없지만 스프링이 알아서 모델객체 만들어서 줌.
		
		//TODO : 04. biz(@Service)호출 
		model.addAttribute("message", biz.getHello());   //얘가 model.
		
		//TODO : 08. return받은 값을 model객체에 담아서, ModelAndView 객체를 hello-servlet으로 전달 
		return "/WEB-INF/views/hello.jsp";  //얘가 viewName :어떤 view를 response해줄건지.
		
		
		// ModelAndView 객체 : 스프링이 알아서 넣어놓은 model을 viewName으로 한 것을 담은 것. 
		
	}
	
	//bye.do의 modelandview를 사용하는 이건 옛날방식!
	//TODO : 10. handlerMapping(/bye.do)
	@RequestMapping("/bye.do")
	public ModelAndView getBye(@RequestParam("name")String name) {
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("message","Bye," + name);
		mav.setViewName("/WEB-INF/views/bye.jsp");
		
		
		return null;
	}
	
}


















