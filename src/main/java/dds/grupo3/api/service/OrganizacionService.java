package dds.grupo3.api.service;

import java.util.List;

import org.springframework.ui.Model;

import dds.grupo3.api.dto.request.MiembroDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;
import dds.grupo3.api.dto.response.HuFecha;
import dds.grupo3.api.dto.response.HuSectorDTO;
import dds.grupo3.api.dto.response.MedicionTemplateDTO;
import dds.grupo3.clases.organizacion.Organizacion;

public interface OrganizacionService {

	//Metodos para llamadas REST
	
	public Organizacion obtenerOrg(Long id);
	
	List<Organizacion> buscarOrganizaciones();
	
	public long crearOrganizacion(OrganizacionDTO org);
	
	public void borrarOrg(Long id);
	
	public void editarOrg(Long id, OrganizacionDTO org);
	
	public void agregarMiembro(Long id, MiembroDTO miembro) throws Exception;
	
	//Metodos para llamadas MVC
	
	public List<MedicionTemplateDTO> mediciones(Long org);
	
	//HU Total
	public float calcularHuella(Long org);
	
	public String huCategoria(Long orgId,Model model);
	
	//HU por Fecha
	public List<HuFecha> medicionesFecha(Long idOrg);
	
	//Hu por Sector/Miembro
	public List<HuSectorDTO> huellaSector(Long idOrg);
}
