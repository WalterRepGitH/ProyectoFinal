package com.someBank.product;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
//import org.apache.kafka.common.serialization.StringDeserializer;
import com.someBank.product.account.entity.extern.Client;


@EnableKafka
@Configuration
public class KafkaConfiguration {
	
//	@Bean
//	public ConsumerFactory<String, /*String*/Client> consumerFactory(){
//		Map<String, Object> config = new HashMap<>();
//		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer/*StringSerializer*/.class);
//		//return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),new JsonDeserializer<>(Client.class));
//	}
//	
//	@Bean
//	ConcurrentKafkaListenerContainerFactory<String,Client/*String*/> kafkaListenerContainerFactory(){
//		ConcurrentKafkaListenerContainerFactory<String, Client> factory = 
//				new ConcurrentKafkaListenerContainerFactory<>();
//		factory.setConsumerFactory(consumerFactory());
//		return factory;
//	}

}
