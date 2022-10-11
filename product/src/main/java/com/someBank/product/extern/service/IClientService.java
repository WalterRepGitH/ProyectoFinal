package com.someBank.product.extern.service;

import com.someBank.product.extern.entity.Client;
import reactor.core.publisher.Mono;

public interface IClientService {

    Mono<Client> findClient(Integer id);
}
