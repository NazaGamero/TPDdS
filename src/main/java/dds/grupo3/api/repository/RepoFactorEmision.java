package dds.grupo3.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dds.grupo3.clases.medible.FactorEmision;

public interface RepoFactorEmision extends JpaRepository<FactorEmision, Long> {
    Optional<FactorEmision> findById(Long id);
    
    Optional<FactorEmision> findByNombre(String nombre);
}