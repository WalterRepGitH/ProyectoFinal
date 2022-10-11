package com.someBank.client.extern.service.impl;

import com.someBank.client.extern.entity.Account;
import com.someBank.client.extern.entity.Credit;
import com.someBank.client.extern.service.IProductService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductService implements IProductService {

    private final WebClient webClientProduct ;

    public ProductService(WebClient.Builder webClientBuilder) {
    	this.webClientProduct =
    			webClientBuilder.baseUrl("http://localhost:8001")
    			.build();
    }

    @Override
    public Flux<Account> findAccountsByClient(Integer idClient){
        Flux<Account> accounts = webClientProduct.get()
                .uri("/products/accounts/client/{idClient}", idClient)
                .retrieve()
                .bodyToFlux(Account.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? Mono.empty() : Mono.error(ex));

        return accounts;
    }


    @Override
    public Flux<Credit> findCreditsByClient(Integer id){
        return webClientProduct.get()
                .uri("/products/credits/client/{id}", id)
                .retrieve()
                .bodyToFlux(Credit.class);
    }

}
