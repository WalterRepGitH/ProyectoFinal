package com.someBank.client.extern.service;

import com.someBank.client.extern.entity.Account;
import com.someBank.client.extern.entity.Credit;
import reactor.core.publisher.Flux;

public interface IProductService {

    Flux<Account> findAccountsByClient(Integer idClient);

    Flux<Credit> findCreditsByClient(Integer id);

}
