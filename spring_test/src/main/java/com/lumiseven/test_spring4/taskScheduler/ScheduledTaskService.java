package com.lumiseven.test_spring4.taskScheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	public void currentTime(){
		System.out.println("execute every 5 seconds" + dateFormat.format(new Date()));
	}
	
	@Scheduled(cron = "0 14 1 ? * *")
	public void executeInSpecialTime(){
		System.out.println("execute in special time point" + dateFormat.format(new Date()));
	}
}
