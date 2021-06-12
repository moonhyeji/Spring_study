package com.test06;

public class MTest {

	public static void main(String[] args) {
		
		
		BeanFactory factory = new BeanFactory();
        
		
		
		//factory변수에 의해서  TV lg = new LgTV(); 형태로 됨. 아래와 같음. ㅌ		
		TV tv = (TV)factory.getBean("lg");
 
		//TV tv = (TV)factory.getBean("smasong"); 이라면 samsongtv 객체가 만들어져서 출력됨. 
		
		
		tv.powerOn();
		tv.powerDown();
		tv.volumeup();
		tv.volumeDown();
	}
}
