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
//	private static final Logger logger = LoggerFactory.getLogger(DataServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DataServiceApplication.class, args);

//		KafkaConsumer<String, String> consumer = KafkaConsumerUtil.getConsumer();
//		consumer.subscribe(Collections.singleton("Stream_of_numbers"));
//		while (true) {
//			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
//			for (ConsumerRecord<String, String> record : records) {
//				logger.info(String.format("received message: %s\n", record.value()));
//				getDataService().saveDataRecord(Integer.valueOf(record.value()));
//			}
//		}
	}

	@KafkaListener(topics = "Stream_of_numbers", groupId = "data_id")
	public void listener(String number) {
		getDataService().saveDataRecord(Integer.valueOf(number));
	}

	public DataService getDataService() {
		return dataService;
	}

	@Autowired
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
}
