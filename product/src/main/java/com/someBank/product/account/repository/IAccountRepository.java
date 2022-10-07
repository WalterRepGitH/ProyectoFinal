package com.someBank.product.account.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.someBank.product.account.entity.Account;

import reactor.core.publisher.Flux;

public interface IAccountRepository extends ReactiveMongoRepository<Account, String> {

	Flux<Account> findByIdClient(Integer idClient);

}