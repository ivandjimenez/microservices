package com.example.autoconfigu.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.autoconfigu.application.service.HelloService;
import com.example.autoconfigu.application.service.HelloServiceImple;



@Configuration
@ConditionalOnClass(HelloService.class)
public class SampleAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public HelloService helloService()
	{
		return new HelloServiceImple();
	}
	
	
	
	
}
