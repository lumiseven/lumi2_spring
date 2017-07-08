package com.lumiseven.springhttpmonitor.endpoint;

import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.lumiseven.springhttpmonitor.service.StatusService;

@ConfigurationProperties(prefix = "endpoints.status", ignoreUnknownFields = false)
public class StatusEndPoint extends AbstractEndpoint<String> implements ApplicationContextAware{

	ApplicationContext context;
	
	public StatusEndPoint() {
		super("status");
	}

	@Override
	public String invoke(){
		StatusService statusService = context.getBean(StatusService.class);
		return "The Current Status is: " + statusService.getStatus();
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
		this.context = applicationContext;
	}
	
}
