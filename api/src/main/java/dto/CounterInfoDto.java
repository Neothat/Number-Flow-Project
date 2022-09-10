package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CounterInfoDto {

	private String metricName;
	private Integer value;
	private String lastUpdateTime;

}
