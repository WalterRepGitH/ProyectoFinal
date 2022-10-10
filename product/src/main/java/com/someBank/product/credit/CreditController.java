package com.someBank.product.credit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.someBank.product.credit.entity.Credit;
import com.someBank.product.credit.entity.CreditTransaction;
import com.someBank.product.credit.service.ICreditService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products/credits")
public class CreditController {
	
	@Autowired
	private ICreditService creditService;

	@PostMapping
	public Mono<Credit> create(@RequestBody Credit credit) throws Exception{
		return creditService.create(credit);
	}
	
	@PutMapping
	public Mono<Credit> update(@RequestBody Credit credit) throws Exception{
		return creditService.update(credit);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable String id) throws Exception{
		return creditService.delete(id);
	}
	
	@GetMapping
	public Flux<Credit> findAll(){
		return creditService.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Credit> findById(@PathVariable String id) {
		return creditService.findById(id);
	};
	
	@GetMapping("/client/{idClient}")
	public Flux<Credit> findByIdClient(@PathVariable Integer idClient){
		return creditService.findByIdClient(idClient);
	}
	
	@PostMapping("/payment")
	public Mono<CreditTransaction> AddPayment(@RequestBody CreditTransaction creditPayment) throws Exception{
		return creditService.AddPayment( creditPayment);
	}
	
	@PostMapping("/consumption")
	public Mono<CreditTransaction> AddCreditCardConsumption(@RequestBody CreditTransaction creditCardConsumption) throws Exception{
		return creditService.AddCreditCardConsumption(creditCardConsumption);
	}
	
}
