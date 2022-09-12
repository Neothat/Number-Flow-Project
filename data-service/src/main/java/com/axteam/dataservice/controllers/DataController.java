package com.axteam.dataservice.controllers;

import com.axteam.dataservice.converters.DataRecordConverter;
import com.axteam.dataservice.services.DataService;
import dto.DataRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DataController {

	private DataService dataService;

	@GetMapping("/allDataRecords")
	public List<DataRecordDto> getAllDataRecords(
			@RequestParam(name = "startDate", required = false) String startDate,
			@RequestParam(name = "endDate", required = false) String endDate
	) {
		return getDataService().getDataRecord(startDate, endDate).stream()
				.map(DataRecordConverter::convertDataRecordToDto)
				.collect(Collectors.toList());
	}

	public DataService getDataService() {
		return dataService;
	}

	@Autowired
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
}
