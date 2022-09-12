package com.axteam.gateway.feignclients;

import dto.DataRecordDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "data", url = "http://localhost:8001")
public interface DataServiceFeignClient {

	@GetMapping("/allDataRecords")
	List<DataRecordDto> getAllDataRecords(
			@RequestParam(name = "startDate", required = false) String startDate,
			@RequestParam(name = "endDate", required = false) String endDate
	);
}
