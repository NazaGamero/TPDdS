package dds.grupo3.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dds.grupo3.clases.medible.BatchMediciones;

public interface RepoBatch extends JpaRepository<BatchMediciones, Long> {
  Optional<BatchMediciones> findById(Long id);
}
