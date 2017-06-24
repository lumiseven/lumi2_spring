package com.lumiseven.test_spring4.initAndDestroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);
		
		BeanWayInitAndDestroyService beanWayInitAndDestroyService = context.getBean(BeanWayInitAndDestroyService.class);
		JSR250WayInitAndDestroyService jsr250WayInitAndDestroyService = context.getBean(JSR250WayInitAndDestroyService.class);
		
		context.close();
	}
	
}
