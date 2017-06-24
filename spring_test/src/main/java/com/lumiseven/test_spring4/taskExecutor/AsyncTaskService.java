package com.lumiseven.test_spring4.taskExecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
	
	@Async
	public void executeAsyncTaskMethod(Integer i){
		System.out.println("asynchronized task: " + i);
	}
	
	@Async
	public void executeAsyncTaskMethodSecond(Integer i){
		System.out.println("asynchronized task second: " + ++i);
	}

}
