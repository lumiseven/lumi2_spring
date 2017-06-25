package com.lumiseven.test_springMVC4.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lumiseven.test_springMVC4.domain.DemoObj;

@Controller
@RequestMapping("/anno")
public class DemonAnnotatrionController {
	
	@RequestMapping(produces = "test/plain; charset=UTF-8")
	@ResponseBody
	public String index(HttpServletRequest request){
		return "url: " + request.getRequestURL() + " can access";
	}
	
	@RequestMapping(value="/pathvar/{str}", produces = "test/plain; charset=UTF-8")
	@ResponseBody
	public String demoPathVar(@PathVariable String str, HttpServletRequest request){
		return "url: " + request.getRequestURL() + " can access, str = " + str;
	}
	
	@RequestMapping(value="/requestParam", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String passRequestParam(Long id, HttpServletRequest request){
		return "url: " + request.getRequestURL() + " can access, id = " + id;
	}
	
	@RequestMapping(value="/obj", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String passObj(DemoObj obj, HttpServletRequest request){
		return "url: " + request.getRequestURL() + "can access, obj = " + obj.toString();
	}
	
	@RequestMapping(value={"/name1", "/name2"}, produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String remove(HttpServletRequest request){
		return "url: " + request.getRequestURL() + "can access";
	}
}
