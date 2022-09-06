package com.axteam.gateway.controllers;

import com.axteam.gateway.feignclients.AnalyticsServiceFeignClient;
import com.axteam.gateway.feignclients.DataServiceFeignClient;
import dto.CounterInfoDto;
import dto.DataRecordDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/gateway")
@Tag(name = "Данные", description = "Методы для просмотра данных")
public class GatewayController {

	private DataServiceFeignClient dataServiceFeignClient;
	private AnalyticsServiceFeignClient analyticsServiceFeignClient;

	@Operation(
			summary = "Тестовый метод",
			responses = {
					@ApiResponse(
							description = "Успешный ответ", responseCode = "200",
							content = @Content(schema = @Schema(implementation = String.class))
					)
			}
	)
	@GetMapping
	public String hello() {
		return "Hello";
	}

	@Operation(
			summary = "Запрос на получение информации по трем счетчикам",
			responses = {
					@ApiResponse(
							description = "Успешный ответ", responseCode = "200",
							content = @Content(schema = @Schema(implementation = List.class))
					)
			}
	)
	@GetMapping("/allCounterInfos")
	public List<CounterInfoDto> getAllCounterInfos() {
		return getAnalyticsServiceFeignClient().getAllCounterInfos();
	}

	@Operation(
			summary = "Запрос на получение информации, сгенерированной датчиком. Есть параметри для фильтрации по датам",
			responses = {
					@ApiResponse(
							description = "Успешный ответ", responseCode = "200",
							content = @Content(schema = @Schema(implementation = List.class))
					)
			}
	)
	@GetMapping("/allDataRecords")
	public List<DataRecordDto> getAllDataRecords(
			@RequestParam @Parameter(name = "startDate", description = "Параметр отвечающий с какого числа показать результаты", required = false) String startDate,
			@RequestParam @Parameter(name = "endDate", description = "Параметр отвечающий по какое число показать результаты", required = false) String endDate
	) {
		return getDataServiceFeignClient().getAllDataRecords(startDate, endDate);
	}

	public DataServiceFeignClient getDataServiceFeignClient() {
		return dataServiceFeignClient;
	}

	@Autowired
	public void setDataServiceFeignClient(DataServiceFeignClient dataServiceFeignClient) {
		this.dataServiceFeignClient = dataServiceFeignClient;
	}

	public AnalyticsServiceFeignClient getAnalyticsServiceFeignClient() {
		return analyticsServiceFeignClient;
	}

	@Autowired
	public void setAnalyticsServiceFeignClient(AnalyticsServiceFeignClient analyticsServiceFeignClient) {
		this.analyticsServiceFeignClient = analyticsServiceFeignClient;
	}
}
