package com.test07;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


	public class MTest {
		public static void main(String[] args) {
			
			
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
       //ApplicationContext 가 SpringIoC 컨테이너(com/test07/applicationContext.xml) 를 만듦.
		//com/test07/applicationContext.xml 에 의해서 객체생성을 먼저 해놓음. 따라서 xml 의 2개의 bean객체의 class안의 생성자가 자동으로 실행된다!!
		
//		따라서, samsong tv 생성
//		Lg tv 생성! 
//		Lg tv powerOn! 
//		Lg tv powerOff! 
//		Lg tv volumeUp! 
//		Lg tv volumeDown! 
//		로 출력됨.
//여기서 lazyinit 을 사용하면 samsongtv 생성자가 사라짐! 
		
		TV LG = (TV)factory.getBean("Lg");
			
		    LG.powerOn();
			LG.powerOff();
			LG.volumeUp();
			LG.volumeDown();
		}
	
	}
