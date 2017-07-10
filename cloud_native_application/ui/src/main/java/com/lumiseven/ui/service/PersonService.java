package com.lumiseven.ui.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lumiseven.ui.domain.Person;

@FeignClient("person")
public interface PersonService {
	
	/*
	 * 在接口中声明方法即可调用person服务的rest服务
	 */
	@RequestMapping(method=RequestMethod.POST, value="/save", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody List<Person> save(@RequestBody String name);

}
