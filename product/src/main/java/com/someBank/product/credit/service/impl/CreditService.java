package com.someBank.product.credit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.someBank.product.credit.entity.Credit;
import com.someBank.product.credit.entity.CreditTransaction;
import com.someBank.product.credit.repository.ICreditRepository;
import com.someBank.product.credit.repository.ICreditTransactionRepository;
import com.someBank.product.credit.service.ICreditService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditService implements ICreditService {
	
	@Autowired
	private ICreditRepository creditRepository;
	
	@Autowired
	private ICreditTransactionRepository creditTransactionRepository;

	@Override
	public Mono<Credit> create(Credit credit) {
		return creditRepository.save(credit);
	}

	@Override
	public Mono<Credit> update(Credit credit) {
		return creditRepository.save(credit);
	}

	@Override
	public Mono<Void> delete(String id) {
		return creditRepository.deleteById(Mono.just(id));
	}

	@Override
	public Flux<Credit> findAll() {
		return creditRepository.findAll();
	}

	@Override
	public Mono<Credit> findById(String id) {
		return creditRepository.findById(id);
	}

	@Override
	public Flux<Credit> findByIdClient(Integer idClient) {
		return creditRepository.findByIdClient(idClient);
	}

	@Override
	public Mono<CreditTransaction> AddPayment(CreditTransaction creditPayment) {
		
		return Mono
		.just(creditPayment)
		.flatMap(creditPaymentTmp -> {
			return findById(creditPayment.getIdCredit());
		})
		.flatMap(credit -> {
			credit.setAvailableCredit(credit.getAvailableCredit() + creditPayment.getAmount());
			return creditRepository.save(credit);
		})
		.flatMap(credit -> {
			return creditTransactionRepository.save(creditPayment);
		})
		;
		
		
	}

	@Override
	public Mono<CreditTransaction> AddCreditCardConsumption(CreditTransaction creditCardConsumption) {
		
		return Mono
		.just(creditCardConsumption)
		.flatMap(creditCardConsumptionTmp -> {
			return findById(creditCardConsumptionTmp.getIdCredit());
		})
		.flatMap(credit -> {
			credit.setAvailableCredit(credit.getAvailableCredit() - creditCardConsumption.getAmount());
			return creditRepository.save(credit);
		})
		.flatMap(credit -> {
			return creditTransactionRepository.save(creditCardConsumption);
		})
		;
	}





}