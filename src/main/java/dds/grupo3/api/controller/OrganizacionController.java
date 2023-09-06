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
import org.springframework.web.bind.annotation.RequestParam;

import dds.grupo3.api.dto.request.MiembroDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;

@RequestMapping("/organizaciones")
public interface OrganizacionController {

	//--------------------------------------
	//		Consultas de HU (MVC)
	//--------------------------------------
	
	@GetMapping("/calculoHU")
	public String calculoHU(Model model);
	
	@GetMapping(path="/calculoHU/valor", params="action=total")
	public String huValor(@RequestParam(value = "org", required = true) Long orgId,
			@RequestParam(value = "org", required = true) String action,
			Model model);
	
	@GetMapping(path="/calculoHU/valor", params="action=categoria")
	public String huCategoria(@RequestParam(value = "org", required = true) Long orgId,
			@RequestParam(value = "org", required = true) String action,
			Model model);
	
	@GetMapping(path="/calculoHU/valor", params="action=empleado")
	public String huSector(@RequestParam(value = "org", required = true) Long orgId,
			@RequestParam(value = "org", required = true) String action,
			Model model);
	
	@GetMapping(path="/calculoHU/valor", params="action=fecha")
	public String huFecha(@RequestParam(value = "org", required = true) Long orgId,
			@RequestParam(value = "org", required = true) String action,
			Model model);
	
	@GetMapping("/error")
	public String error();
	
	//--------------------------------------
	//		ABM Organizaciones (REST)
	//--------------------------------------
	
	@GetMapping("/api/")
	public ResponseEntity<?> obtenerListaOrganizaciones();
	
	@PostMapping("/api/")
	public ResponseEntity<?> crearOrganizacion(@RequestBody OrganizacionDTO org);
	
	
	@DeleteMapping("/api/{id}")
	public ResponseEntity<?> borrarOrganizacion(@PathVariable("id")Long id);
	
	@PutMapping("/api/{id}")
	public ResponseEntity<?> editarOrganizacion(@PathVariable("id")Long id, @RequestBody OrganizacionDTO org);

	@PostMapping("/api/{id}")
	public ResponseEntity<?> agregarMiembro(@PathVariable("id")Long id,@RequestBody MiembroDTO miembro);
}
