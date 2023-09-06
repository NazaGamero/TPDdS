package dds.grupo3.api.dto.response;

import dds.grupo3.clases.agenteSectorial.AgenteSectorial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListaAgentesSectorialesDTO {
    private List<AgenteSectorial> agentesSectoriales;
}
