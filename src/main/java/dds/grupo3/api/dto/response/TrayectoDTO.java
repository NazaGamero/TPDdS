package dds.grupo3.api.dto.response;

import dds.grupo3.clases.trayectos.Trayecto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrayectoDTO {
	
	private long id;
	private String direccionInicio;
	private String direccionFin;
	
	public TrayectoDTO(Trayecto t) {
		id = t.getIdTrayecto();
		direccionInicio = 	t.getTramos().get(0).getPuntoInicio().getCalle() + " " + 
							Long.toString( t.getTramos().get(0).getPuntoInicio().getAltura());
		direccionFin = 	t.getTramos().get(t.getTramos().size()-1).getPuntoDeLlegada().getCalle() + " " +
						Long.toString( t.getTramos().get(t.getTramos().size()-1).getPuntoDeLlegada().getAltura());
	}
}
