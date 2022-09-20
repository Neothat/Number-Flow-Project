package com.axteam.analyticsservice.controllers;

import com.axteam.analyticsservice.mappers.CounterInfoMapper;
import com.axteam.analyticsservice.services.AnalyticsService;
import dto.CounterInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AnalyticController {

	private AnalyticsService analyticsService;

	@GetMapping("/allCounterInfos")
	public ResponseEntity<List<CounterInfoDto>> getAllCounterInfos() {
		return new ResponseEntity<>(getAnalyticsService().getAllCounterInfo().stream()
				.map(CounterInfoMapper.INSTANCE::toDto)
				.collect(Collectors.toList()), HttpStatus.OK);
	}

	public AnalyticsService getAnalyticsService() {
		return analyticsService;
	}

	@Autowired
	public void setAnalyticsService(AnalyticsService analyticsService) {
		this.analyticsService = analyticsService;
	}
}
