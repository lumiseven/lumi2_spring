package com.lumiseven.springhttpmonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumiseven.springhttpmonitor.endpoint.StatusEndPoint;
import com.lumiseven.springhttpmonitor.service.StatusService;

@RestController
public class DemoApplication {
	
	@Autowired
	StatusService statusService;
	
	@Bean
	public Endpoint<String> status(){
		Endpoint<String> status = new StatusEndPoint();
		return status;
	}
	
	@RequestMapping("/change")
	public String changeStatus(String status){
		statusService.setStatus(status);
		return "OK";
	}

}
