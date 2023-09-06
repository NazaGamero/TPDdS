package dds.grupo3.api.dto.request;

import java.util.List;

import dds.grupo3.clases.organizacion.Clasificacion;
import dds.grupo3.clases.organizacion.Sector;
import dds.grupo3.clases.organizacion.TipoOrg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizacionDTO {
	private String razonSocial;
	private TipoOrg tipo;
	private Clasificacion clasificacion;
	private List<Sector> sectores;
}
