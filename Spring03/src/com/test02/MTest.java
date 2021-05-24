package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
 
	public static void main(String[] args) {
		//등록된 bean 모두 출력 
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		Emp 우유 = factory.getBean("우유" , Emp.class);
		Emp 허브 = (Emp) factory.getBean("허브");
		
		System.out.println(우유);
		System.out.println(허브);
	}
}
