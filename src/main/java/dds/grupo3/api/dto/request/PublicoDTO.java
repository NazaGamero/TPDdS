package dds.grupo3.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicoDTO {
	private String linea;//Sarmiento
	private long idParadaOrigen;//1
	private long idParadaDestino;//2
}
