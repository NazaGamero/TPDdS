package dds.grupo3.clases.trayectos.transporte;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dds.grupo3.clases.trayectos.Punto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PARADA")
public class Parada{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PARADA", nullable = false)
	private long idParada;
	@Column(name="NOMBRE")
  private String nombreParada;
	@OneToOne(cascade=CascadeType.ALL)
  private Punto direccionParada;
  
}

