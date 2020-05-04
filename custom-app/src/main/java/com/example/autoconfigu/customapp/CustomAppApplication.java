package com.example.autoconfigu.customapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.autoconfigu.application.service.HelloService;

@SpringBootApplication
public class CustomAppApplication implements CommandLineRunner{

	HelloService helloService;
	public static void main(String[] args) {
		SpringApplication.run(CustomAppApplication.class, args);
	}

	

	@Override
	public void run(String... args) throws Exception {
		helloService.helloWorld();
	}
	
	@Bean
	public HelloService helloService()
	{
		return new CustomHelloService();
	}
}