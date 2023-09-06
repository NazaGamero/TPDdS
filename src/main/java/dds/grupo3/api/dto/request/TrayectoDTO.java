package dds.grupo3.api.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrayectoDTO {
	private List<TramoDTO> tramos;
	private List<Long> participantes;
}
