package dds.grupo3.api.repository;

import dds.grupo3.clases.agenteSectorial.AgenteSectorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepoAgenteSectorial extends JpaRepository<AgenteSectorial, Long> {
    Optional<AgenteSectorial> findById(Long id);

    Optional<AgenteSectorial> findByIdAndNombre(Long id, String nombre);
}
