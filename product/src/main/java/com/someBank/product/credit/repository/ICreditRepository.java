package com.someBank.product.credit.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.someBank.product.credit.entity.Credit;

import reactor.core.publisher.Flux;

public interface ICreditRepository extends ReactiveMongoRepository<Credit, String> {

	Flux<Credit> findByIdClient(Integer idClient);

}