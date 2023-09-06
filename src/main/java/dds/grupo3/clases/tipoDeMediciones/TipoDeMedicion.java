package dds.grupo3.clases.tipoDeMediciones;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TIPO_MEDICION")
public class TipoDeMedicion {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Embedded
	private TipoDeActividad tipoDeactividad;
	@Embedded
	private TipoDeConsumo tipoDeConsumo;
	@Embedded
	private Unidad unidad;
	@Embedded
	private Alcance alcance;

  //TODO Ver forma para que resuelva y sepa asociar que cuando es combustion fija por ejemplo de gas natural, la unidad sea m3 y el alcance de 1: Emisiones directas
}