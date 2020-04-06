package com.example.microservices.currencyexchanceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.currencyexchanceservice.entity.ExchangeValue;

public interface ExchanceValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);
}
