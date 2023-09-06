package dds.grupo3.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HuSectorDTO {
	private String sector;
	private String nombreMiembro;
	private float valorHU;
}
