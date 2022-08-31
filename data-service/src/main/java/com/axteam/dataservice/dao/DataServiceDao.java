package com.axteam.dataservice.dao;

import java.time.OffsetDateTime;

public interface DataServiceDao {
	void save(short number, OffsetDateTime time);
}
