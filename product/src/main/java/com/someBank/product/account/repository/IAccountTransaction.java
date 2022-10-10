package com.someBank.product.account.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.someBank.product.account.entity.AccountTransaction;



public interface IAccountTransaction extends ReactiveMongoRepository<AccountTransaction, String> {

}
