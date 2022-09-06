package com.axteam.analyticsservice.services;

import com.axteam.analyticsservice.models.CounterInfo;

import java.util.List;

public interface AnalyticsService {
	void updateCounterInfo(int value);
	List<CounterInfo> getAllCounterInfo();
}