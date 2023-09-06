package dds.grupo3.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dds.grupo3.clases.miembro.Miembro;

public interface RepoMiembro extends JpaRepository<Miembro, Long> {
	Optional<Miembro> findById(Long id);
	
	Optional<Miembro> findByNroDoc(Long nroDoc);
	
}
