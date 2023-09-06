package dds.grupo3.clases.medible;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MEDIBLE")
public class Medible implements Comparable<Medible> {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(cascade=CascadeType.ALL)
	private TipoDeMedicion tipoDeMedicion;
	
	@Column(name="VALOR")
	private float valor;
	
	@Column(name="PERIODICIDAD")
	private Periodicidad periodicidad;
	//Es un enum para saber durante cuanto tiempo se hizo esa medicion
	
	@Column(name="PERIODO")
	private String periodoDeImputacion;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private FactorEmision miFactor;
	
	@Column(name="FECHA")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne
	@JsonBackReference
	private BatchMediciones batch;

  //Periodicidad{
  // int 1 = Anual
  // int 0 = mensual

  public float obtenerHuella() {
    return this.valor * this.getMiFactor().getValor();
  }

  public void setFactorEmision(List<FactorEmision> factores) {
    for (FactorEmision unFactor : factores) {
      if (unFactor.getNombre().equals(this.tipoDeMedicion.getTipoDeConsumo().getNombre())) {
        this.miFactor = unFactor;
      }
    }
  }

	@Override
	public int compareTo(Medible b) {
		return this.getFecha().compareTo(b.getFecha());
	}
  
}