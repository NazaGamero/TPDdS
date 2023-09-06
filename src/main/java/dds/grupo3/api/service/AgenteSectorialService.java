package dds.grupo3.api.service;

import dds.grupo3.api.dto.request.AgenteSectorialDTO;
import dds.grupo3.clases.agenteSectorial.AgenteSectorial;

import java.util.List;


public interface AgenteSectorialService {
    List<AgenteSectorial> buscarAgentesSctoriales();

    public void crearAgenteSectorial(AgenteSectorialDTO ags);

    public void borrarAgenteSectorial(Long id);

    public void editarAgenteSectorial(Long id, AgenteSectorialDTO ags);
}
