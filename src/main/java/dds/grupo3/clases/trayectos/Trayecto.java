package dds.grupo3.clases.trayectos;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import dds.grupo3.clases.miembro.Miembro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TRAYECTO")
public class Trayecto {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long idTrayecto;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="trayecto_id")
	@OrderColumn
  private List<Tramo> tramos;
	@ManyToMany
	@JsonBackReference
  private Set<Miembro> miembros;

  public float calcularHU() {
	  return (float) tramos.stream().mapToDouble(t-> t.calculaHU()).sum();
  }
  
//Se divide en HU por cada miembro para no contar dos veces el HU
  public float calculaHUPorMiembro() {
	    return (this.calcularHU()/this.miembros.size());
	  }
}
