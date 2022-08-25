package com.axteam.gateway.controllers;

import com.axteam.gateway.feignclients.AnalyticsServiceFeignClient;
import com.axteam.gateway.feignclients.DataServiceFeignClient;
import dto.CounterInfoDto;
import dto.DataRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GatewayController {

	private DataServiceFeignClient dataServiceFeignClient;
	private AnalyticsServiceFeignClient analyticsServiceFeignClient;

	@GetMapping
	public List<CounterInfoDto> getAllCounterInfos(){
		return getAnalyticsServiceFeignClient().getAllCounterInfos();
	}

	@GetMapping
	public Page<DataRecordDto> getAllDataRecords(
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "startDate", required = false) String startDate,
			@RequestParam(name = "endDate", required = false) String endDate
	) {
		return getDataServiceFeignClient().getAllDataRecords(page, startDate, endDate);
	}

	public DataServiceFeignClient getDataServiceFeignClient() {
		return dataServiceFeignClient;
	}

	@Autowired
	public void setDataServiceFeignClient(DataServiceFeignClient dataServiceFeignClient) {
		this.dataServiceFeignClient = dataServiceFeignClient;
	}

	public AnalyticsServiceFeignClient getAnalyticsServiceFeignClient() {
		return analyticsServiceFeignClient;
	}

	@Autowired
	public void setAnalyticsServiceFeignClient(AnalyticsServiceFeignClient analyticsServiceFeignClient) {
		this.analyticsServiceFeignClient = analyticsServiceFeignClient;
	}
}
