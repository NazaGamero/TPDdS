package dds.grupo3.api.service;

import dds.grupo3.api.dto.request.DistanciaDTO;
import dds.grupo3.api.dto.request.LocalidadDTO;
import dds.grupo3.api.dto.request.MunicipioDTO;
import dds.grupo3.api.dto.request.PaisDTO;
import dds.grupo3.api.dto.request.ProvinciaDTO;
import java.util.List;

public interface GeoddsService {

  List<PaisDTO> paises (Integer id);

  List<ProvinciaDTO> provincias(Integer id);

  List<ProvinciaDTO> provincias(Integer offset,Integer paisId);

  List<MunicipioDTO> municipios(Integer offset);

  List<MunicipioDTO> municipios(Integer offset,
                                       Integer provinciaId);

  List<LocalidadDTO> localidades(Integer offset);

  List<LocalidadDTO> localidades(Integer offset,
                                        Integer municipioId);

  DistanciaDTO distancia(Integer localidadOrigenId,
                                String calleOrigen,
                                String alturaOrigen,
                                Integer localidadDestinoId,
                                String calleDestino,
                                String alturaDestino);

}