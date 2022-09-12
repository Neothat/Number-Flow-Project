package dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Информация о пришедшем числе")
public class DataRecordDto {

	@Schema(description = "ID Числа", required = true)
	private long id;
	@Schema(description = "Число", required = true, minimum = "0", maximum = "100")
	private Integer value;
	@Schema(description = "Время записи данного числа", required = true)
	private String time;

}
