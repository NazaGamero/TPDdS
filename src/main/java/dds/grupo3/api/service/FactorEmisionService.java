package dds.grupo3.api.service;

import java.util.List;

import dds.grupo3.clases.medible.FactorEmision;

public interface FactorEmisionService {
    List<FactorEmision> buscarFactoresDeEmision();
    
    void editarFE(Long id, float fe);
}
