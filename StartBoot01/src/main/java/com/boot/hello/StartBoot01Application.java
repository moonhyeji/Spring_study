package com.boot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@SpringBootApplication
public class StartBoot01Application {

	public static void main(String[] args) {
		SpringApplication.run(StartBoot01Application.class, args);
		//메인메소드: 프로그램의 주 진입점. 프로그램을 실행시켜주는 애
	}
	
	@GetMapping("/index")   //get으로 넘기니까 getmapping 
	public String index() {
		return "index";
	}

}
