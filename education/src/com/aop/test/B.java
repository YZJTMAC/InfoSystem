package com.aop.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class B {
	
	public void doBefore(JoinPoint joinPoint){
		System.out.println("====before====");
	}
	
	public void doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("====aroundBefore====");
		proceedingJoinPoint.proceed();
		System.out.println("====aroundAfter====");
	}
	
	public void doAfter(JoinPoint joinPoint){
		System.out.println("====after====");
	}
	
	public void doReturn(JoinPoint joinPoint){
		System.out.println("====doReturn====");
	}
	
	public void doThrowing(JoinPoint joinPoint,Throwable t){
		System.out.println("====doThrowing====");
	}
	
}
