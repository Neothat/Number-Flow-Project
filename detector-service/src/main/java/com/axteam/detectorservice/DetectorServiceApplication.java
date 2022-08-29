package com.axteam.detectorservice;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class DetectorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DetectorServiceApplication.class, args);
		Logger logger = LoggerFactory.getLogger(DetectorServiceApplication.class);

		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(configProps);

		Thread run = new Thread(() -> {
			while (true) {
				try {
					ProducerRecord<String, String> record = new ProducerRecord<>(
							"Stream_of_numbers", UUID.randomUUID().toString(), generateNumber());
					kafkaProducer.send(record, (metadata, exception) -> {
						if (exception == null) {
							logger.info(String.format("received new metadata, topic - %s; partition - %s; offset - %s; time -%s",
									metadata.topic(), metadata.partition(), metadata.offset(), metadata.timestamp()));
						} else {
							logger.error("error producing", exception);
						}
					});
					//noinspection BusyWait
					Thread.sleep(1000); //1000 - 1 сек
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		run.start();
	}

	public static String generateNumber() {
		return String.valueOf((byte) (Math.random() * 100));
	}
}
