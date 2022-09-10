package com.axteam.analyticsservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "analytics")
public class CounterInfo {

	@Id
	@Column(name = "metric_name")
	private String metricName;

	@Column(name = "value")
	private int value;

	@Column(name = "last_update_time")
	private OffsetDateTime lastUpdateTime;

}
