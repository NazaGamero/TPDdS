package dds.grupo3.api.service.impl;

import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.api.repository.RepoMediciones;
import dds.grupo3.api.service.MedicionService;
import dds.grupo3.clases.medible.Medible;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicionServiceImpl implements MedicionService {
  @Autowired
  RepoMediciones repo;

  @Override
  public List<MedicionDTO> buscarMediciones() {
    List<MedicionDTO> mediciones = new ArrayList<>();
    for(Medible medible : repo.findAll()){
      MedicionDTO medicionDTO= new MedicionDTO(medible);
      mediciones.add(medicionDTO);
    }
    return mediciones;
  }


}
