package com.in28minutes.microservices.currencyexchangeservice.controller;

import com.in28minutes.microservices.currencyexchangeservice.entity.ExchangeValue;
import com.in28minutes.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;
    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<ExchangeValue> retrieveExchangeValue(@PathVariable(name = "from") String from,
                                                               @PathVariable(name = "to") String to) {
        ExchangeValue exchangeValue = currencyExchangeRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return ResponseEntity.ok(exchangeValue);
    }
}
