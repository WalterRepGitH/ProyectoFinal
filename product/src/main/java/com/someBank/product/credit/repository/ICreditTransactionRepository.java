package com.someBank.product.credit.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.someBank.product.credit.entity.CreditTransaction;

public interface ICreditTransactionRepository extends ReactiveMongoRepository<CreditTransaction, String> {

}
