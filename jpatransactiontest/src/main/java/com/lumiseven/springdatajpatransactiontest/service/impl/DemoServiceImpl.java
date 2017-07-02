package com.lumiseven.springdatajpatransactiontest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lumiseven.springdatajpatransactiontest.dao.PersonRepository;
import com.lumiseven.springdatajpatransactiontest.domain.Person;
import com.lumiseven.springdatajpatransactiontest.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{

	
	@Autowired
	PersonRepository pr;
	
	@Override
	@Transactional(rollbackFor={IllegalArgumentException.class})
	public Person savePersonWithRollBack(Person person) {
		Person p = pr.save(person);
		if (p.getName().equals("name03")){
			throw new IllegalArgumentException("name03 is already exists, transaction rollback. ");
		}
		return p;
	}

	@Override
	@Transactional(noRollbackFor={IllegalArgumentException.class})
	public Person savePersonWithoutRollBack(Person person) {
		Person p = pr.save(person);
		if (p.getName().equals("name03")){
			throw new IllegalArgumentException("name03 is already exists, but transaction not rollback. ");
		}
		return p;
	}

}
