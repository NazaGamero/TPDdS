package dds.grupo3.api.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import dds.grupo3.api.dto.request.DistanciaDTO;
import dds.grupo3.api.dto.request.LocalidadDTO;
import dds.grupo3.api.dto.request.MunicipioDTO;
import dds.grupo3.api.dto.request.PaisDTO;
import dds.grupo3.api.dto.request.ProvinciaDTO;
import dds.grupo3.api.service.GeoddsService;

//La siguiente clase es una alternativa al uso de FeignClient que se tiene en el package "FeignClient"
//Por tanto, ambas hacen lo mismo
public class GeoddsServiceImpl implements GeoddsService {
	
	
  private final String token= "2gSCEk8R7REUaVp5KuT6S2GxOo8dauKwuxuMJDQw8JA=";
  private final String url = "https://ddstpa.com.ar/api/";
  private HttpEntity<String> entity;

  public GeoddsServiceImpl() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer "+token);
    this.entity = new HttpEntity<>("body", headers);
  }

  @Override
  public List<PaisDTO> paises(Integer id) {
    RestTemplate restTemplate = new RestTemplate();
    PaisDTO[] paises= restTemplate.exchange(url+"paises?offset="+id.toString(), HttpMethod.GET, entity, PaisDTO[].class).getBody();
    return Arrays.asList(paises);
  }

  @Override
  public List<ProvinciaDTO> provincias(Integer offset) {
    RestTemplate restTemplate = new RestTemplate();
    ProvinciaDTO[] provincias= restTemplate.exchange(url+"provincias?offset="+offset.toString(), HttpMethod.GET, entity, ProvinciaDTO[].class).getBody();
    return Arrays.asList(provincias);
  }

  @Override
  public List<ProvinciaDTO> provincias(Integer offset, Integer paisId) {
    RestTemplate restTemplate = new RestTemplate();
    ProvinciaDTO[] provincias= restTemplate
        .exchange(url+"provincias?offset="+offset.toString()+"&paisId="+paisId.toString(), HttpMethod.GET, entity, ProvinciaDTO[].class).getBody();
    return Arrays.asList(provincias);
  }

  @Override
  public List<MunicipioDTO> municipios(Integer offset) {
    RestTemplate restTemplate = new RestTemplate();
    MunicipioDTO[] municipios= restTemplate
        .exchange(url+"municipios?offset="+offset.toString(), HttpMethod.GET, entity, MunicipioDTO[].class).getBody();
    return Arrays.asList(municipios);
  }

  @Override
  public List<MunicipioDTO> municipios(Integer offset, Integer provinciaId) {
    RestTemplate restTemplate = new RestTemplate();
    MunicipioDTO[] municipios= restTemplate
        .exchange(url+"municipios?offset="+offset.toString()+"&provinciaId="+provinciaId.toString(), HttpMethod.GET, entity, MunicipioDTO[].class).getBody();
    return Arrays.asList(municipios);
  }

  @Override
  public List<LocalidadDTO> localidades(Integer offset) {
    RestTemplate restTemplate = new RestTemplate();
    LocalidadDTO[] localidades= restTemplate
        .exchange(url+"localidades?offset="+offset.toString(), HttpMethod.GET, entity, LocalidadDTO[].class).getBody();
    return Arrays.asList(localidades);
  }

  @Override
  public List<LocalidadDTO> localidades(Integer offset, Integer municipioId) {
    RestTemplate restTemplate = new RestTemplate();
    LocalidadDTO[] localidades= restTemplate
        .exchange(url+"localidades?offset="+offset.toString()+"&municipioId="+municipioId.toString(), HttpMethod.GET, entity, LocalidadDTO[].class).getBody();
    return Arrays.asList(localidades);
  }

  @Override
  public DistanciaDTO distancia(Integer localidadOrigenId, String calleOrigen, String alturaOrigen,
                                Integer localidadDestinoId, String calleDestino, String alturaDestino) {
    RestTemplate restTemplate = new RestTemplate();
    String queryParams= "?localidadOrigenId="+localidadDestinoId.toString()+"&calleOrigen="+calleOrigen+
        "&alturaOrigen="+alturaOrigen+"&localidadDestinoId="+localidadDestinoId.toString()+
        "&calleDestino="+calleDestino+"&alturaDestino="+alturaDestino;
    DistanciaDTO distancia= restTemplate
        .exchange(url+"distancia"+queryParams, HttpMethod.GET, entity, DistanciaDTO.class).getBody();
    return distancia;
  }

}
