package com.axteam.dataservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "coredata")
public class DataRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "value")
	private Short value;

	@Column(name = "time")
	private OffsetDateTime time;

	public DataRecord(Short value, OffsetDateTime time) {
		this.value = value;
		this.time = time;
	}
}
