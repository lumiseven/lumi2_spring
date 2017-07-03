package com.lumiseven.springdatamongo.controller;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumiseven.springdatamongo.dao.PersonRepository;
import com.lumiseven.springdatamongo.domain.Location;
import com.lumiseven.springdatamongo.domain.Person;

@RestController
public class DataController {
	
	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping("/save")
	public Person save(){
		Person p = new Person("lumiseven", 22);
		Collection<Location> locations = new LinkedHashSet<Location>();
		Location l1 = new Location("shanghai", "123213");
		Location l2 = new Location("hangzhou", "021356");
		Location l3 = new Location("zhoushan", "576766");
		Location l4 = new Location("longyou", "235239");
		
		locations.add(l1);
		locations.add(l2);
		locations.add(l3);
		locations.add(l4);
		p.setLocations(locations);
		
		return personRepository.save(p);
	}
	
	@RequestMapping("/q1")
	public Person q1(String name){
		return personRepository.findByName(name);
	}
	
	@RequestMapping("/q2")
	public List<Person> q2(Integer age){
		return personRepository.withQueryFindByAge(age);
	}

}
