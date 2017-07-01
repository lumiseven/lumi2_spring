package com.lumiseven.websockettest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/test_websocket").setViewName("/test_websocket");
		registry.addViewController("/login").setViewName("/login");
		registry.addViewController("/chat").setViewName("/chat");
		registry.addViewController("/bootstrap_base_template").setViewName("/bootstrap_base_template");
	}
	
}
