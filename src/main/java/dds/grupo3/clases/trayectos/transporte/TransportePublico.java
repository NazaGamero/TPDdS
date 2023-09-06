package dds.grupo3.clases.trayectos.transporte;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("2")
public class TransportePublico extends Transporte {
	//Tren o colectivo
	@Column(name="tipo_publico")
  private String tipoVehiculo;
	@OneToOne
	@JoinColumn(name = "linea_id")
  private Linea linea;
}