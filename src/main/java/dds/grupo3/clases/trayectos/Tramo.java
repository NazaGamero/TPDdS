package dds.grupo3.clases.trayectos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dds.grupo3.clases.trayectos.transporte.Transporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tramo")
public class Tramo {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long idTramo;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "transporte")
  private Transporte transporte;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "punto_inicio_id")
  private Punto puntoInicio;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "punto_fin_id")
  private Punto puntoDeLlegada;
	@Column(name="distancia")
  private long distancia;

  public float calculaHU() {
    return transporte.huPorDistancia(distancia);
  }
}
