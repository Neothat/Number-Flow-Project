package com.axteam.dataservice.services.impl;

import com.axteam.dataservice.DataServiceApplication;
import com.axteam.dataservice.dao.DataServiceDao;
import com.axteam.dataservice.kafka.KafkaProducerUtil;
import com.axteam.dataservice.services.DataService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class DataServiceImpl implements DataService {

	private DataServiceDao dataServiceDao;
	private final Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);

	@Override
	public void saveDataRecord(short number) {
		OffsetDateTime now = OffsetDateTime.now();
		logger.info(String.format("%s; Number received: %s",
				now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")),
				number));
		getDataServiceDao().save(number, now);
		checkIncident(number);
	}

	@Override
	public void checkIncident(short number) {
		if (number == 100) {
			ProducerRecord<String, String> record = new ProducerRecord<>(
					"Stream_of_incidents", UUID.randomUUID().toString(), String.valueOf(number));
			KafkaProducerUtil.getProducer().send(record, (metadata, exception) -> {
				if (exception == null) {
					logger.info(String.format("received new metadata, topic - %s; partition - %s; offset - %s; time -%s",
							metadata.topic(), metadata.partition(), metadata.offset(), metadata.timestamp()));
				} else {
					logger.error("error producing", exception);
				}
			});
		}
	}

	public DataServiceDao getDataServiceDao() {
		return dataServiceDao;
	}

	@Autowired
	public void setDataServiceDao(DataServiceDao dataServiceDao) {
		this.dataServiceDao = dataServiceDao;
	}
}
