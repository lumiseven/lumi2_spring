package com.lumiseven.test_springMVC4.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumiseven.test_springMVC4.domain.DemoObj;

@RestController
public class ConverterController {

	@RequestMapping(value="/convert", produces = { "application/lumiseven" })
	public DemoObj convert(@RequestBody DemoObj demoObj){
		return demoObj;
	}
}
