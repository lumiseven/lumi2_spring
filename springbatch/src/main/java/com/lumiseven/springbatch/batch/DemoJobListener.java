package com.lumiseven.springbatch.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class DemoJobListener implements JobExecutionListener{

	long startTime;
	
	long endTime;
	
	@Override
	public void afterJob(JobExecution arg0) {
		startTime = System.currentTimeMillis();
		System.out.println("job start");
	}

	@Override
	public void beforeJob(JobExecution arg0) {
		endTime = System.currentTimeMillis();
		System.out.println("job end");
		System.out.println("using time: " + (endTime - startTime) + "ms");
	}

}
