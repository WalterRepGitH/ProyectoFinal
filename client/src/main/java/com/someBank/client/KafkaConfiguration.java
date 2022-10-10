package com.someBank.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import org.springframework.kafka.support.serializer.JsonSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import com.someBank.client.entity.Client;

@Configuration
public class KafkaConfiguration {
	
	@Bean
	public ProducerFactory<String, /*String*/Client> producerFactory(){
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer/*StringSerializer*/.class);
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	@Bean(name = "kafkaStringTemplate")
	KafkaTemplate<String,Client/*String*/> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}

}
