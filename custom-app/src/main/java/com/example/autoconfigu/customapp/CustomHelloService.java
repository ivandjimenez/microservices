package com.example.autoconfigu.customapp;

import com.example.autoconfigu.application.service.HelloService;

public class CustomHelloService implements HelloService {

	@Override
	public void helloWorld() {

		System.out.println("Hello from custom Application");
	}

}
