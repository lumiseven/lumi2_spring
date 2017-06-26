package com.lumiseven.test_springMVC4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.lumiseven.test_springMVC4.service.PushService;

@RestController
public class AsyncController {

	@Autowired
	private PushService pushService;
	
	@RequestMapping("/defer")
	public DeferredResult<String> deferredCall(){
		return pushService.getAsyncUpdate();
	}
}
