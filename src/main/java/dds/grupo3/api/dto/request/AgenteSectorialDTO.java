package dds.grupo3.api.dto.request;

import dds.grupo3.clases.organizacion.Organizacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgenteSectorialDTO {
    private String nombre;
    private List<Organizacion> miTerritorio;
    private String nombreTerritorio;
    private String email;
}
