package com.someBank.product.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.someBank.product.account.entity.Account;
import com.someBank.product.account.entity.AccountTransaction;
import com.someBank.product.account.entity.extern.Client;
import com.someBank.product.account.repository.IAccountRepository;
import com.someBank.product.account.repository.IAccountTransaction;
import com.someBank.product.account.service.IAccountService;
import com.someBank.product.credit.entity.Credit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;
	
	@Autowired
	private IAccountTransaction accountTransactionRepository;
	
	private final WebClient webClient;
    
    public AccountService(WebClient.Builder webClientBuilder) {
    	this.webClient = webClientBuilder.baseUrl("http://localhost:8002").build();
    }
    
    private Mono<Client> findClient(Integer id){
    	System.out.println(id);
        return webClient.get()
                        .uri("/clients/{id}", id)
                        .retrieve()
                        .bodyToMono(Client.class);
    }

	@Override
	public Mono<Account> create(Account account) {
		System.out.println("Ingresando");
		return Mono.just(account)
		.flatMap(accountTemp -> {
			return findClient(accountTemp.getIdClient() );
		})
		.flatMap(client -> {
			System.out.println(client.toString());
			return accountRepository.save(account);
		})
		;
			
	}

	@Override
	public Mono<Account> update(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Mono<Void> delete(String id) {
		return accountRepository.deleteById(Mono.just(id));
	}

	@Override
	public Flux<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Mono<Account> findById(String id) {
		return accountRepository.findById(id);
	}

	@Override
	public Flux<Account> findByIdClient(Integer idClient) {
		return accountRepository.findByIdClient(idClient);
	}

	@Override
	public Mono<AccountTransaction> withDraw(AccountTransaction withDraw) {
		
		return
				Mono
				.just(withDraw)
				.flatMap(withDrawTmp -> {
					return findById(withDrawTmp.getIdAccount());
				})
				.flatMap(account -> {
					account.setAvailableBalance(account.getAvailableBalance() - withDraw.getAmount());
					return accountRepository.save(account);
				})
				.flatMap(account -> {
					return accountTransactionRepository.save(withDraw);
				});

	}

	@Override
	public Mono<AccountTransaction> deposit(AccountTransaction deposit) {
		
		return
				Mono
				.just(deposit)
				.flatMap(depositTmp -> {
					return findById(depositTmp.getIdAccount());
				})
				.flatMap(account -> {
					account.setAvailableBalance(account.getAvailableBalance() + deposit.getAmount());
					return accountRepository.save(account);
				})
				.flatMap(account -> {
					return accountTransactionRepository.save(deposit);
				});
		
	}

	/*@Override
	public Mono<String> addHolder(Integer idAccount, String holder) {
		return accountRepository.addHolder(idAccount, holder);
	}

	@Override
	public Mono<String> addSignatory(Integer idAccount, String signatory) {
		return accountRepository.addSignatory(idAccount, signatory);
	}*/



}

/*
 * 	@Autowired
	private IIExternalClientService externalClientService ;
 * */