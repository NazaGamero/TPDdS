package dds.grupo3.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransporteDTO {
	private String nombreTransporte;//A patin
	private String factorEmision;//Nafta/Gasoil
	private VehiculoDTO vehiculo;
	private PublicoDTO publico;
}
