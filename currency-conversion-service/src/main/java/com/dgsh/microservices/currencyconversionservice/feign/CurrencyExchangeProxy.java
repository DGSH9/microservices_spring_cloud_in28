package com.dgsh.microservices.currencyconversionservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dgsh.microservices.currencyconversionservice.bean.CurrencyConversion;


//@FeignClient(name = "currency-exchange",url = "localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveAllExchange(
			@PathVariable("from") String from,
			@PathVariable("to") String to);
	
}
