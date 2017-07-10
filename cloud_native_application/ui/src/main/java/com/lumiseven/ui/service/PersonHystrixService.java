package com.lumiseven.ui.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumiseven.ui.domain.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/*
 * 使用feign调用person service的断路器
 */
@Service
public class PersonHystrixService {
	
	@Autowired
	PersonService personService;

	@HystrixCommand(fallbackMethod="fallbackSave")
	public List<Person> save(String name){
		return personService.save(name);
	}
	
	public List<Person> fallbackSave(String name){
		List<Person> lp = new ArrayList<Person>();
		Person p = new Person("Person Service 故障 " + name);
		lp.add(p);
		return lp;
	}
}
