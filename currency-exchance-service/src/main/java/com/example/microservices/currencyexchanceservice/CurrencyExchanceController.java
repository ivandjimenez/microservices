package com.example.microservices.currencyexchanceservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.currencyexchanceservice.entity.ExchangeValue;
import com.example.microservices.currencyexchanceservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchanceController {

	@Autowired
	private ExchangeValueRepository repository;
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to)
	{

		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		return exchangeValue;
		
	}
}
