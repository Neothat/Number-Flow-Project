package com.axteam.dataservice.converters;

import com.axteam.dataservice.entities.DataRecord;
import dto.DataRecordDto;

public class DataRecordConverter {
	public static DataRecordDto convertDataRecordToDto(DataRecord dataRecord) {
		return new DataRecordDto(dataRecord.getId(), dataRecord.getValue(), dataRecord.getTime().toString());
	}
}
