package com.lumiseven.springdatajpacachetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JpacachetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpacachetestApplication.class, args);
	}
}
