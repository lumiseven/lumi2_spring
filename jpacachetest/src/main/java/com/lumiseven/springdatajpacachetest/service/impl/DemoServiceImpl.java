package com.lumiseven.springdatajpacachetest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lumiseven.springdatajpacachetest.dao.PersonRepository;
import com.lumiseven.springdatajpacachetest.domain.Person;
import com.lumiseven.springdatajpacachetest.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{
	
	@Autowired
	PersonRepository personRepository;

	@Override
	@CachePut(value="people", key="#person.id")//cache name people, the cached data has key 'id' from person. if we don't set key manually, the parameter will be used as key to save to cache
	public Person save(Person person) {
		Person p = personRepository.save(person);
		System.out.println("person which have id: " + p.getId() + "has been cached. ");
		return p;
	}

	@Override
	@CacheEvict(value="people")
	public void remove(Long id) {
		System.out.println("person which have id: " + id + "has been deleted from cache. ");
		personRepository.delete(id);
	}

	@Override
	@Cacheable(value="people", key="#person.id")
	public Person findOne(Person person) {
		Person p = personRepository.findOne(person.getId());
		System.out.println("person which have id: " + p.getId() + "has been cached. ");
		return p;
	}
	
}
