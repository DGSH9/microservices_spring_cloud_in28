package com.dgsh.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dgsh.microservices.currencyexchangeservice.bean.CurrencyExchange;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private Environment environment;
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveAllExchange(
			@PathVariable("from") String from,
			@PathVariable("to") String to) {
		CurrencyExchange currencyExchange = new CurrencyExchange(10001L,from,to,BigDecimal.valueOf(50));
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		
		return currencyExchange;
	}
}
