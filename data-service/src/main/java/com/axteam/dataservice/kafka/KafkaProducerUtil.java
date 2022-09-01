package com.axteam.dataservice.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;

public class KafkaProducerUtil {

	private static org.apache.kafka.clients.producer.KafkaProducer<String, String> kafkaProducer;

	static {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer .class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		kafkaProducer = new org.apache.kafka.clients.producer.KafkaProducer<>(configProps);
	}

	public static org.apache.kafka.clients.producer.KafkaProducer<String, String> getProducer() {
		return kafkaProducer;
	}

}
