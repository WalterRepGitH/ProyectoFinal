package com.someBank.product.credit.service;

import com.someBank.product.credit.entity.Credit;
import com.someBank.product.credit.entity.CreditTransaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ICreditService {

	Mono<Credit> create(Credit credit);
	
	Mono<Credit> update(Credit credit);
	
	Mono<Void> delete(String id);
	
	Flux<Credit> findAll();
	
	Mono<Credit> findById(String id);
	
	Flux<Credit> findByIdClient(Integer idClient);
	
	Mono<CreditTransaction> AddPayment(CreditTransaction creditPayment);
	
	Mono<CreditTransaction> AddCreditCardConsumption(CreditTransaction creditCardConsumption);
	
}
