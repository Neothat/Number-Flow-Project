package com.axteam.analyticsservice.services.impl;

import com.axteam.analyticsservice.dao.AnalyticsServiceDao;
import com.axteam.analyticsservice.services.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

	private AnalyticsServiceDao analyticsServiceDao;

	@Override
	public void updateCounterInfo(int value) {
		getAnalyticsServiceDao().update(value);
	}

	public AnalyticsServiceDao getAnalyticsServiceDao() {
		return analyticsServiceDao;
	}

	@Autowired
	public void setAnalyticsServiceDao(AnalyticsServiceDao analyticsServiceDao) {
		this.analyticsServiceDao = analyticsServiceDao;
	}
}
