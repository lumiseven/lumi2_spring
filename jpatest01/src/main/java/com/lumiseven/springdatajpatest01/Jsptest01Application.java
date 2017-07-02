package com.lumiseven.springdatajpatest01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lumiseven.springdatajpatest01.support.CustomRepositoryFactoryBean;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass=CustomRepositoryFactoryBean.class)
public class Jsptest01Application {

	public static void main(String[] args) {
		SpringApplication.run(Jsptest01Application.class, args);
	}
}
