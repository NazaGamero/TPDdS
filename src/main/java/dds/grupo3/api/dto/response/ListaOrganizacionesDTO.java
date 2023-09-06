package dds.grupo3.api.dto.response;

import java.util.List;

import dds.grupo3.clases.organizacion.Organizacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListaOrganizacionesDTO {
	private List<Organizacion> organizaciones;
}