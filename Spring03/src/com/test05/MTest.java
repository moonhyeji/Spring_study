package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");

	Developer lee = factory.getBean("leess", Developer.class);
	// Engineer hong = (Engineer) factory.getBean("honggd");
	Engineer hong = factory.getBean("honggd", Engineer.class);
	
	
	
	
	System.out.println(lee.s());
	System.out.println(hong);
    //System.out.println(hong.toString());  위와 같은 값을 리턴.
	//.toString() 이 생략된 형태고, 자동으로 붙어서 출력됨.

   //syso에서 리턴될 때 tostirng 의 return값을 읽어온다!
	}
}
