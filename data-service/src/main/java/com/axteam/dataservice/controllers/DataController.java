package com.axteam.dataservice.controllers;

import com.axteam.dataservice.mappers.DataRecordMapper;
import com.axteam.dataservice.services.DataService;
import dto.DataRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DataController {

	private DataService dataService;

	@GetMapping("/allDataRecords")
	public List<DataRecordDto> getAllDataRecords(
			@RequestParam(name = "startDate", required = false)
			@Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$") String startDate,
			@RequestParam(name = "endDate", required = false)
			@Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$") String endDate
	) {
		return getDataService().getDataRecord(startDate, endDate).stream()
				.map(DataRecordMapper.INSTANCE::toDto)
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
