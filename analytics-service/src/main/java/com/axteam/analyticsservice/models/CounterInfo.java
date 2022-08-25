package com.axteam.analyticsservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CounterInfo {

	private String metricName;
	private int value;
	private Date lastUpdateTime;

}
