package com.someBank.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.someBank.client.entity.Client;
import com.someBank.client.service.IClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private IClientService clientService;

	
	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable Integer id) {
		return clientService.delete(id);
	};
	
	@GetMapping
	public Flux<Client> findAll(){
		return clientService.findAll();
	}
	
	@PostMapping
	public Mono<Client> create(@RequestBody Client client) {
		System.out.println("Enterprise " + client);
		return clientService.create(client);
	}
	
	@PutMapping
	public Mono<Client> update(@RequestBody Client client) {
		return clientService.update(client);
	}

	@GetMapping("/{id}")
	public Mono<Client> findById(@PathVariable Integer id) {
		return clientService.findById(id);
	}

}
