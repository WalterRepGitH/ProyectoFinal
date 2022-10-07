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

import com.someBank.product.account.entity.Account;
import com.someBank.product.account.entity.AccountTransaction;
import com.someBank.product.account.service.IAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products/accounts")
public class AccountController {
	
	@Autowired
	private IAccountService accountService;
	
	@PostMapping
	public Mono<Account> create(@RequestBody Account account) {
		return accountService.create(account);
	}
	
	@PutMapping
	public Mono<Account> update(@RequestBody Account account) {
		return accountService.update(account);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable String id) {
		return accountService.delete(id);
	}
	
	@GetMapping
	public Flux<Account> findAll(){
		return accountService.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Account> findById(@PathVariable String id) {
		return accountService.findById(id);
	}
	
	@GetMapping("/client/{idClient}")
	public Flux<Account> findByIdClient(@PathVariable Integer idClient){
		return accountService.findByIdClient(idClient);
	}
	
	@PostMapping("/withDraw")
	public Mono<AccountTransaction> withDraw(@RequestBody AccountTransaction withDraw) {
		return accountService.withDraw( withDraw);
	}
	
	@PostMapping("/deposit")
	public Mono<AccountTransaction> deposit(@RequestBody AccountTransaction deposit){
		return accountService.deposit(deposit);
	}
	
	/*
	@PostMapping("/holder/{idClientAccount}")
	public Mono<String> addHolder(@PathVariable Integer idAccount, @RequestBody String holder) {
		return accountService.addHolder(idAccount, holder);
	}
	
	@PostMapping("/signatory/{idClientAccount}")
	public Mono<String> addSignatory(Integer idAccount, String signatory) {
		return accountService.addSignatory(idAccount, signatory);
	}
	*/
}