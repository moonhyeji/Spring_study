package com.test04;

public class Man implements Person {

	@Override
	public String classWork() {
		String s =null;
		s.length();
		
		/*콘솔 : 
		 * 
		남학생입장
		출석카드를 찍는다.   //before
		쉬는 날 이였다.   //afterThrowing
		집에 간다.      //after 
		Exception in thread "main" java.lang.NullPointerException:*/
		
		
		System.out.println("컴퓨터 켜서 유투브 한다.");
		
		return "스프링";
	}

}
