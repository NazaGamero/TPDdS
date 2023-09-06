package dds.grupo3.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dds.grupo3.api.repository.RepoFactorEmision;
import dds.grupo3.api.service.FactorEmisionService;
import dds.grupo3.clases.medible.FactorEmision;

@Service
public class FactorEmisionServiceImpl implements FactorEmisionService {

    @Autowired
    RepoFactorEmision repo;

    @Override
    public List<FactorEmision> buscarFactoresDeEmision() {
        return repo.findAll();
    }

	@Override
	public void editarFE(Long id, float fe) {
		Optional<FactorEmision> elFactor = repo.findById(id);
		if(elFactor.isPresent()){
			elFactor.get().setValor(fe);
			repo.save(elFactor.get());
		}
	}
}
