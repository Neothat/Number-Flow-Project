package com.axteam.dataservice.services.impl;

import com.axteam.dataservice.DataServiceApplication;
import com.axteam.dataservice.dao.DataServiceDao;
import com.axteam.dataservice.services.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DataServiceImpl implements DataService {

	private DataServiceDao dataServiceDao;
	private final Logger logger = LoggerFactory.getLogger(DataServiceApplication.class);

	@Override
	public void saveDataRecord(short number) {
		OffsetDateTime now = OffsetDateTime.now();
		logger.info(String.format("%s; Number received: %s",
				now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")),
				number));
		getDataServiceDao().save(number, now);
	}

	public DataServiceDao getDataServiceDao() {
		return dataServiceDao;
	}

	@Autowired
	public void setDataServiceDao(DataServiceDao dataServiceDao) {
		this.dataServiceDao = dataServiceDao;
	}
}
