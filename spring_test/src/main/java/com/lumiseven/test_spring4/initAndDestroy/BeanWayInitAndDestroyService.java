package com.lumiseven.test_spring4.initAndDestroy;

public class BeanWayInitAndDestroyService {

	public void init(){
		System.out.println("@Bean-init-method");
	}
	
	public BeanWayInitAndDestroyService(){
		super();
		System.out.println("初始化构造方法");
	}
	
	public void destroy(){
		System.out.println("@Bean-destory-method");
	}
}
