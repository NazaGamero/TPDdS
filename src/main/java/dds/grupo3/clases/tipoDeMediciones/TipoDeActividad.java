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
public class TipoDeActividad {
	@Column(name="TIPO_ACTIVIDAD")
  private String nombre;
}

/*
COMBUSTION_FIJA,
	COMBUSTION_MOVIL,
	ELECTRICIDAD_ADQUIRIDA_Y_CONSUMIDA,
	LOGISTICA_DE_PRODUCTOS_Y_RESIDUOS

*/