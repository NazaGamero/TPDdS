package dds.grupo3.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dds.grupo3.clases.trayectos.transporte.ServicioContratado;
import dds.grupo3.clases.trayectos.transporte.Transporte;

public interface RepoTransporte  extends JpaRepository<Transporte, Long>  {
	Optional<Transporte> findById(Long id);
	
	
	//Como estamos manejando un singleTable para la herencia, dejo un ejemplo para traer solo una clase
	@Query("from ServicioContratado")
	List<ServicioContratado> findAllServicioContratado();
}
