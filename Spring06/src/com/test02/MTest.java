package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		Person m = (Person) factory.getBean("man");
		Person w = (Person) factory.getBean("woman");
		
		System.out.println("남학생 입장.");
		m.classWork();
		System.out.println("-----------------");
		System.out.println("여학생 입장");
		w.classWork();		
	}
}

/*
 * 
 * joinpoint : ccc에 cc를 연결할 수 있는 모든 포인트 
 * 			 :프로그램 실행 되는데 있어 객체 생성이나 메소드호출같은 특정 시점(ccc에 cc를 연결할 수 있는)들을 지칭한다..
 
 *  pointcut: 호출되고 있는 cc를 target이라고 한다면, cc를 호출할 때 어떤 상황에서 ccc와 cc를 연결할를 알려주는 것이 포인트것이다.
 *  
 *  
 *  ccc와 cc를 연결할 때 proxy라는 것이 호출을 대신 받아준다.(자신이 target인 것처럼.). 
 *  여기서 before 와 after가 ccc(공통관심사항) -> ccc를 다른말로 advice라고 한다.
 *  
 *  
 *  advice와 pointcut을 합치면 advisor 가 된다. 
 *  advisor에 의해서 ccc와 cc가 합쳐지게 되고, 합쳐져서 흐름에 엮이는 것을 weaving이라고 한다.
 *
 */





























