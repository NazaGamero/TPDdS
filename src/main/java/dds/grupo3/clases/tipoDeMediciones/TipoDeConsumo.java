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
public class TipoDeConsumo {
	@Column(name="TIPO_CONSUMO")
  private String nombre;
}

/*
 * GAS_NATURAL, DIESEL_GASOIL, KEROSENE, FUEL_OIL, NAFTA, CARBON, CARBON_DE_LENIA, LENIA, ELECTRICIDAD
 *
 */