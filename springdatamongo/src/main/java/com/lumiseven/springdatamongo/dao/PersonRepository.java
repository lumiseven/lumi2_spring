package com.lumiseven.springdatamongo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.lumiseven.springdatamongo.domain.Person;

public interface PersonRepository extends MongoRepository<Person, String>{
	
	Person findByName(String name);//支持方法名称查询
	
	@Query("{'age': ?0}")
	List<Person> withQueryFindByAge(Integer age);//支持query查询，查询参数构造JSON字符串

}
