package com.lumiseven.test_spring4.taskScheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.lumiseven.test_spring4.taskScheduler")
@EnableScheduling
public class TaskSchedulerConfig {

}
