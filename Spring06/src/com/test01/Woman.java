package com.test01;

public class Woman {

	public void classWork() {
		System.out.println("출석카드 찍는다.");
		
		try {
			System.out.println("컴퓨터를 켜서 웹서핑을 한다.");
		}catch(Exception e) {
			System.out.println("쉬는 날 이였다....");
		}finally {
			System.out.println("집에 간다.");
		}
		
	}

}

/*
 * 
 *  공통적인 부분: cross cutting concern
	public void classWork() {
		System.out.println("출석카드 찍는다.");
		
		try {
		------------------------------
		}catch(Exception e) {
			System.out.println("쉬는 날 이였다....");
		}finally {
			System.out.println("집에 간다.");
		}
		
	}
	
	
	
 핵심적인 부분: core concern 
  	Woman에서의 :  System.out.println("컴퓨터를 켜서 웹서핑을 한다.");
	Man 에서의 :   System.out.println("컴퓨터를 켜서 유투브를 본다. ");

  

 * */
