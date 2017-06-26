package com.lumiseven.test_springMVC4.web.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumiseven.test_springMVC4.service.DemoService;

@RestController
public class MyRestController {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value="/testRest", produces="text/plain; charset=UTF-8")
	public String testRest(){
		return demoService.doSomething();
	}
}
