package com.lumiseven.test_spring4.aop1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.lumiseven.test_spring4.aop1")
@EnableAspectJAutoProxy	//开启spring对AspectJ的支持
public class AopConfig {

}
