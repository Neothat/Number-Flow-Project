package com.axteam.dataservice.mappers;

import com.axteam.dataservice.entities.DataRecord;
import dto.DataRecordDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateTimeMapper.class})
public interface DataRecordMapper {

	DataRecordMapper INSTANCE = Mappers.getMapper(DataRecordMapper.class);

	@Mapping(target = "id", source = "id")
	@Mapping(target = "value", source = "value")
	@Mapping(target = "time", source = "time", dateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	DataRecordDto toDto(DataRecord dataRecord);

}
