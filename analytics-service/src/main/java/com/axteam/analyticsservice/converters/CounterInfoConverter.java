package com.axteam.analyticsservice.converters;

import com.axteam.analyticsservice.models.CounterInfo;
import dto.CounterInfoDto;

public class CounterInfoConverter {
	public static CounterInfoDto convertToDto(CounterInfo info) {
		return new CounterInfoDto(info.getMetricName(), info.getValue(), info.getLastUpdateTime().toString());
	}
}
