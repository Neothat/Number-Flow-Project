package com.axteam.notificationsenderservice;

import com.axteam.notificationsenderservice.services.NotificationSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableKafka
public class NotificationSenderServiceApplication {

	private NotificationSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(NotificationSenderServiceApplication.class, args);
	}

	@KafkaListener(topics = "Stream_of_incidents", groupId = "incident_id")
	public void listener(String str) {
		getSenderService().sendSimpleEmail(Byte.parseByte(str));
	}

	public NotificationSenderService getSenderService() {
		return senderService;
	}

	@Autowired
	public void setSenderService(NotificationSenderService senderService) {
		this.senderService = senderService;
	}
}
