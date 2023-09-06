package dds.grupo3.api.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import dds.grupo3.api.dto.request.DistanciaDTO;
import dds.grupo3.api.dto.request.LocalidadDTO;
import dds.grupo3.api.dto.request.MunicipioDTO;
import dds.grupo3.api.dto.request.PaisDTO;
import dds.grupo3.api.dto.request.ProvinciaDTO;

@FeignClient(name="Geodds", url="https://ddstpa.com.ar/api/")
public interface GeoddsClient {

  @GetMapping(value="paises")
  public List<PaisDTO> paises (	@RequestHeader(value = "Authorization", required = true) String token, 
		  						@RequestParam("offset") Integer id);

  @GetMapping("provincias")
  public List<ProvinciaDTO> provincias(	@RequestHeader(value = "Authorization", required = true) String token, 
		  								@RequestParam("offset") int offset, 
		  								@RequestParam("paisId") int paisId);

  @GetMapping("municipios")
  public List<MunicipioDTO> municipios(	@RequestHeader(value = "Authorization", required = true) String token,
		  								@RequestParam("offset") int offset,
		  								@RequestParam("provinciaId") int provinciaId);


  @GetMapping("localidades")
  public List<LocalidadDTO> localidades(@RequestHeader(value = "Authorization", required = true) String token,
		  								@RequestParam("offset") int offset,
		  								@RequestParam("municipioId") int provinciaId);

  @GetMapping("distancia")
  public DistanciaDTO distancia(@RequestHeader(value = "Authorization", required = true) String bearerToken,
		  						@RequestParam("offset") int offset,
		  						@RequestParam("localidadOrigenId") long localidadOrigenId,
                                @RequestParam("calleOrigen") String calleOrigen,
                                @RequestParam("alturaOrigen") long alturaOrigen,
                                @RequestParam("localidadDestinoId") long localidadDestinoId,
                                @RequestParam("calleDestino") String calleDestino,
                                @RequestParam("alturaDestino") long alturaDestino);

}