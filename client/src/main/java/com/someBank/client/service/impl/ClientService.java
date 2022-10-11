package com.someBank.client.service.impl;

import java.util.ArrayList;

import com.someBank.client.message.KafkaProducer;
import com.someBank.client.extern.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.someBank.client.entity.Client;
import com.someBank.client.repository.IClientRepository;
import com.someBank.client.service.IClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	private IClientRepository clientRepository;

	@Autowired
	private IProductService productService;

	@Autowired
	private KafkaProducer clientProducer;


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
		return Mono.justOrEmpty(
				clientRepository.findById(id)
					)
				.map( clientTmp -> {
					clientTmp.setAccounts(new ArrayList<>());
					clientTmp.setCredits(new ArrayList<>());
					return clientTmp;
				})
				.zipWhen( clientTmp -> productService.findAccountsByClient(id).collectList())
					.map(
							tuple -> {
								Client client1 = tuple.getT1();
								client1.setAccounts(tuple.getT2());
								return client1;
					})
				.zipWhen( clientTmp -> productService.findCreditsByClient(id).collectList())
					.map(
							tuple -> {
								Client client1 = tuple.getT1();
								client1.setCredits(tuple.getT2());
								return client1;
							}
						)
				;
	}

}
