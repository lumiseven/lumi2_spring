package com.lumiseven.test_springMVC4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandlerModelInitBinderAdvice {
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView exception(Exception exception, WebRequest request){
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorMessage", exception.getMessage());
		return modelAndView;
	}
	
	@ModelAttribute
	public void addAttributes(Model model){
		model.addAttribute("msg", "additional message");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		/*
		 * more using manual for WebDataBinder API
		 */
		webDataBinder.setDisallowedFields("id");
	}

}
