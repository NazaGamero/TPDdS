package dds.grupo3.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import dds.grupo3.clases.organizacion.Organizacion;

public interface RepoOrganizacion extends JpaRepository<Organizacion, Long> {
	Optional<Organizacion> findById(Long id);
	
	Optional<Organizacion> findByIdAndRazonSocial(Long id, String RazonSocial);
}
