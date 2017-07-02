package com.lumiseven.springdatajpatransactiontest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumiseven.springdatajpatransactiontest.domain.Person;
import com.lumiseven.springdatajpatransactiontest.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	DemoService demoService;
	
	@RequestMapping("/rollback")
	public Person rollback(Person person){
		return demoService.savePersonWithRollBack(person);
	}
	
	@RequestMapping("/noRollback")
	public Person noRollback(Person person){
		return demoService.savePersonWithoutRollBack(person);
	}

}
