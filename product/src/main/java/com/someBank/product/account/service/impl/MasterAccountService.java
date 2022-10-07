package com.someBank.product.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.someBank.product.account.entity.MasterAccount;
import com.someBank.product.account.repository.IMasterAccountRepository;
import com.someBank.product.account.service.IMasterAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MasterAccountService implements IMasterAccountService {
	
	@Autowired
	private IMasterAccountRepository accountRepository;

	@Override
	public Mono<MasterAccount> create(MasterAccount masterAccount) {
		return accountRepository.save(masterAccount);
	}

	@Override
	public Mono<MasterAccount> update(MasterAccount masterAccount) {
		return accountRepository.save(masterAccount);
	}

	@Override
	public Mono<Void> delete(Integer id) {
		// TODO Auto-generated method stub
		return accountRepository.deleteById(id);
	}

	@Override
	public Flux<MasterAccount> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Mono<MasterAccount> findById(Integer id) {
		return accountRepository.findById(id);
	}
	


}