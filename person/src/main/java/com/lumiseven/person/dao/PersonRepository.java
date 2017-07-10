package com.lumiseven.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lumiseven.person.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}