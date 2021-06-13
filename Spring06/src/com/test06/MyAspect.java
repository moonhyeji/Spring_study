package com.test06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Component  // component scan  걸려있으니까 annotation component 걸어서 객체화 시켜주기 
@Aspect
public class MyAspect {
	
	
	
	@Before("execution(public * *(..))")    //pointcut을 ("execution(public * *(..))" 이렇게 잡아줘도 되고,  
	public void before() {
		System.out.println("출석카드를 찍는다.");
	}
	
	
	@After("myClass()")
	public void after() {
		System.out.println("집에 간다.");
	}
	
	
	
	
	//포인트컷 이렇게 따로 아줘도 됨. 
	@Pointcut("execution(public * *(..))") 
	public void myClass() {
	    //사용 안해도 됨. 
	}

}
