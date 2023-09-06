package dds.grupo3.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dds.grupo3.api.repository.RepoMiembro;
import dds.grupo3.api.service.MiembroService;
import dds.grupo3.clases.miembro.Miembro;

@Service
public class MiembroServiceImpl implements MiembroService {

	@Autowired
	RepoMiembro repo;
	
	@Override
	public List<Miembro> buscarMiembros(){
		return repo.findAll();
	}

}
