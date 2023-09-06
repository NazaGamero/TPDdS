package dds.grupo3.api.service;

import java.text.ParseException;
import java.util.List;

import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.api.dto.response.BatchDTO;

public interface BatchService {
	
  void borrarBatch(Long id);
  
  BatchDTO buscarMediciones(Long id);
  
  public long cargarBatch(List<MedicionDTO> mediciones) throws ParseException;
  
  void asignarBatch(Long id, Long idOrg);
}
