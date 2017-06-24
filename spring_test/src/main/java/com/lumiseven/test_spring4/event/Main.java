package com.lumiseven.test_spring4.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	/*
	 * 在publisher bean 中注入applicationContext，通过applicationContext 的publishEvent 方法推送 [指定类型的event] 消息
	 * 在需要监听的 bean 中实现applicationListener<[event]> 方法
	 */
	public static void main(String[] args){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
		
		DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
		demoPublisher.publish("demoPublisher publish application event");
		context.close();
	}
	
}
