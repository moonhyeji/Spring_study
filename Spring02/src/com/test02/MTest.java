package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");

	Address 허브 = (Address) factory.getBean("허브");
	Address 에스프레소 = (Address) factory.getBean("에스프레소");
//	오브젝트가 더 크기 때문에 addres를 명시적 형변환 해줌. <??
	
    System.out.println(허브);
    System.out.println(에스프레소);
	}
}


