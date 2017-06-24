package com.lumiseven.test_spring4.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
		
		ListDirCmdService listDirCmdService = context.getBean(ListDirCmdService.class);
		System.out.println(context.getEnvironment().getProperty("os.name") + " use " + listDirCmdService.showListDirCmd() + " to list dir");
		context.close();
	}

}
