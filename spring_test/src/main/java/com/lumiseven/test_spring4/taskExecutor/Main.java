package com.lumiseven.test_spring4.taskExecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	/*
	 * Spring asynchronized method support
	 */
	public static void main(String[] args){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
		
		AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
		
		for (int i = 0; i < 17; i++){
			asyncTaskService.executeAsyncTaskMethod(i);
			asyncTaskService.executeAsyncTaskMethodSecond(i);
		}
		
		context.close();
	}
	
}
