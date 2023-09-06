package dds.grupo3.clases.organizacion;

import java.util.List;

import dds.grupo3.clases.exception.NoSeEncontroClasifException;
import dds.grupo3.clases.exception.NoSeEncontroTipoException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuilderOrg {
  private List<TipoOrg> tiposOrg;
  private List<Clasificacion> clasificaciones;


  public Organizacion crearOrg() {
    return new Organizacion();//TODO especificar como y que se arma de una organizacion
  }

  public void Inicializar() {
    this.getTiposOrg().add(new TipoOrg("Gubernamental"));
    this.getTiposOrg().add(new TipoOrg("ONG"));
    this.getTiposOrg().add(new TipoOrg("Empresa"));
    this.getTiposOrg().add(new TipoOrg("Institucion"));
    this.getClasificaciones().add(new Clasificacion("Ministerio"));
    this.getClasificaciones().add(new Clasificacion("Universidad"));
    this.getClasificaciones().add(new Clasificacion("Escuela"));
    this.getClasificaciones().add(new Clasificacion("Empresa del sector primario"));
    this.getClasificaciones().add(new Clasificacion("Empresa del sector secundario"));
  }

  public TipoOrg buscarTipo(String tipo) throws NoSeEncontroTipoException {
    for (TipoOrg unTipo : this.getTiposOrg()) {
      if (unTipo.getTipo().equals(tipo)) {
        return unTipo;
      }
    }
    throw new NoSeEncontroTipoException();
  }

  public Clasificacion buscarClasificacion(String clasif) throws NoSeEncontroClasifException {
    for (Clasificacion unaClasi : this.getClasificaciones()) {
      if (unaClasi.getNombre().equals(clasif)) {
        return unaClasi;
      }
    }
    throw new NoSeEncontroClasifException();
  }
}
