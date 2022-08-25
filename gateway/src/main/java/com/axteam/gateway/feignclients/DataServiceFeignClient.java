package com.axteam.gateway.feignclients;

import dto.DataRecordDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "data", url = "http://localhost:")
public interface DataServiceFeignClient {

	@GetMapping("/allDataRecords")
	public Page<DataRecordDto> getAllDataRecords(
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "startDate", required = false) String startDate,
			@RequestParam(name = "endDate", required = false) String endDate
	);
}
