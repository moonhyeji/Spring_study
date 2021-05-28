package com.boot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.jdbc.model.biz.MYBiz;

@Controller
@SpringBootApplication
public class StartBoot02Application {

	@Autowired
	private MYBiz biz;
	
	public static void main(String[] args) {  //메인메소드: 프로그램의 주 진입점. 프로그램을 실행시켜주는 애 
		SpringApplication.run(StartBoot02Application.class, args);
	}

	
	@GetMapping("/index")
	public String root() {
		return "index";
	}
	
	@GetMapping("/select")
	public String selectOne(Model model, int myno) {
		model.addAttribute("dto", biz.selectOne(myno));
		return "myboardselect";
	}

}
