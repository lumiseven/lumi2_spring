package com.lumiseven.test_spring4.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {
	
	@Bean
	@Conditional(WindowsCondition.class)
	public ListDirCmdService windowsListService(){
		return new WindowsListDirCmdServiceImpl();
	}
	
	@Bean
	@Conditional(LinuxCondition.class)
	public ListDirCmdService linuxListService(){
		return new LinuxListDirCmdServiceImpl();
	}

}
