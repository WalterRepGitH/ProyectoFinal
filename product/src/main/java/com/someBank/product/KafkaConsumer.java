package com.someBank.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.someBank.product.account.entity.extern.Client;

public class KafkaConsumer {
	/*
    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "bootcamptopic" , groupId = "group_id")
    public void consume(Client client) {
        logger.info("Consuming Message {}", client.toString());
    }*/

}
