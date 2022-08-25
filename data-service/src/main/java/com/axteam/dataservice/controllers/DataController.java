package com.axteam.dataservice.controllers;

import dto.DataRecordDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

	@GetMapping("/allDataRecords")
	public Page<DataRecordDto> getAllDataRecords(
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "startDate", required = false) String startDate,
			@RequestParam(name = "endDate", required = false) String endDate
	) {
		return null;
	}
}
