package com.axteam.analyticsservice.services.impl;

import com.axteam.analyticsservice.dao.AnalyticsDao;
import com.axteam.analyticsservice.entities.CounterInfo;
import com.axteam.analyticsservice.services.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

	private AnalyticsDao analyticsDao;

	@Override
	public void updateCounterInfo(int value) {
		getAnalyticsDao().update(value);
	}

	@Override
	public List<CounterInfo> getAllCounterInfo() {
		return analyticsDao.getAllCounterInfo();
	}

	public AnalyticsDao getAnalyticsDao() {
		return analyticsDao;
	}

	@Autowired
	public void setAnalyticsDao(AnalyticsDao analyticsDao) {
		this.analyticsDao = analyticsDao;
	}
}
