package com.axteam.dataservice.dao.impl;

import com.axteam.dataservice.dao.DataDao;
import com.axteam.dataservice.entities.DataRecord;
import com.axteam.dataservice.utils.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
@Slf4j
public class DataDoaImpl implements DataDao {

	private final Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public void save(Integer number, OffsetDateTime time) {
		session.beginTransaction();
		DataRecord dataRecord = new DataRecord(number, time);
		session.save(dataRecord);
		session.getTransaction().commit();
		log.info("An entry has been added to the database: " + dataRecord);
	}

	@Override
	public List<DataRecord> getDataRecord(String startDate, String endDate) {
		OffsetDateTime editedStartDate = null;
		OffsetDateTime editedEndDate = null;

		if (startDate != null) {
			editedStartDate = OffsetDateTime.parse(startDate + "T00:00:00+03:00").minusDays(1L);
		}
		if (endDate != null) {
			editedEndDate = OffsetDateTime.parse(endDate + "T00:00:00+03:00").plusDays(1L);
		}

		StringBuilder query = new StringBuilder("select dr from DataRecord as dr");

		if (editedStartDate != null && editedEndDate != null) {
			query.append(" where time >= :startDate and time <= :endDate");
			Query<DataRecord> query1 = session.createQuery(query.toString(), DataRecord.class);
			query1.setParameter("startDate", editedStartDate);
			query1.setParameter("endDate", editedEndDate);
			return query1.getResultList();
		}

		if (editedStartDate != null) {
			query.append(" where time >= :startDate");
			Query<DataRecord> query1 = session.createQuery(query.toString(), DataRecord.class);
			query1.setParameter("startDate", editedStartDate);
			return query1.getResultList();
		}

		if (editedEndDate != null) {
			query.append(" where time <= :endDate");
			Query<DataRecord> query1 = session.createQuery(query.toString(), DataRecord.class);
			query1.setParameter("endDate", editedEndDate);
			return query1.getResultList();
		}

		return session.createQuery(query.toString(), DataRecord.class).list();
	}
}
