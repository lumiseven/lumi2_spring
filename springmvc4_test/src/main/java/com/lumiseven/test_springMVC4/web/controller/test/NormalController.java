package com.lumiseven.test_springMVC4.web.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lumiseven.test_springMVC4.service.DemoService;

/*
 * for JUnit testing 
 */
@Controller
public class NormalController {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping("/normal")
	public String testPage(Model model){
		model.addAttribute("msg", demoService.doSomething());
		return "page";
	}
}
