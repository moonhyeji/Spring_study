package com.hello.mvc.model;

import org.springframework.stereotype.Repository;

@Repository   //(안에서 Exception이 일어나면 이것을 DataAccessException으로 변환)
public class HelloDao {
	
	public String getHello() {
		
		//TODO : 06. dao에서 return 
		return "Spring";
	}
}
