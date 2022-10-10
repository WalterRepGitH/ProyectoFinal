package com.someBank.product.account.service;


import com.someBank.product.account.entity.MasterAccount;
import com.someBank.product.account.entity.MasterAccount.EType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMasterAccountService {

	Mono<MasterAccount> create(MasterAccount masterAccount);
	
	Mono<MasterAccount> update(MasterAccount masterAccount);
	
	Mono<Void> delete(String id);
	
	Flux<MasterAccount> findAll();
	
	Mono<MasterAccount> findById(String id);
	
	Flux<MasterAccount> findByType(MasterAccount.EType type);	
	
	Mono<MasterAccount> findByIdAndType(String id, EType type);
	
}
