package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/a.xml");
		// applicationcontext타입으로 바꿔서 값을 가져온다. (applicationcontext의 주소가 들어와야 한다. )

		Emp lee = (Emp) factory.getBean("lee");
//다형성!******공부 
//가져오는 값이 원래는  developer의 형태인데, 내용물은 developer껍데기는 emp. 이다.
//(자식은 부모껍데기 들어갈 수 있음.

//	Engineer lee = (Emp) factory.getBean("lee");  --->(x)
		// 자식형태가 가진 메소드를부모가 가지고 잇어서.
//부모보다 값이 적으면 문제가 생김!!
		Emp hong = factory.getBean("hong", Emp.class);
//    Emp hong = factory.getBean("hong", Engineer.class);

		// ("이름", Emp.class)/ type= Emp라는 class 형태.
		System.out.println(lee);
		System.out.println(hong);
	}
}
