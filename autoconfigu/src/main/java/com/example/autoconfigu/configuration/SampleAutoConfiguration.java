package com.example.autoconfigu.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.autoconfigu.application.SpringService;
import com.example.autoconfigu.application.service.HelloService;
import com.example.autoconfigu.application.service.HelloServiceImple;



@Configuration
@ConditionalOnClass(HelloService.class)
public class SampleAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	//@ConditionalOnProperty
	public HelloService helloService()
	{
		return new HelloServiceImple();
	}
	
	
	@Bean
	@ConditionalOnProperty(prefix = "module", name = "enabled",matchIfMissing = true)
	public SpringService springService() {
		return new SpringService();
	}
	
}
