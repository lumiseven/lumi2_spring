package com.lumiseven.test_springMVC4.web.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SseController {
	
	/*
	 * media type text/event-stream
	 */
	@RequestMapping(value="/push", produces="text/event-stream")
	public String push(){
		Random r = new Random();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "data: random data testing " + r.nextInt() + "\n\n";
	}

}
