package com.lumiseven.test_springMVC4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/index")
	public String testMvc(){
		return "index";
	}
}
