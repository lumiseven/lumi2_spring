package com.lumiseven.test_spring4.annotation;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
	
	public void outputResult(){
		System.out.println("custom annotation");
	}

}
