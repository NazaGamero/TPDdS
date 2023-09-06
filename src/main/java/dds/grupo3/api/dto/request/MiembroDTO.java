package dds.grupo3.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MiembroDTO {
	private String nombre;
	private String apellido;
	private String tipoDoc;
	private Long nroDoc;
	private String sector;
}
