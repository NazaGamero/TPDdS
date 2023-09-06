package dds.grupo3.clases.medible;


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
@Table(name="FACTOR_EMISION")
public class FactorEmision {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="NOMBRE_FACTOR")
	private String nombre;
	@Column(name="VALOR")
	private float valor;

  public FactorEmision(String nombre, float valor){
    this.nombre = nombre;
    this.valor = valor;
  }
}