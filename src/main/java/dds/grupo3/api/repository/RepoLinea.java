package dds.grupo3.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dds.grupo3.clases.trayectos.transporte.Linea;

public interface RepoLinea extends JpaRepository<Linea, Long>{

	Optional<Linea> findByNombre(String nombre);
	
	Optional<Linea> findById(Long id);
}
