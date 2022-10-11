package com.someBank.product.extern.service.impl;

import com.someBank.product.extern.entity.Client;
import com.someBank.product.extern.service.IClientService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ClientService implements IClientService {

    private final WebClient webClient ;

    public ClientService(WebClient.Builder webClientBuilder) {
        this.webClient =
                webClientBuilder.baseUrl("http://localhost:8001")
                        .build();
    }

    @Override
    public Mono<Client> findClient(Integer id) {
        System.out.println(id);
        return webClient.get()
                .uri("/clients/{id}", id)
                .retrieve()
                .bodyToMono(Client.class);
    }
}
