package com.lumiseven.thymeleaf_test;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lumiseven.thymeleaf_test.entity.Person;

@Controller
@SpringBootApplication
public class DemoApplication {
	
	/*
	 * enable http connection and https which in application.yml both
	 * and redirect http(9096) connect to https(8443)
	 */
	@Bean
	public EmbeddedServletContainerFactory servletContainer(){
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory(){
			
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
			
		};
		
		tomcat.addAdditionalTomcatConnectors(httpConnector());
		return tomcat;
	}
	
	@Bean
	public Connector httpConnector(){
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(9096);
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		return connector;
	}

	
	@RequestMapping("/")
	public String index(Model model){
		Person p = new Person("se", 33);
		
		List<Person> ps = new ArrayList<Person>();
		Person p1 = new Person("p1", 1);
		Person p2 = new Person("p2", 2);
		Person p3 = new Person("p3", 3);
		Person p4 = new Person("p4", 4);
		ps.add(p1);
		ps.add(p2);
		ps.add(p3);
		ps.add(p4);
		
		model.addAttribute("singlePerson", p);
		
		model.addAttribute("people", ps);
		
		return "index";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
