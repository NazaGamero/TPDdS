package dds.grupo3.api.service.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.api.dto.request.TipoDeMedicionDTO;
import dds.grupo3.api.dto.response.BatchDTO;
import dds.grupo3.api.repository.RepoBatch;
import dds.grupo3.api.repository.RepoFactorEmision;
import dds.grupo3.api.repository.RepoMediciones;
import dds.grupo3.api.repository.RepoOrganizacion;
import dds.grupo3.api.service.BatchService;
import dds.grupo3.clases.medible.BatchMediciones;
import dds.grupo3.clases.medible.FactorEmision;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.medible.Periodicidad;
import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.tipoDeMediciones.Alcance;
import dds.grupo3.clases.tipoDeMediciones.TipoDeActividad;
import dds.grupo3.clases.tipoDeMediciones.TipoDeConsumo;
import dds.grupo3.clases.tipoDeMediciones.TipoDeMedicion;
import dds.grupo3.clases.tipoDeMediciones.Unidad;
import dds.grupo3.util.Util;

@Service
public class BatchServiceImpl implements BatchService {
  @Autowired
  RepoBatch repo;

  @Autowired
  RepoFactorEmision repoFactores;
  
  @Autowired
  RepoOrganizacion repoOrg;
  
  @Autowired
  RepoMediciones repoMedi;
  
  @Override
  public void borrarBatch(Long id) {
    repo.deleteById(id);
  }

  @Override
  public BatchDTO buscarMediciones(Long id) {
    Optional<BatchMediciones> batch= repo.findById(id);
    if(!batch.isPresent())
      throw new RuntimeException("No existe el batch");

    return new BatchDTO(batch.get());
  }

  @Override
  public long cargarBatch(List<MedicionDTO> mediciones) throws ParseException {
	//Creo un batch de mediciones
    BatchMediciones batchMediciones= new BatchMediciones();
    List<FactorEmision> factores= repoFactores.findAll();
    //Creo un medible por cada medicionDTO y lo agrego a la lista del batch
	for(MedicionDTO m :mediciones){
		//Creo el nuevo medible
    	Medible medible = new Medible();
    	medible.setTipoDeMedicion(this.nuevoTipoDeMedicion(m.getTipoDeMedicion()));
    	medible.setFactorEmision(factores);
    	medible.setFecha(Util.stringToDate(m.getFecha()));
    	medible.setPeriodicidad(Periodicidad.valueOf(m.getPeriodicidad())); //Se lee el string y si coincide se guarda el enum
    	medible.setPeriodoDeImputacion(m.getPeriodoDeImputacion());
    	medible.setValor(m.getValor());
    	medible.setBatch(batchMediciones);
      //Agrego al batch de mediciones
    	batchMediciones.getMediciones().add(medible);
    }
    repo.save(batchMediciones);
    return batchMediciones.getId();
  }
  
  //Metodos Auxiliares
  
//Metodo auxiliar para los DTO de medible
  public TipoDeMedicion nuevoTipoDeMedicion(TipoDeMedicionDTO dto) {
	  TipoDeMedicion tipoMed = new TipoDeMedicion();
	  Alcance alc = new Alcance();
	  alc.setNombre(dto.getAlcance());
	  tipoMed.setAlcance(alc);
	  
	  TipoDeActividad act = new TipoDeActividad();
	  act.setNombre(dto.getTipoDeActividad());
	  tipoMed.setTipoDeactividad(act);
	  
	  TipoDeConsumo con = new TipoDeConsumo();
	  con.setNombre(dto.getTipoDeConsumo());
	  tipoMed.setTipoDeConsumo(con);
	  
	  Unidad uni = new Unidad();
	  uni.setNombre(dto.getUnidad());
	  tipoMed.setUnidad(uni);
	  
	  return tipoMed;
	  }

	@Override
	public void asignarBatch(Long id, Long idOrg) {
		Optional<Organizacion> org = repoOrg.findById(idOrg);
		Optional<BatchMediciones> batch = repo.findById(id);
		List<Medible> mediciones = batch.get().getMediciones();
		org.get().getMediciones().addAll(mediciones);
		repoOrg.save(org.get());
	}
}
