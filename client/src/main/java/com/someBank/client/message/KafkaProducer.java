package com.someBank.client.message;

import com.someBank.client.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Client> producer;

    public void sendClientMessage(Client client) {
        Message<Client> message = MessageBuilder
                .withPayload(client)
                .setHeader(KafkaHeaders.TOPIC, "bootcamptopic")
                .build();
        producer.send(message);
    }

}
