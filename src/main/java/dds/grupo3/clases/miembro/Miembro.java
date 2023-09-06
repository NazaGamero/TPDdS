package dds.grupo3.clases.miembro;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import dds.grupo3.api.dto.request.MiembroDTO;
import dds.grupo3.clases.trayectos.Trayecto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="miembro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Miembro {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;
  @Column(name="NOMBRE")
  private String nombre;
  @Column(name="APELLIDO")
  private String apellido;
  @Column(name="TIPO_DOC")
  private TipoDocEnum tipoDoc;
  @Column(name="DOCUMENTO")
  private Long nroDoc;
  @ManyToMany
  @JoinColumn(name="miembro_id")
  private List<Trayecto> trayectos;

  public Miembro(String nombre, String apellido, TipoDocEnum tipoDoc, Long nroDoc) {
    super();
    this.nombre = nombre;
    this.apellido = apellido;
    this.tipoDoc = tipoDoc;
    this.nroDoc = nroDoc;
  }

  public void agregarUnTrayecto(Trayecto unTrayecto) {
    trayectos.add(unTrayecto);
  }

  public float calcularHU() {
    return (float) trayectos.stream().mapToDouble(t -> t.calculaHUPorMiembro()).sum();
  }
  
  public String obtenerNombre() {
	  return (this.getNombre() + " " + this.getApellido());
  }
  
  public Miembro(MiembroDTO dto) {
	  this.nombre = dto.getNombre();
	    this.apellido = dto.getApellido();
	    this.tipoDoc = TipoDocEnum.valueOf(dto.getTipoDoc());
	    this.nroDoc = dto.getNroDoc();
  }
}
