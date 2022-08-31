package com.axteam.dataservice.dao.impl;

import com.axteam.dataservice.dao.DataServiceDao;
import com.axteam.dataservice.models.DataRecord;
import com.axteam.dataservice.utils.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@Repository
public class DataServiceDoaImpl implements DataServiceDao {

	private static final Logger logger = LoggerFactory.getLogger(DataServiceDoaImpl.class);
	private final Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public void save(short number, OffsetDateTime time) {
		session.beginTransaction();
		DataRecord dataRecord = new DataRecord(number, time);
		session.save(dataRecord);
		session.getTransaction().commit();
		logger.info("An entry has been added to the database: " + dataRecord);
	}
}
