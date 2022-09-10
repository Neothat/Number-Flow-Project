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

	@KafkaListener(topics = "Stream_of_numbers", groupId = "analytics_id")
	public void listener(String number) {
		getAnalyticsService().updateCounterInfo(Integer.parseInt(number));
	}

	public AnalyticsService getAnalyticsService() {
		return analyticsService;
	}

	@Autowired
	public void setAnalyticsService(AnalyticsService analyticsService) {
		this.analyticsService = analyticsService;
	}
}
