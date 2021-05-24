package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
	
	    AbstractTest today = factory.getBean("singleton",AbstractTest.class);
	      
	    System.out.println("오늘요일 : " + today.dayInfo() );
	}
}

/*
싱글톤 레지스트리
스프링은 직접  
 
 */




