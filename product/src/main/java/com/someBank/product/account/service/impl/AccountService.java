package com.someBank.product.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.someBank.product.account.entity.Account;
import com.someBank.product.account.entity.AccountTransaction;
import com.someBank.product.account.entity.MasterAccount;
import com.someBank.product.account.entity.extern.Client;
import com.someBank.product.account.entity.extern.Client.EType;
import com.someBank.product.account.repository.IAccountRepository;
import com.someBank.product.account.repository.IAccountTransaction;
import com.someBank.product.account.service.IAccountService;
import com.someBank.product.account.service.IMasterAccountService;
import com.someBank.product.credit.entity.Credit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;
	
	@Autowired
	private IAccountTransaction accountTransactionRepository;
	
	@Autowired
	private IMasterAccountService masterAccountService;
	
	private final WebClient webClient;
    
    public AccountService(WebClient.Builder webClientBuilder) {
    	this.webClient = webClientBuilder.baseUrl("http://localhost:8001").build();
    }
    
    private Mono<Client> findClient(Integer id){
    	System.out.println(id);
        return webClient.get()
                        .uri("/clients/{id}", id)
                        .retrieve()
                        .bodyToMono(Client.class);
    }

	@Override
	public Mono<Account> create(Account account) {
		
		Flux<Account> accountsOfClient = findByIdClient(account.getIdClient());
		
		return Mono.just(account)
		.flatMap(accountTemp -> {
			return findClient(accountTemp.getIdClient() );
		})
		.flatMap(client -> {
			if(client == null) {
				throw new RuntimeException("El cliente no existe");
			}
			validAccountCreate(client,account,accountsOfClient);
			return accountRepository.save(account);
		})
		;
	}
	
	

	private boolean validAccountCreate(Client client, Account account, Flux<Account> accountsOfClient) {
		
		masterAccountService.findById(account.getIdMasterAccount())
		.map( masterAccount -> {
			
			Flux<MasterAccount> masterAccountWithSameType = masterAccountService.findByType(masterAccount.getType());
			
			switch(masterAccount.getType()) {
			case SAVING:
			{
				if(client.getType() == EType.PERSONAL) {
					//accountsOfClient.filter( x -> { x.getIdMasterAccount() })
				}
				
				break;
			}
			case CURRENT:
			{
				break;
			}
			case FIXEDTERM:
			{
				break;
			}
			}
			
			return true;
		})
		;
		
		return true;
	}
	
	private void abc(String idMasterAccount, MasterAccount.EType masterAccountType/*Flux<MasterAccount> masterAccountWithSameType*/ ) {
		
		masterAccountService.findByIdAndType(idMasterAccount, masterAccountType);
		
		/*return masterAccountWithSameType
		.filter( x -> x.getId() == idMasterAccount )
		.count()
		;*/
	}

	@Override
	public Mono<Account> update(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Mono<Void> delete(String id) {
		return accountRepository.deleteById(Mono.just(id));
	}

	@Override
	public Flux<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Mono<Account> findById(String id) {
		return accountRepository.findById(id);
	}

	@Override
	public Flux<Account> findByIdClient(Integer idClient) {
		return accountRepository.findByIdClient(idClient);
	}

	@Override
	public Mono<AccountTransaction> withDraw(AccountTransaction withDraw) {
		
		return
				Mono
				.just(withDraw)
				.flatMap(withDrawTmp -> {
					return findById(withDrawTmp.getIdAccount());
				})
				.flatMap(account -> {
					account.setAvailableBalance(account.getAvailableBalance() - withDraw.getAmount());
					return accountRepository.save(account);
				})
				.flatMap(account -> {
					return accountTransactionRepository.save(withDraw);
				});

	}

	@Override
	public Mono<AccountTransaction> deposit(AccountTransaction deposit) {
		
		return
				Mono
				.just(deposit)
				.flatMap(depositTmp -> {
					return findById(depositTmp.getIdAccount());
				})
				.flatMap(account -> {
					account.setAvailableBalance(account.getAvailableBalance() + deposit.getAmount());
					return accountRepository.save(account);
				})
				.flatMap(account -> {
					return accountTransactionRepository.save(deposit);
				});
		
	}

	/*@Override
	public Mono<String> addHolder(Integer idAccount, String holder) {
		return accountRepository.addHolder(idAccount, holder);
	}

	@Override
	public Mono<String> addSignatory(Integer idAccount, String signatory) {
		return accountRepository.addSignatory(idAccount, signatory);
	}*/



}

/*
 * 	@Autowired
	private IIExternalClientService externalClientService ;
 * */