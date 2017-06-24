package com.lumiseven.test_spring4.springEL;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Elconfig.class);
		
		Elconfig resourceService = context.getBean(Elconfig.class);
		
		resourceService.outputResource();
		
		context.close();
	}
}
