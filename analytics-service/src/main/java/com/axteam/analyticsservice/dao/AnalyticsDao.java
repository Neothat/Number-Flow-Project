package com.axteam.analyticsservice.dao;

import com.axteam.analyticsservice.entities.CounterInfo;

import java.util.List;

public interface AnalyticsDao {
	void update(int value);
	List<CounterInfo> getAllCounterInfo();
}
