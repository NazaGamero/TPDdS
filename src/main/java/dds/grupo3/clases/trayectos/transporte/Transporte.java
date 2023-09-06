package dds.grupo3.clases.trayectos.transporte;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import dds.grupo3.clases.medible.FactorEmision;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="transporte")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_transporte", 
  discriminatorType = DiscriminatorType.INTEGER)
public class Transporte {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long idTransporte;
	@Column(name="nombre")
	private String nombreTransporte;
	@OneToOne
	private FactorEmision consumo;
	
	public float huPorDistancia(float distancia) {
		return (distancia * this.getConsumo().getValor());
	}
}