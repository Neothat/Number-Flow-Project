package com.axteam.dataservice.services;

import com.axteam.dataservice.models.DataRecord;

import java.util.List;

public interface DataService {
	void saveDataRecord(short number);
	void checkIncident(short number);
	List<DataRecord> getDataRecord(String startDate, String endDate);
}
