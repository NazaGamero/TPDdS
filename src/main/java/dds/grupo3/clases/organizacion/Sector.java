package dds.grupo3.clases.organizacion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import dds.grupo3.clases.miembro.Miembro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="SECTOR")
public class Sector {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
	@ManyToOne
	@JsonBackReference
  public Organizacion organizacion;
	@Column(name="NOMBRE_SECTOR")
  private String nombre;
	@ManyToMany(cascade=CascadeType.ALL)
  private List<Miembro> miembros;

  public void agregarMiembro(Miembro miembro) {
    this.miembros.add(miembro);
  }
  
  public Sector() {
	  organizacion = null;
	  id = null;
	  nombre = null;
	  miembros = new ArrayList<Miembro>();
  }
}