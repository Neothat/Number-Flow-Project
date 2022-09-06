package com.axteam.analyticsservice.services.impl;

import com.axteam.analyticsservice.dao.AnalyticsDao;
import com.axteam.analyticsservice.models.CounterInfo;
import com.axteam.analyticsservice.services.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

	private AnalyticsDao analyticsDao;

	@Override
	public void updateCounterInfo(int value) {
		getAnalyticsServiceDao().update(value);
	}

	@Override
	public List<CounterInfo> getAllCounterInfo() {
		return analyticsDao.getAllCounterInfo();
	}

	public AnalyticsDao getAnalyticsServiceDao() {
		return analyticsDao;
	}

	@Autowired
	public void setAnalyticsServiceDao(AnalyticsDao analyticsDao) {
		this.analyticsDao = analyticsDao;
	}
}
