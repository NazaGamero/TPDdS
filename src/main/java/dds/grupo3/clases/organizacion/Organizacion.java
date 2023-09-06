package dds.grupo3.clases.organizacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dds.grupo3.api.dto.request.OrganizacionDTO;
import dds.grupo3.clases.exception.MiembroYaPerteneceOrgException;
import dds.grupo3.clases.exception.SectorNoPerteneceOrgException;
import dds.grupo3.clases.exception.YaPerteneceOrgException;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.miembro.Miembro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Organizacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Organizacion {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="RAZON_SOCIAL")
	private String razonSocial;
	@Embedded
	private TipoOrg tipo;
	@Embedded
	private Clasificacion clasificacion;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="organizacion_id")
	public List<Medible> mediciones;
	@Transient
	@JsonIgnore
	private List<Postulacion> postulados;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="organizacion_id")
	private List<Sector> sectores;
//TODO: MUY IMPORTANTE ESTE CASCADE de otra forma al intentar guardar el sector habrá error porque se hace referencia
	//a algo que no existe en la DB

	public float calcularHU() {
	    float total = 0;
	    for (Medible unMedible : this.getMediciones()) {
	      total = total + unMedible.obtenerHuella();
	    }
	    total = total+ this.calcularHUSector();
	    return total;
	  }
	
	public float calcularHUSector() {
		float subtotal = 0;
		for(Sector unSector : this.getSectores()) {
			for(Miembro unMiembro : unSector.getMiembros()) {
				subtotal = subtotal + unMiembro.calcularHU();
			}
		}
		return subtotal;
	}


  /*------------------------------------------------
   * Agregar sector y postulacion de miembros
   * ----------------------------------------------
   */

  public void agregarSector(Sector sector) throws YaPerteneceOrgException {
    if (sector.getOrganizacion() != null) {
      throw new YaPerteneceOrgException();
    } else {
      this.sectores.add(sector);
      sector.setOrganizacion(this);
    }
  }

  public void agregarMiembroSector(Sector sector, Miembro miembro)
      throws SectorNoPerteneceOrgException, MiembroYaPerteneceOrgException {
    if (miembrosOrg().stream().anyMatch(unMiembro -> unMiembro.getNroDoc().equals(miembro.getNroDoc())
    								&& unMiembro.getTipoDoc().equals(miembro.getTipoDoc()))) {//Si el miembro ya esta en la org
      throw new MiembroYaPerteneceOrgException();
    } else if (!sectores.contains(sector)) {//Si el sector no esta en la org
      throw new SectorNoPerteneceOrgException();
    } else {//Si el miembro no esta en la org y el sector está en la misma
      sector.agregarMiembro(miembro);
      //miembro.nuevoEmpleo(this,sector); TODO descomentar
    }
  }

  //De vuelve todos los miembros por sector
  public List<Miembro> miembrosOrg() {
    return sectores.stream().flatMap(s -> s.getMiembros().stream()).collect(Collectors.toList());
  }
  
  
  //Constructor personalizado para OrganizacionService
  public Organizacion(OrganizacionDTO org) {
	  clasificacion = org.getClasificacion();
	  mediciones = (new ArrayList<Medible>());
	  postulados = (new ArrayList<Postulacion>());
	  razonSocial = (org.getRazonSocial());
	  sectores = (org.getSectores());
	  tipo=(org.getTipo());
	  for(Sector sector : org.getSectores()) {
		  sector.setOrganizacion(this);
	  }
  }
}