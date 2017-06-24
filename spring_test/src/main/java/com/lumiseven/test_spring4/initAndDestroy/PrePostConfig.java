package com.lumiseven.test_spring4.initAndDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.lumiseven.test_spring4.initAndDestroy")
public class PrePostConfig {

	@Bean(initMethod="init",destroyMethod="destroy")
	BeanWayInitAndDestroyService beanWayInitAndDestroyService(){
		return new BeanWayInitAndDestroyService();
	}
	
	@Bean
	JSR250WayInitAndDestroyService jsr250WayInitAndDestroyService(){
		return new JSR250WayInitAndDestroyService();
	}
}
