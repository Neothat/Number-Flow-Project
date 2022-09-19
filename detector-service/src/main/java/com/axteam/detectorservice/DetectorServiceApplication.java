package com.axteam.detectorservice;

import com.axteam.detectorservice.kafka.KafkaProducerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DetectorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DetectorServiceApplication.class, args);

		Thread run = new Thread(() -> {
			while (true) {
				try {
					ProducerRecord<String, String> record = new ProducerRecord<>(
							"Stream_of_numbers", String.valueOf((int) (Math.random() * 3)), generateNumber());
					KafkaProducerUtil.getProducer().send(record, (metadata, exception) -> {
						if (exception == null) {
							log.info(String.format("received new metadata, topic - %s; partition - %s; offset - %s; time -%s",
									metadata.topic(), metadata.partition(), metadata.offset(), metadata.timestamp()));
						} else {
							log.error("error producing", exception);
						}
					});
					//noinspection BusyWait
					Thread.sleep(1000); // 1 сек
//					Thread.sleep(10000); // 10 сек
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		run.start();
	}

	public static String generateNumber() {
		return String.valueOf((int) (Math.random() * 101));
	}
}
