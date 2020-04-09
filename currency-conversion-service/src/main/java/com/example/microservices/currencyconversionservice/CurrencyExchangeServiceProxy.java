package com.example.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="currency-exchance-service", url = "localhost:8000")
//@FeignClient(name="currency-exchance-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchance-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("currency-exchance-service/currency-exchange/from/{from}/to/{to}")
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue
		(@PathVariable String from, @PathVariable String to);
	
}
