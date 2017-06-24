package com.lumiseven.test_spring4.aop1;

import org.springframework.stereotype.Service;

@Service
public class DemoMethodService {
	
	//拦截add方法
	public void add(){
		System.out.println("method add");
	}

}
