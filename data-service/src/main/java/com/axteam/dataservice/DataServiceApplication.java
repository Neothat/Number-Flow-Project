package com.axteam.dataservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableKafka
public class DataServiceApplication {

	private final Logger logger = LoggerFactory.getLogger(DataServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DataServiceApplication.class, args);
	}

	@KafkaListener(topics = "Stream_of_numbers", groupId = "number_id")
	public void listener(String str) {
		logger.info(String.format("%s; Number received: %s",
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")),
				str));
	}
}
