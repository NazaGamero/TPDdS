package dds.grupo3.clases.tipoDeMediciones;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Alcance {
	@Column(name= "ALCANCE")
  private String nombre;
}

/*
 * EMISIONES_DIRECTAS, EMISIONES_INDIRECTAS_ASOCIADAS_A_LA_ELECTRICIDAD,
 * OTRAS_EMISIONES_INDIRECTAS_NO_CONTROLADAS
 */


//esto puede ser interfaz o abstract si es que queremos que tenga comportamiento