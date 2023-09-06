package dds.grupo3.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dds.grupo3.api.dto.request.AgenteSectorialDTO;
import dds.grupo3.api.repository.RepoAgenteSectorial;
import dds.grupo3.api.service.AgenteSectorialService;
import dds.grupo3.clases.agenteSectorial.AgenteSectorial;

@Service
public class AgenteSectorialServiceImpl implements AgenteSectorialService {
    @Autowired
    RepoAgenteSectorial repo;

    @Override
    public List<AgenteSectorial> buscarAgentesSctoriales() {
        return repo.findAll();
    }

    @Override
    public void crearAgenteSectorial(AgenteSectorialDTO ags) {
        AgenteSectorial nuevaAgs = new AgenteSectorial(ags);
        repo.save(nuevaAgs);
    }

    @Override
    public void borrarAgenteSectorial(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void editarAgenteSectorial(Long id, AgenteSectorialDTO ags) {
        //Busco la Organizacion
        Optional<AgenteSectorial> laAgs = repo.findById(id);
        //Si la DB pudo conseguir algo, la modifico
        if(laAgs.isPresent()) {
            laAgs.get().setNombre(ags.getNombre());
            laAgs.get().setMiTerritorio(ags.getMiTerritorio());
            laAgs.get().setNombreTerritorio(ags.getNombreTerritorio());
            laAgs.get().setEmail(ags.getEmail());
        }
        repo.save(laAgs.get());
    }
}
