package dds.grupo3.api.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import dds.grupo3.api.controller.TrayectoController;
import dds.grupo3.api.dto.request.LineaDTO;
import dds.grupo3.api.dto.response.TrayectoDTO;
import dds.grupo3.api.repository.RepoMiembro;
import dds.grupo3.api.service.TrayectoService;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.trayectos.Trayecto;

@Controller
public class TrayectoControllerImpl implements TrayectoController {

	@Autowired
	RepoMiembro repoMiembros;
	
	@Autowired
	TrayectoService trayectoService;
	
	@Override
	public String principalTrayecto(Model model) {
		List<Miembro> miembros = repoMiembros.findAll();
		model.addAttribute("empleados", miembros);
		return "trayecto";
	}

	@Override
	public String trayectosMiembro(Model model, Long miembroId) {
		Miembro unMiembro = repoMiembros.findById(miembroId).get();
		List<Trayecto> trayectosMiembro = unMiembro.getTrayectos();
		List<TrayectoDTO> trayectosDTO = new ArrayList<TrayectoDTO>();
		if(trayectosMiembro.size() >1) {
			trayectosMiembro.forEach(t -> trayectosDTO.add(new TrayectoDTO(t)));
		}else {
			trayectosDTO.add(new TrayectoDTO(trayectosMiembro.get(0)));
		}
		
		model.addAttribute("trayectos", trayectosDTO);
		model.addAttribute("empleado", unMiembro);
		return "trayectopuntos";
	}

	@Override
	public String error() {
		return "error";
	}

	@Override
	public ResponseEntity<?> crearTrayecto(dds.grupo3.api.dto.request.TrayectoDTO trayecto) {
		try {
			trayectoService.crearTrayecto(trayecto);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> crearLinea(LineaDTO linea) {
		try {
			//Tiene sentido que la linea tenga al menos dos paradas
			if(linea.getParada().size()<2) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			trayectoService.crearLinea(linea);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
