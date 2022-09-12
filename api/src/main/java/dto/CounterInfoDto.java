package dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Информация о счетчике")
public class CounterInfoDto {

	@Schema(description = "Имя счетчика", required = true)
	private String metricName;
	@Schema(description = "Показание счетчика", required = true)
	private Integer value;
	@Schema(description = "Время последнего обновления", required = true)
	private String lastUpdateTime;

}
