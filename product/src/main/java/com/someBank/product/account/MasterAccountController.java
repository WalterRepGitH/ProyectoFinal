package com.someBank.product.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.someBank.product.account.entity.MasterAccount;
import com.someBank.product.account.service.IMasterAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products/accounts/master")
public class MasterAccountController {
	
	@Autowired
	private IMasterAccountService accountService;
	
	@PostMapping
	public Mono<MasterAccount> create(@RequestBody MasterAccount masterAccount) {
		return accountService.create(masterAccount);
	}

	@PutMapping
	public Mono<MasterAccount> update(@RequestBody MasterAccount masterAccount) {
		return accountService.update(masterAccount);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable Integer id) {
		return accountService.delete(id);
	}

	@GetMapping
	public Flux<MasterAccount> findAll() {
		return accountService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<MasterAccount> findById(@PathVariable Integer id) {
		return accountService.findById(id);
	}
	

}
