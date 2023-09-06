package dds.grupo3.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dds.grupo3.clases.trayectos.Trayecto;

public interface RepoTrayecto extends JpaRepository<Trayecto, Long> {
}
