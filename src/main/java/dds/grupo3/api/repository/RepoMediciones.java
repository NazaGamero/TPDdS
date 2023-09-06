package dds.grupo3.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dds.grupo3.clases.medible.Medible;

public interface RepoMediciones extends JpaRepository<Medible, Long> {
  Optional<Medible> findById(Long id);
}
