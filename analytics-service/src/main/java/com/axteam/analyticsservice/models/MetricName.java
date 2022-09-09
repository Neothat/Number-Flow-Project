package com.axteam.analyticsservice.models;

import liquibase.repackaged.org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public enum MetricName {
	WORK_IS_STABLE  (33),
	WORK_ON_WEAR (67),
	WORK_ON_EMERGENCY_OPERATION (100);

	private final int step;

	MetricName(int step) {
		this.step = step;
	}

	public int getStep() {
		return step;
	}

	@Override
	public String toString() {
		return super.name().toLowerCase(Locale.ROOT).replaceAll("_", StringUtils.SPACE);
	}
}
