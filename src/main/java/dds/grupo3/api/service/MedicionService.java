package dds.grupo3.api.service;

import java.util.List;

import dds.grupo3.api.dto.request.MedicionDTO;

public interface MedicionService {
  List<MedicionDTO> buscarMediciones();
}
