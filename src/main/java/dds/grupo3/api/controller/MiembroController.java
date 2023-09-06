package dds.grupo3.api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dds.grupo3.clases.miembro.Miembro;


@RequestMapping("/miembros")
public interface MiembroController {

	@GetMapping("/trayecto")
	public String trayecto(Model trayecto);
	@GetMapping("")
	public ResponseEntity<?> obtenerListaMiembros();
	
	@PostMapping("")
	public ResponseEntity<?> crearMiembro(@RequestBody Miembro org);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarMiembro(@PathVariable("id")Integer id);
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarMiembro(@PathVariable("id")Integer id);
	
}
