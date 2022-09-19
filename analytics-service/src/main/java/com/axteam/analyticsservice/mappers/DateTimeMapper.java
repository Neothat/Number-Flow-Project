package com.axteam.analyticsservice.mappers;

import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeMapper {

	public String toString(OffsetDateTime offsetDateTime) {
		return offsetDateTime != null
				? DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(offsetDateTime)
				: null;
	}
}