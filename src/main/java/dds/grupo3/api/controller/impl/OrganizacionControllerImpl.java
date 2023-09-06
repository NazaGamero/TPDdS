package dds.grupo3.api.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import dds.grupo3.api.controller.OrganizacionController;
import dds.grupo3.api.dto.request.MiembroDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;
import dds.grupo3.api.dto.response.HuFecha;
import dds.grupo3.api.dto.response.HuSectorDTO;
import dds.grupo3.api.dto.response.ListaOrganizacionesDTO;
import dds.grupo3.api.dto.response.MedicionTemplateDTO;
import dds.grupo3.api.service.OrganizacionService;
import dds.grupo3.clases.exception.MiembroYaPerteneceOrgException;
import dds.grupo3.clases.exception.OrganizacionInexistenteException;
import dds.grupo3.clases.organizacion.Organizacion;

@Controller
public class OrganizacionControllerImpl implements OrganizacionController {
	@Autowired
	OrganizacionService organizacionService;


	@Override
	public ResponseEntity<?> obtenerListaOrganizaciones() {
		ListaOrganizacionesDTO response = new ListaOrganizacionesDTO();
		//traigo de la DB
		//Ojo con hacer mucha logica aca
		//Aca solo llamas services
		try {
			response.setOrganizaciones(organizacionService.buscarOrganizaciones());
		} catch (Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> crearOrganizacion(OrganizacionDTO org) {
		long id = organizacionService.crearOrganizacion(org);
		return new ResponseEntity<>("Organizacion creada con ID: " + id,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> borrarOrganizacion(Long id) {
		organizacionService.borrarOrg(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> editarOrganizacion(Long id, OrganizacionDTO org) {
		organizacionService.editarOrg(id,org);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> agregarMiembro(Long id, MiembroDTO miembro) {
		try {
			organizacionService.agregarMiembro(id,miembro);
		}catch(OrganizacionInexistenteException e) {
			return new ResponseEntity<>("La organizacion indicada no existe", HttpStatus.BAD_REQUEST);
		}catch(MiembroYaPerteneceOrgException e) {
			return new ResponseEntity<>("El miembro ya pertenece a esta organizacion", HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//TODO seguir este ejemplo. El archivo template se llama "prueba" y por eso se completa ahi la informacion
	public String prueba(Model model) {
		model.addAttribute("algo", "asd");
		return "prueba";
		
	}
	
	/*
	 * Obtengo la pagina de calculoHU principal para elegir la organizacion
	 */
	public String calculoHU(Model model) {
		//model.addAttribute("organizacions", organizacionService.buscarOrganizaciones().stream().map(org -> (org.getRazonSocial())).collect(Collectors.toList()));
		model.addAttribute("organizacions", organizacionService.buscarOrganizaciones());
		return "calcularHU";
	}

	/*
	 * A partir de la pantalla donde el usuario eligió la organizacion. Obtengo la huella de esa organizacion
	 */
	@Override
	public String huValor(Long orgId,String action,Model model) {
		float total= organizacionService.calcularHuella(orgId);
		Organizacion organizacion = organizacionService.obtenerOrg(orgId);
		model.addAttribute("organizacion", organizacion);
		model.addAttribute("valorHU", total);
		return "calcularHUvalorHU";//TODO hacer que este metodo reciba informacion del modelo anterior
	}

	@Override
	public String huCategoria(Long orgId,String action,Model model) {
		Organizacion organizacion = organizacionService.obtenerOrg(orgId);
		List<MedicionTemplateDTO> mediciones = organizacionService.mediciones(orgId);
		model.addAttribute("organizacion", organizacion);
		model.addAttribute("HUs", mediciones);
		return "calcularHUdesgloseCategoria";
	}

	@Override
	public String huSector(Long orgId,String action, Model model) {
		Organizacion organizacion = organizacionService.obtenerOrg(orgId);
		try {
			List<HuSectorDTO> listaHuSector = organizacionService.huellaSector(orgId);
			model.addAttribute("organizacion", organizacion);
			model.addAttribute("HUs", listaHuSector);
			return "calcularHUdesgloseEmpleado";
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}

	@Override
	public String huFecha(Long orgId,String action,Model model) {
		Organizacion organizacion = organizacionService.obtenerOrg(orgId);
		List<HuFecha> huCalendario = organizacionService.medicionesFecha(orgId);
		model.addAttribute("organizacion", organizacion);
		model.addAttribute("HUs", huCalendario);
		return "calcularHUdesgloseFecha";
	}
	
	@Override
	public String error() {
		return "error";
	}
}