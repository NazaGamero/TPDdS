package dds.grupo3.api.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import dds.grupo3.api.controller.MiembroController;
import dds.grupo3.api.dto.response.ListaMiembrosDTO;
import dds.grupo3.api.service.MiembroService;
import dds.grupo3.clases.miembro.Miembro;

@RestController
public class MiembroControllerImpl implements MiembroController {

	@Autowired
	MiembroService miembroService;
	
	@Override
	public ResponseEntity<?> obtenerListaMiembros() {
		ListaMiembrosDTO response = new ListaMiembrosDTO();
		//traigo de la DB
		//Ojo con hacer mucha logica aca
		//Aca solo llamas services
		try {
			response.setMiembros(miembroService.buscarMiembros());
		} catch (Exception e){
			return new ResponseEntity<>("sos un puto", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> crearMiembro(Miembro org) {
		return null;
	}

	@Override
	public ResponseEntity<?> borrarMiembro(Integer id) {
		return null;
	}

	@Override
	public ResponseEntity<?> editarMiembro(Integer id) {
		return null;
	}

	@Override
	public String trayecto(Model trayecto) {
		// TODO Auto-generated method stub
		return null;
	}

}
