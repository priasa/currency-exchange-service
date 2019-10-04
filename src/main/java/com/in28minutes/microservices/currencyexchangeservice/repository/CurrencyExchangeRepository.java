package com.in28minutes.microservices.currencyexchangeservice.repository;

import com.in28minutes.microservices.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, String> {
    ExchangeValue findByFromAndTo(String from, String to);
}
