package dds.grupo3.clases.trayectos.transporte;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Linea {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_LINEA", nullable = false)
	private long idLinea;
	@Column(name="NOMBRE")
    private String nombre;
	@OneToMany(cascade=CascadeType.ALL)
    private Set<Parada> paradas;
}