package com.lumiseven.springdatajpacachetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lumiseven.springdatajpacachetest.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}

