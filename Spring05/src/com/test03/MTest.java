package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		TV samson = (TV) factory.getBean("samson");
		TV lg = (TV) factory.getBean("lg");
		
		samson.powerOn();
		lg.powerOn();
	}

}
