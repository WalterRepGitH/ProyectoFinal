package com.someBank.product.account.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.someBank.product.account.entity.MasterAccount;
import com.someBank.product.account.entity.MasterAccount.EType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMasterAccountRepository extends ReactiveMongoRepository<MasterAccount, String> {
	
	Flux<MasterAccount> findByType(MasterAccount.EType type);
	
	Mono<MasterAccount> findByIdAndType(String id, EType type);


}
