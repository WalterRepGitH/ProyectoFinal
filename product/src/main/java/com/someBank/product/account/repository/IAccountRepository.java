package com.someBank.product.account.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.someBank.product.account.entity.Account;
import com.someBank.product.account.entity.MasterAccount;
import com.someBank.product.account.entity.MasterAccount.EType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountRepository extends ReactiveMongoRepository<Account, String> {

	Flux<Account> findByIdClient(Integer idClient);

}