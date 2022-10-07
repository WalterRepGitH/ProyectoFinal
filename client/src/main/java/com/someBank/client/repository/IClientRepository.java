package com.someBank.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.someBank.client.entity.Client;

public interface IClientRepository extends JpaRepository<Client, Integer> {

}
