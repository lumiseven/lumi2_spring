package com.lumiseven.test_spring4.aop1;
import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
	
	//拦截Action注解和add方法
	@AddAction(name="注解式拦截的add操作")
	public void add(){
		System.out.println("Annotation add");
	}

}
