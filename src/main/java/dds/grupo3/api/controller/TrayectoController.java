package dds.grupo3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dds.grupo3.api.dto.request.LineaDTO;
import dds.grupo3.api.dto.request.TrayectoDTO;

@RequestMapping("/trayectos")
public interface TrayectoController {

	@GetMapping("")
	public String principalTrayecto(Model model);
	
	@GetMapping("/miembro")
	public String trayectosMiembro(Model model,
			@RequestParam(value = "id_miembro", required = true) Long miembroId);
	
	@GetMapping("/error")
	public String error();
	
	//----------------------
	//REST
	//----------------------
	@PostMapping("/api/")
	public ResponseEntity<?> crearTrayecto(@RequestBody TrayectoDTO trayecto);
	
	@PostMapping("/api/linea")
	public ResponseEntity<?> crearLinea(@RequestBody LineaDTO linea);
}
