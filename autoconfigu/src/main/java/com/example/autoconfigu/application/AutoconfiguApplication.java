package com.example.autoconfigu.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.autoconfigu.application.service.HelloService;

@SpringBootApplication
public class AutoconfiguApplication implements CommandLineRunner{

	@Autowired
	HelloService helloservice;
	
	@Autowired
	private SpringService springService;
	
	public static void main(String[] args) {
		SpringApplication.run(AutoconfiguApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		helloservice.helloWorld();
		System.out.println("Spring service fully qualified class name: " + springService.getClass());

	}
	

}
