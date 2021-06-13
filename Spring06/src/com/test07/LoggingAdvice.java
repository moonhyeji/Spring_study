package com.test07;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor {

	
	
	// 얘가 ccc. 
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		 String methodName = invocation.getMethod().getName();
		 
		 
		 StopWatch timer = new StopWatch();
		 
		 timer.start(methodName);   //before
		 System.out.println("[LOG] METHOD :" + methodName + "is Calling");   //before
		 Object obj = invocation.proceed();   // target 
		 timer.stop();   //after
		 System.out.println("[LOG] METHOD :" + methodName + "was Calling");  //after
		 System.out.println("[LOG] METHOD :" + timer.getTotalTimeSeconds() + "sec ");  //after

		return obj;
	}

}
















