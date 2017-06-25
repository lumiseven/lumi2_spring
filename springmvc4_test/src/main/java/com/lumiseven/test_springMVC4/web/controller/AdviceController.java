package com.lumiseven.test_springMVC4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lumiseven.test_springMVC4.domain.DemoObj;

@Controller
public class AdviceController {
	
	@RequestMapping("/advice")
	public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj){
		throw new IllegalArgumentException("wrong parameter from: " + msg);
	}

}
