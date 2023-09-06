package dds.grupo3.clases.agenteSectorial;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dds.grupo3.api.dto.request.AgenteSectorialDTO;
import dds.grupo3.clases.organizacion.Organizacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="AGENTE")
public class AgenteSectorial {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="NOMBRE")
	private String nombre;
	@OneToMany
	private List<Organizacion> miTerritorio;
	@Column(name="TERRITORIO")
	private String nombreTerritorio;
	@Column(name="EMAIL")
	private String email;
	
	public float calcularHuellaTerritorio() {
		float total=0;
		for(Organizacion unaOrg : miTerritorio) {
			total=total+1;//TODO cambiar a algo con sentido
		}
		return total;
	}

	public AgenteSectorial(AgenteSectorialDTO ags) {
		nombre = ags.getNombre();
		miTerritorio = (new ArrayList<Organizacion>());
		nombreTerritorio = ags.getNombreTerritorio();
		email = ags.getEmail();
	}
}