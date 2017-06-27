package com.lumiseven.testspringboot.testspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumiseven.testspringboot.testspringboot.conf.AuthorSettings;

@RestController
@SpringBootApplication
public class TestspringbootApplication {

	@Autowired
	private AuthorSettings authorSettings;
	
	@RequestMapping("/")
	String index(){
		return "first spring boot project" + "author name: " + authorSettings.getName() + "and author age: " + authorSettings.getAge();
	}
	
	public static void main(String[] args) {
//		SpringApplication.run(TestspringbootApplication.class, args);
		
//		SpringApplication sp = new SpringApplication(TestspringbootApplication.class);
//		sp.setBannerMode(Banner.Mode.OFF);//set no start banner
//		sp.run(args);
		
		new SpringApplicationBuilder(TestspringbootApplication.class)
		.properties("spring.config.name=application,author")
		.properties("spring.config.location=classpath:application.yml,classpath:conf/author.yml")
		.bannerMode(Banner.Mode.OFF).run(args);//or this to set no banner in begining
		
	}
}
