package com.lumiseven.springdataredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumiseven.springdataredis.dao.PersonDao;
import com.lumiseven.springdataredis.domain.Person;

@RestController
public class DataController {
	
	@Autowired
	PersonDao personDao;
	
	@RequestMapping("/set")
	public void set(){
		Person person = new Person("1", "lumiseven", 22);
		personDao.save(person);
		personDao.stringRedisTemplateDemo();
	}
	
	@RequestMapping("/getStr")
	public String getStr(){
		return personDao.getString();
	}
	
	@RequestMapping("/getPerson")
	public Person getPerson(){
		return personDao.getPerson();
	}

}
