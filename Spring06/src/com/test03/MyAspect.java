package com.test03;

import org.aspectj.lang.JoinPoint;

//CCC (Cross Cutting Concern)
public class MyAspect {

	
//	public void before() {
//		System.out.println("출석카드를 찍는다.");
//	}

	
	public void before(JoinPoint join) {  //joinpoint 중 pointcut에 의해 연결되는 정보 가져옴
		System.out.println(join.getTarget().getClass());  //target 이 어떤 classtype인가?
		System.out.println(join.getSignature().getName());  //target 의 실제로 실행될 method이름을 가져와라 
		System.out.println("출석카드를 찍는다.");
		
/* 출력값:  
여학생 입장
class com.test03.Woman
classWork
출석카드를 찍는다.
 컴퓨터를 키고 웹서핑을 한다.
집에 간다.
------------------
남학생 입장
class com.test03.Man
classWork
출석카드를 찍는다.
 컴퓨터를 키고 유투브를 본다.
집에 간다.
*/
	}

	
	public void after() {
		System.out.println("집에 간다.");
	}
}
