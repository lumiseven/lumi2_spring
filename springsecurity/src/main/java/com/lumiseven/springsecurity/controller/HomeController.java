package com.lumiseven.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lumiseven.springsecurity.domain.Msg;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(Model model){
		Msg msg = new Msg("test title", "test content", "test extra message, for administrator only");
		model.addAttribute("msg", msg);
		return "home";
	}

}
