package com.lumiseven.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//开启feign客户端支持
@EnableCircuitBreaker//开启circuitBreaker支持
@EnableZuulProxy//开启网关代理支持
public class UiApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(UiApplication.class, args);
    }
    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate () {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;

    }

}
