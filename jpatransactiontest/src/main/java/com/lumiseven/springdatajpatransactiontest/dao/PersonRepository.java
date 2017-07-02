package com.lumiseven.springdatajpatransactiontest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lumiseven.springdatajpatransactiontest.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
