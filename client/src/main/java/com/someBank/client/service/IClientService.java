package com.someBank.client.service;

import com.someBank.client.entity.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClientService {
	
	Mono<Client> create(Client client);
	
	Mono<Client> update(Client client);
	
	Mono<Void> delete(Integer id);
	
	Flux<Client> findAll();
	
	Mono<Client> findById(Integer id);

}
