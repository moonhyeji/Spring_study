package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object target = null;
		
		System.out.println("출석카드 찍는다.");   //before --타겟 전 실행 
		
		try {
			target = invocation.proceed();  // 타겟실행 
		}catch(Exception e) {
			System.out.println("쉬는 날 이였다.");
		}finally {
			System.out.println("집에 간다."); //after --타겟실행 이후 실행 
		}
		return target;
	}
}                  //이 형태를 가지고 실행을 끝낸다.
