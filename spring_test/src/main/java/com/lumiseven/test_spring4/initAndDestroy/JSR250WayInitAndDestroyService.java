package com.lumiseven.test_spring4.initAndDestroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayInitAndDestroyService {

	@PostConstruct
	public void init(){
		System.out.println("@jsr250-init-method");
	}
	
	public JSR250WayInitAndDestroyService(){
		super();
		System.out.println("初始化构造方法");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("@jsr250-destory-method");
	}
	
}
