package com.lumiseven.springdataredis.dao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.lumiseven.springdataredis.domain.Person;

@Repository
public class PersonDao {
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;//直接注入spring boot 的 StringRedisTemplate
	
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;//直接注入spring boot 的 RedisTemplate
	
	@Resource(name="stringRedisTemplate")
	ValueOperations<String, String> valOpsStr;

	@Resource(name="redisTemplate")
	ValueOperations<Object, Object> valOps;
	
	public void stringRedisTemplateDemo(){
		valOpsStr.set("xx", "zz");
	}
	
	public void save(Person person){
		valOps.set(person.getId(), person);
	}
	
	public String getString(){
		return valOpsStr.get("xx");
	}
	
	public Person getPerson(){
		return (Person) valOps.get("1");
	}
}
