package com.lumiseven.test_springMVC4.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumiseven.test_springMVC4.domain.DemoObj;

@RestController
@RequestMapping("/rest")
public class DemoRestController {
	
	@RequestMapping(value="/getjson", produces = "application/json; charset=UTF-8")
	public DemoObj getjson(DemoObj obj){
		return new DemoObj(obj.getId()+1, obj.getName()+"se_ven");
	}

	@RequestMapping(value="/getxml", produces = "application/xml; charset=UTF-8")
	public DemoObj getxml(DemoObj obj){
		return new DemoObj(obj.getId()+1, obj.getName()+"se_ven");
	}
}
