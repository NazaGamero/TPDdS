package dds.grupo3.clases.trayectos;

import javax.persistence.Column;
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
@Table(name="Punto")
public class Punto {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long idPunto;
	@Column(name="localidad_id")
  private long localidadId;
	@Column(name="altura")
  private long altura;
	@Column(name="calle")
  private String calle;
	
	public Punto(String calle, long altura, long localidadId) {
		this.calle = calle;
		this.altura = altura;
		this.localidadId = localidadId;
	}
}
