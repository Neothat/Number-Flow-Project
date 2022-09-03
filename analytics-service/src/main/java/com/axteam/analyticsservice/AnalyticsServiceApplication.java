package com.axteam.analyticsservice;

import com.axteam.analyticsservice.services.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableKafka
public class AnalyticsServiceApplication {

	private AnalyticsService analyticsService;

	public static void main(String[] args) {
		SpringApplication.run(AnalyticsServiceApplication.class, args);
	}

	@KafkaListener(topics = "Stream_of_numbers", groupId = "number_id")
	public void listener(String str) {
		getAnalyticsService().updateCounterInfo(Integer.parseInt(str));
	}

	public AnalyticsService getAnalyticsService() {
		return analyticsService;
	}

	@Autowired
	public void setAnalyticsService(AnalyticsService analyticsService) {
		this.analyticsService = analyticsService;
	}
}
