package com.someBank.client.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.common.net.HttpHeaders;
import com.someBank.client.entity.Client;
import com.someBank.client.entity.extern.Account;
import com.someBank.client.entity.extern.Credit;
import com.someBank.client.repository.IClientRepository;
import com.someBank.client.service.IClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	private IClientRepository clientRepository;
	
	private final WebClient webClientProduct = WebClient.create("http://localhost:8001");
    
//    public ClientService(WebClient.Builder webClientBuilder) {
//    	//this.webClientProduct = WebClient.create("http://localhost:8001");
//    			/*webClientBuilder.baseUrl("http://localhost:8001")
//    			//.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//    			.build();*/
//    }
    
    public Flux<Account> findAccountsByClient(Integer id){
        return webClientProduct.get()
                        .uri("/products/accounts/client/{id}", id)
                        .retrieve()
                        .bodyToFlux(Account.class);
    }
    
    public Flux<Credit> findCreditsByClient(Integer id){
        return webClientProduct.get()
                        .uri("/products/credits/client/{id}", id)
                        .retrieve()
                        .bodyToFlux(Credit.class);
    }

	@Override
	public Mono<Client> create(Client client) {
		client.setId(null);
		return Mono.just(clientRepository.save(client));
	}

	@Override
	public Mono<Client> update(Client client) {
		return Mono.just(clientRepository.save(client));
	}

	@Override
	public Mono<Void> delete(Integer id) {
		clientRepository.deleteById(id);
		return Mono.empty();
	}

	@Override
	public Flux<Client> findAll() {
		return Flux.fromIterable(clientRepository.findAll());
	}
	


	@Override
	public Mono<Client> findById(Integer id) {
		System.out.print("ingresando");
		Flux<Account> accounts = findAccountsByClient(id).
				map( account -> 
				{
					System.out.print("def");
					return account;
				}
				);
		
		Mono<Client> client =  Mono.justOrEmpty(
				clientRepository.findById(id)
					).map( clientTmp -> {
						
						clientTmp.setAccounts(new ArrayList<>());
						clientTmp.setCredits(new ArrayList<>());
						
						findAccountsByClient(id).
						map( account -> 
						{
							System.out.print("abc");
							clientTmp.getAccounts().add(account);
							return account;
						}
						);
						
						return clientTmp;
					});
		

		
		return client;
		/*
		findAccountsByClient(id).doOnNext(accountTmp -> {
			client.g
		}); 
		
		Flux<Credit> credits = findCreditsByClient(id);
		*/

				//.orElse(null);
	}

}
