package dds.grupo3.api.service;

import java.util.List;

import dds.grupo3.api.dto.request.LineaDTO;
import dds.grupo3.api.dto.request.TrayectoDTO;
import dds.grupo3.clases.trayectos.Trayecto;

public interface TrayectoService {

	List<Trayecto> buscarTrayectos(Long miembroId);
	
	public void crearTrayecto(TrayectoDTO trayecto) throws Exception;
	
	public void crearLinea(LineaDTO linea);
}
