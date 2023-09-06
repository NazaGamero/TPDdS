package dds.grupo3.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dds.grupo3.clases.organizacion.Sector;

public interface RepoSector extends JpaRepository<Sector,Long> {

	Optional<Sector> findByNombreAndOrganizacionId(String nombre, Long org);
}
