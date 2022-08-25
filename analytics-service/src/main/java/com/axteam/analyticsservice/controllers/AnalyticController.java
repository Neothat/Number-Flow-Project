package com.axteam.analyticsservice.controllers;

import dto.CounterInfoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnalyticController {

	@GetMapping("/allCounterInfos")
	public List<CounterInfoDto> getAllCounterInfos() {
		return null;
	}
}
