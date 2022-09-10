package com.axteam.dataservice.services;

import com.axteam.dataservice.models.DataRecord;

import java.util.List;

public interface DataService {
	void saveDataRecord(Integer number);
	void checkIncident(Integer number);
	List<DataRecord> getDataRecord(String startDate, String endDate);
}
