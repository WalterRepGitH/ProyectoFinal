package com.someBank.product.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.someBank.product.account.entity.MasterAccount;
import com.someBank.product.account.entity.MasterAccount.EType;
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
		return saveData(masterAccount);
	}



	@Override
	public Mono<MasterAccount> update(MasterAccount masterAccount) {
		return saveData(masterAccount);
	}
	
	private Mono<MasterAccount> saveData(MasterAccount masterAccount) {

		return Mono.just(masterAccount)
		.map(masterAccountTmp -> {
			masterAccountTmp = validMasterAccount(masterAccountTmp);
			return masterAccountTmp;
		})
		.flatMap(masterAccountTmp -> {
			
			return accountRepository.save(masterAccountTmp);
		});
	}
	
	private MasterAccount validMasterAccount(MasterAccount masterAccount) {

		switch (masterAccount.getType()) {
		case SAVING: {
			if (masterAccount.getMaintanceFee() != 0) {
				throw new RuntimeException("El tipo Cuenta de Ahorro no puede tener Comision por mantenimiento");
			}
			if(masterAccount.getMaximumLimitMovements() <= 0) {
				throw new RuntimeException("El tipo Cuenta de Ahorro debe de tener un limite maximo de movimiento");
			}
			masterAccount.setHasMaximumLimitMovements(true);
			break;
		}
		case CURRENT: {
			if (masterAccount.getMaintanceFee() <= 0) {
				throw new RuntimeException("El tipo Cuenta Corriente debe tener Comision por mantenimiento");
			}
			if(masterAccount.getMaximumLimitMovements() != 0) {
				throw new RuntimeException("El tipo Cuenta Corriente no debe de tener un limite maximo de movimiento");
			}
			masterAccount.setHasMaximumLimitMovements(false);
			break;
		}
		case FIXEDTERM: {
			if (masterAccount.getMaintanceFee() != 0) {
				throw new RuntimeException("El tipo Cuenta a plazo fijo no puede tener Comision por mantenimiento");
			}
			if(masterAccount.getMaximumLimitMovements() != 2 ) {
				throw new RuntimeException("El tipo Cuenta a plazo fijo solo tiene dos movimientos por mes");
			}
			masterAccount.setHasMaximumLimitMovements(true);
			masterAccount.setMaximumLimitMovements(2);
		}
		}

		return masterAccount;
	}

	@Override
	public Mono<Void> delete(String id) {

		// TODO Auto-generated method stub
		return accountRepository.deleteById(id);
	}

	@Override
	public Flux<MasterAccount> findAll() {
		return accountRepository.findAll();
	}

	@Override

	public Mono<MasterAccount> findById(String id) {
		return accountRepository.findById(id);
	}

	@Override
	public Flux<MasterAccount> findByType(EType type) {
		return accountRepository.findByType(type);
	}
	
	@Override
	public Mono<MasterAccount> findByIdAndType(String id, EType type){
		return accountRepository.findByIdAndType(id,type);
	}


}