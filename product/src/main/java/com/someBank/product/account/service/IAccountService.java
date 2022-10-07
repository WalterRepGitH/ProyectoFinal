package com.someBank.product.account.service;

import com.someBank.product.account.entity.Account;
import com.someBank.product.account.entity.AccountTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountService {

	Mono<Account> create(Account account);
	
	Mono<Account> update(Account account);
	
	Mono<Void> delete(String id);
	
	Flux<Account> findAll();
	
	Mono<Account> findById(String id);
	
	Flux<Account> findByIdClient(Integer idClient);
	
	Mono<AccountTransaction> withDraw(AccountTransaction withDraw) ;
	
	Mono<AccountTransaction> deposit(AccountTransaction deposit) ;
	
/*	Mono<String> addHolder(Integer idAccount, String holder);
	
	Mono<String> addSignatory(Integer idAccount, String signatory);	*/
	
}