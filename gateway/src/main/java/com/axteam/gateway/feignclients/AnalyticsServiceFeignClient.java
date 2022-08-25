package com.axteam.gateway.feignclients;

import dto.CounterInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "analytics", url = "http://localhost:")
public interface AnalyticsServiceFeignClient {

	@GetMapping("/allCounterInfos")
	public List<CounterInfoDto> getAllCounterInfos();
}
