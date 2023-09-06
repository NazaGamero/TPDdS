package dds.grupo3.api.dto.request;

import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoDeMedicionDTO {

	private String tipoDeActividad;
	
	private String tipoDeConsumo;
	  
	private String unidad;
	  
	private String alcance;
	
	public TipoDeMedicionDTO(TipoDeMedicion jpa) {
		tipoDeActividad = jpa.getTipoDeactividad().getNombre();
		tipoDeConsumo = jpa.getTipoDeConsumo().getNombre();
		unidad = jpa.getUnidad().getNombre();
		alcance = jpa.getAlcance().getNombre();
	}
}
