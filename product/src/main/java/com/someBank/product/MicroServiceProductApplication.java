package com.someBank.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProductApplication.class, args);
	}

}
