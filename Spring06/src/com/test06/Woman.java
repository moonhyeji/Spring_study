package com.test06;

import org.springframework.stereotype.Component;

@Component  // component scan  걸려있으니까 annotation component 걸어서 객체화 시켜주기 
public class Woman implements Person {

	@Override
	public void classWork() {
         System.out.println("컴퓨터를 켜서 웹서핑을 한다.");
	}

}
