package com.test01;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		//today 호출(오늘날짜)
		//Date today = factory.getBean("today",Date.class);
		//System.out.println("today");
		
		
		//2021. 1. 12 startdate
		//이름이 start인 appcontext에 만들어진 객체가져와서 쓰겠다. 
		Date start = factory.getBean("start",Date.class);
		System.out.println(" 스타트데이트 : " + start);
		
		
		
		//이름이 "beanTest"인 appcontext에 만들어진 객체 가져와서 쓰겠다.
		BeanTest bean = (BeanTest) factory.getBean("beanTest");
		
		
		//BeanTest(Date date)호출 : Tue Jan 12 23:17:48 KST 2021
		//Tue Jan 12 23:17:48 KST 2021
		//com/test01/applicationContext.xml을 읽어서 id="beanTest" 객체가 먼저 만들어져서
		//System.out.println(start)를 출력하기 전에 BeanTest(Date date)가 먼저 출력됨. 
	}
}
















