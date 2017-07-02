package com.lumiseven.springdatajpatest01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumiseven.springdatajpatest01.dao.PersonRepository;
import com.lumiseven.springdatajpatest01.domain.Person;

@RestController
public class DataController {
	
	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping("/save")
	public Person save(String name, String address, Integer age){
		Person p = personRepository.save(new Person(null, name, age, address));
		return p;
	}
	
	/*
	 * findByAddress
	 */
	@RequestMapping("/q1")
	public List<Person> q1(String address){
		List<Person> ps = personRepository.findByAddress(address);
		return ps;
	}
	
	/*
	 * findByNameAndAddress
	 */
	@RequestMapping("/q2")
	public Person q2(String name, String address){
		Person p = personRepository.findByNameAndAddress(name, address);
		return p;
	}
	
	/*
	 * withNameAndAddressQuery
	 */
	@RequestMapping("/q3")
	public Person q3(String name, String address){
		Person p = personRepository.withNameAndAddressQuery(name, address);
		return p;
	}
	
	/*
	 * withNameAndAddressNamedQuery
	 */
	@RequestMapping("q4")
	public Person q4(String name, String address){
		Person p = personRepository.withNameAndAddressNamedQuery(name, address);
		return p;
	}
	
	/*
	 * sort
	 */
	@RequestMapping("/sort")
	public List<Person> sort(){
		List<Person> ps = personRepository.findAll(new Sort(Direction.ASC, "age"));
		return ps;
	}
	
	/*
	 * page
	 */
	@RequestMapping("/page")
	public Page<Person> page(){
		Page<Person> pp = personRepository.findAll(new PageRequest(1, 2));
		return pp;
	}

	/*
	 * auto
	 */
	@RequestMapping("/auto")
	public Page<Person> auto(Person p){
		Page<Person> pp = personRepository.findByAuto(p, new PageRequest(0, 10));
		return pp;
	}
}
