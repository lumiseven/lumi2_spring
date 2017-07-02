package com.lumiseven.springdatajpatransactiontest.service;

import com.lumiseven.springdatajpatransactiontest.domain.Person;

public interface DemoService {
	
	public Person savePersonWithRollBack(Person p);
	
	public Person savePersonWithoutRollBack(Person p);

}
