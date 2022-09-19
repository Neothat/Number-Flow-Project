package com.axteam.analyticsservice.mappers;

import com.axteam.analyticsservice.entities.CounterInfo;
import dto.CounterInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateTimeMapper.class})
public interface CounterInfoMapper {

	CounterInfoMapper INSTANCE = Mappers.getMapper(CounterInfoMapper.class);

	@Mapping(target = "metricName", source = "metricName")
	@Mapping(target = "value", source = "value")
	@Mapping(target = "lastUpdateTime", source = "lastUpdateTime", dateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	CounterInfoDto toDto(CounterInfo counterInfo);

}
