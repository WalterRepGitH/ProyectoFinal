package com.someBank.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceClientApplication.class, args);
	}

}
