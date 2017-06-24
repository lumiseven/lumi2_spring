package com.lumiseven.test_spring4.aop1;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	@Pointcut("@annotation(com.lumiseven.test_spring4.aop1.AddAction)")//注解方式申明切点
	void annotationPointCut(){}

	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		AddAction action = method.getAnnotation(AddAction.class);
		System.out.println("注解式拦截" + action.name());
	}
	
	@Before("execution(* com.lumiseven.test_spring4.aop1.DemoMethodService.*(..))")
	public void before(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法拦截" + method.getName());
	}
}
