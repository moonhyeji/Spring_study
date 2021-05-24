package com.test02;

public class MTest {
	
	public static void main(String[] args) {
		
	
  MessageBean bean = new MessageBeanEn();
  bean.sayHello("spring");
  
  bean = new MessageBeanKo();
  bean.sayHello("스프링");
 }
}
