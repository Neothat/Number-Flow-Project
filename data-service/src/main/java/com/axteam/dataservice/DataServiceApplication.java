package com.axteam.dataservice;

import com.axteam.dataservice.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableKafka
public class DataServiceApplication {

	private DataService dataService;

	public static void main(String[] args) {
		SpringApplication.run(DataServiceApplication.class, args);
	}

	@KafkaListener(topics = "Stream_of_numbers", groupId = "number_id")
	public void listener(String str) {
		getDataService().saveDataRecord(Short.parseShort(str));
	}

	public DataService getDataService() {
		return dataService;
	}

	@Autowired
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
}
