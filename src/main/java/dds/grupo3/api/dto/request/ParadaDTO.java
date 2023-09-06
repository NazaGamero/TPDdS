package dds.grupo3.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParadaDTO {
	private String nombre;
	private String localidad;
	private String calle;
	private Long altura;
}
