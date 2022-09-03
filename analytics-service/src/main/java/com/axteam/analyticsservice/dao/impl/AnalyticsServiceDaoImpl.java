package com.axteam.analyticsservice.dao.impl;

import com.axteam.analyticsservice.dao.AnalyticsServiceDao;
import com.axteam.analyticsservice.models.CounterInfo;
import com.axteam.analyticsservice.models.MetricName;
import com.axteam.analyticsservice.utils.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@Repository
public class AnalyticsServiceDaoImpl implements AnalyticsServiceDao {

	private static final Logger logger = LoggerFactory.getLogger(AnalyticsServiceDaoImpl.class);
	private final Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public void update(int value) {
		CounterInfo counterInfo = getCounterInfoByValue(value);
		if (counterInfo != null) {
			session.beginTransaction();
			counterInfo.setValue(counterInfo.getValue() + 1);
			counterInfo.setLastUpdateTime(OffsetDateTime.now());
			session.save(counterInfo);
			session.getTransaction().commit();
			logger.info("Counter updated to " + counterInfo);
		} else {
			logger.warn("counter not updated, unknown value: " + value);
		}
	}

	private CounterInfo getCounterInfoByValue(int value) {
		if (value < MetricName.WORK_IS_STABLE.getStep()) {
			return session.get(CounterInfo.class, MetricName.WORK_IS_STABLE.toString());
		}
		if (value < MetricName.WORK_ON_WEAR.getStep()) {
			return session.get(CounterInfo.class, MetricName.WORK_ON_WEAR.toString());
		}
		if (value < MetricName.WORK_ON_EMERGENCY_OPERATION.getStep()) {
			return session.get(CounterInfo.class, MetricName.WORK_ON_EMERGENCY_OPERATION.toString());
		}
		return null;
	}
}
