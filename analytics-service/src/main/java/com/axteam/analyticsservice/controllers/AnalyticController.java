package com.axteam.analyticsservice.controllers;

import com.axteam.analyticsservice.mappers.CounterInfoMapper;
import com.axteam.analyticsservice.services.AnalyticsService;
import dto.CounterInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AnalyticController {

	private AnalyticsService analyticsService;

	@GetMapping("/allCounterInfos")
	public List<CounterInfoDto> getAllCounterInfos() {
		return getAnalyticsService().getAllCounterInfo().stream()
				.map(CounterInfoMapper.INSTANCE::toDto)
				.collect(Collectors.toList());
	}

	public AnalyticsService getAnalyticsService() {
		return analyticsService;
	}

	@Autowired
	public void setAnalyticsService(AnalyticsService analyticsService) {
		this.analyticsService = analyticsService;
	}
}
