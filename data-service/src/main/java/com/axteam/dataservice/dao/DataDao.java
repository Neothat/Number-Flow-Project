package com.axteam.dataservice.dao;

import com.axteam.dataservice.models.DataRecord;

import java.time.OffsetDateTime;
import java.util.List;

public interface DataDao {
	void save(short number, OffsetDateTime time);
	List<DataRecord> getDataRecord(String startDate, String endDate);
}
