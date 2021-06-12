package com.test01.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MTest {
 
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/anno/applicationContext.xml");
		 
		MyNickNamePrn myNick = (MyNickNamePrn) factory.getBean("myNickNamePrn");
		System.out.println(myNick);
	}
}
/*
 NickName.java 에 NickName 이라는 객체를 만들어 놓음.  -> NickName에 component 걸어놨으니까 첫글자 소문자인 nickName 이라는 객체가 만들어짐.

MyNickNamePrn에 autowired를 통해서 타입이 NickName 인 애들의 값이 자동으로 주입된다. (DI 의 메소드주입 (필드주입))
*
*
*/