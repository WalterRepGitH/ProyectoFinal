package com.someBank.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.someBank.product.account.entity.extern.Client;

@Component
public class KafkaConsumer {
	
    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    
    @KafkaListener(topics = "bootcamptopic" , groupId = "group_id")
    public void consume(Client client) {
    	System.out.print("consumer 3");
        logger.info("Consuming Message {}", client.toString());
    }
    
}