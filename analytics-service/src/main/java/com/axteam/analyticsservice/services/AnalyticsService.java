package com.axteam.analyticsservice.services;

import com.axteam.analyticsservice.entities.CounterInfo;

import java.util.List;

public interface AnalyticsService {
	void updateCounterInfo(int value);
	List<CounterInfo> getAllCounterInfo();
}
