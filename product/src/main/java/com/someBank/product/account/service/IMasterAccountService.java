package com.someBank.product.account.service;


import com.someBank.product.account.entity.MasterAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMasterAccountService {

	Mono<MasterAccount> create(MasterAccount masterAccount);
	
	Mono<MasterAccount> update(MasterAccount masterAccount);
	
	Mono<Void> delete(Integer id);
	
	Flux<MasterAccount> findAll();
	
	Mono<MasterAccount> findById(Integer id);
	
}
