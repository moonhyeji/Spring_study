package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class MyAspect {
	
	
	//target 실행 전
	@Before("execution(public * *(..))")    
	public void before(JoinPoint join) {
		
		System.out.println("출석카드를 찍는다.");
	}
	
	// target을 호출하는 상황에서 예외가 발생했을 때.
	@AfterThrowing("execution(public * *(..))")  
	public void throwing(JoinPoint join) {
		System.out.println("쉬는 날 이였다.");
	}
	
	//정상적으로 실행된 이후 return 되는 값을 받아서 실행
	@AfterReturning(pointcut="execution(public * *(..))", returning="returnVal")   
	public void returning(JoinPoint join, Object returnVal) {
	    
		System.out.println(returnVal + "공부하는 날이였다.");
	}
	
	
	//target실행 후
	@After("execution(public * *(..))")   
	public void after(JoinPoint join){
		System.out.println("집에 간다.");
		
	}
}
