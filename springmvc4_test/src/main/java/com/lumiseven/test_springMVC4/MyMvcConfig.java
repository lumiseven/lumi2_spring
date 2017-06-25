package com.lumiseven.test_springMVC4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.lumiseven.test_springMVC4.interceptor.DemoInterceptor;

@Configuration
@ComponentScan("com.lumiseven.test_springMVC4")
@EnableWebMvc
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	
	/*
	 * configure a jsp file resolver
	 */
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*
		 * using addResourceHandler to set access location discovery 文件对外访问路径
		 * using addResourceLocations to set local file location directory 文件放置路径
		 */
		registry.addResourceHandler("/asserts/**").addResourceLocations("classpath:/asserts/");
	}

	@Bean
	public DemoInterceptor demoInterceptor(){
		return new DemoInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}
}
