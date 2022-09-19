package com.axteam.dataservice.services.impl;

import com.axteam.dataservice.dao.DataDao;
import com.axteam.dataservice.entities.DataRecord;
import com.axteam.dataservice.kafka.KafkaProducerUtil;
import com.axteam.dataservice.services.DataService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class DataServiceImpl implements DataService {

	private DataDao dataDao;

	@Override
	public void saveDataRecord(Integer number) {
		OffsetDateTime now = OffsetDateTime.now();
		log.info(String.format("%s; Number received: %s",
				now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")),
				number));
		getDataDao().save(number, now);
		checkIncident(number);
	}

	@Override
	public void checkIncident(Integer number) {
		if (number == 100) {
			ProducerRecord<String, String> record = new ProducerRecord<>(
					"Stream_of_incidents", "1", String.valueOf(number));
			KafkaProducerUtil.getProducer().send(record, (metadata, exception) -> {
				if (exception == null) {
					log.info(String.format("received new metadata, topic - %s; partition - %s; offset - %s; time -%s",
							metadata.topic(), metadata.partition(), metadata.offset(), metadata.timestamp()));
				} else {
					log.error("error producing", exception);
				}
			});
		}
	}

	@Override
	public List<DataRecord> getDataRecord(String startDate, String endDate) {
		return getDataDao().getDataRecord(startDate, endDate);
	}

	public DataDao getDataDao() {
		return dataDao;
	}

	@Autowired
	public void setDataDao(DataDao dataDao) {
		this.dataDao = dataDao;
	}
}
