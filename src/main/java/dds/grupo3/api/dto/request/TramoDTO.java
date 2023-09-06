package dds.grupo3.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TramoDTO {
	private TransporteDTO transporte;
	
	private String localidadOrigen;
	private String calleOrigen;
	private Long alturaOrigen;
	
	private String localidadDestino;
	private String calleDestino;
	private Long alturaDestino;
}
