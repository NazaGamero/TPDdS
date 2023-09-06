package dds.grupo3.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dds.grupo3.api.dto.Usuario;

@Repository
public interface RepoUsuario extends JpaRepository<Usuario, Long>{

	public Usuario findByEmail(String email);
	
}
