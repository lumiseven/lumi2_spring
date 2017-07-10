package com.lumiseven.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SomeHystrixService {
	
	@Autowired
	RestTemplate restTemplate;//在spring boot下使用ribbon，只需注入一个RestTemplate即可，spring boot已做好配置
	
	@HystrixCommand(fallbackMethod="fallbackSome")
	public String getSome(){
		return restTemplate.getForObject("http://some/getsome", String.class);
	}
	
	public String fallbackSome(){
		return "some service module fail";
	}

}
