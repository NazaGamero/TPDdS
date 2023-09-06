package dds.grupo3.api.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import dds.grupo3.api.dto.request.MiembroDTO;
import dds.grupo3.api.dto.request.OrganizacionDTO;
import dds.grupo3.api.dto.response.HuFecha;
import dds.grupo3.api.dto.response.HuSectorDTO;
import dds.grupo3.api.dto.response.MedicionTemplateDTO;
import dds.grupo3.api.repository.RepoFactorEmision;
import dds.grupo3.api.repository.RepoMediciones;
import dds.grupo3.api.repository.RepoMiembro;
import dds.grupo3.api.repository.RepoOrganizacion;
import dds.grupo3.api.repository.RepoSector;
import dds.grupo3.api.service.OrganizacionService;
import dds.grupo3.clases.exception.OrganizacionInexistenteException;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.organizacion.Sector;

@Service
public class OrganizacionServiceImpl implements OrganizacionService {
	@Autowired
	RepoOrganizacion repo;
	
	@Autowired
	RepoSector repoSector;
	
	@Autowired
	RepoMiembro repoMiembro;
	
	@Autowired
	RepoMediciones repoMed;
	
	@Autowired
	RepoFactorEmision repoFactor;
	
	@Override
	public Organizacion obtenerOrg(Long id) {
		return repo.findById(id).get();
	}
	
	@Override
	public List<Organizacion> buscarOrganizaciones() {
		return repo.findAll();
	}

	@Override
	public long crearOrganizacion(OrganizacionDTO org) {
		Organizacion nuevaOrg = new Organizacion(org);
		repo.save(nuevaOrg);
		return nuevaOrg.getId();
	}

	@Override
	public void borrarOrg(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public void editarOrg(Long id, OrganizacionDTO org) {
		//Busco la Organizacion
		Optional<Organizacion> laOrg = repo.findById(id);
		//Si la DB pudo conseguir algo, la modifico
		if(laOrg.isPresent()) {
			laOrg.get().setClasificacion(org.getClasificacion());
			laOrg.get().setRazonSocial(org.getRazonSocial());
			laOrg.get().setSectores(org.getSectores());
			laOrg.get().setTipo(org.getTipo());
		}
		repo.save(laOrg.get());
	}

	@Override
	public void agregarMiembro(Long id, MiembroDTO miembro) throws Exception{
		Optional<Organizacion> org = repo.findById(id);
		if(org.isPresent()) {
			Optional<Sector> sector = repoSector.findByNombreAndOrganizacionId(miembro.getSector().toUpperCase(), org.get().getId());
			Optional<Miembro> elMiembro = repoMiembro.findByNroDoc(miembro.getNroDoc());
			Miembro nuevoMiembro;
			if(elMiembro.isPresent()) {
				 nuevoMiembro = elMiembro.get();
			}else {
				 nuevoMiembro = new Miembro(miembro);
			}
			
			if(sector.isPresent()) {
				
				org.get().agregarMiembroSector(sector.get(), nuevoMiembro);
				repoSector.save(sector.get());
			}else {
				Sector nuevoSector = new Sector();
				nuevoSector.setOrganizacion(org.get());
				org.get().getSectores().add(nuevoSector);
				nuevoSector.setNombre(miembro.getSector().toUpperCase());
				org.get().agregarMiembroSector(nuevoSector, nuevoMiembro);
				repoSector.save(nuevoSector);
			}
		}else {
			throw new OrganizacionInexistenteException();
		}
		
	}

	@Override
	public float calcularHuella(Long org) {
		return repo.findById(org).get().calcularHU();
	}
	
	@Override
	public List<MedicionTemplateDTO> mediciones(Long org) {
		Optional<Organizacion> laOrg = repo.findById(org);
		List<Medible> medicionesOrg = laOrg.get().getMediciones();
		List<MedicionTemplateDTO> medicionesTemplateDTO = new ArrayList<MedicionTemplateDTO>();
		for(Medible unMedible : medicionesOrg){
			MedicionTemplateDTO unMedibleDTO = new MedicionTemplateDTO();
			unMedibleDTO.setTipoDeActividad(unMedible.getTipoDeMedicion().getTipoDeactividad().getNombre());
			unMedibleDTO.setTipoDeConsumo(unMedible.getTipoDeMedicion().getTipoDeConsumo().getNombre());
			unMedibleDTO.setValor(unMedible.getValor()*unMedible.getMiFactor().getValor());
			medicionesTemplateDTO.add(unMedibleDTO);
		}
		return medicionesTemplateDTO;
	}

	@Override
	public String huCategoria(Long orgId, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HuFecha> medicionesFecha(Long idOrg) {
		//Busco la organizacion y obtengo sus mediciones
		Organizacion org = repo.findById(idOrg).get();
		List<Medible> mediciones = org.getMediciones();
		
		//Medible tiene un metodo "compareTo" que ayuda a que se ordenen los elementos por fecha
		Collections.sort(mediciones);
		
		//Creo una lista de HuFecha
		Iterator<Medible> iterador = mediciones.iterator();
		List<HuFecha> listaFechas = new ArrayList<HuFecha>();
		while(iterador.hasNext()) {
			Medible unMedible = iterador.next();
			HuFecha unMes = new HuFecha(unMedible);
			listaFechas.add(unMes);
		}
		
		//Elimino repetidos de la lista y sumo los valores de esos repetidos
		listaFechas = this.transformarListaFechas(listaFechas);
		return listaFechas;
	}
	
	//Solo Dios y yo sabiamos que estaba haciendo cuando escribí esto
	//Ahora solo Dios sabe
	private List<HuFecha> transformarListaFechas(List<HuFecha> lista) {
		//Como ya ordene la lista de medibles por fecha, esta nueva lista esta ordenada tambien
		Iterator<HuFecha> iterador = lista.iterator();
		HuFecha fecha1 = null;
		HuFecha fecha2 = null;
		List<HuFecha> listaSinRepetidos = new ArrayList<HuFecha>();
		//Siempre que la lista sea mayor o igual que dos
		if(lista.size()>=2) {
			fecha1 = iterador.next(); //Obtengo el primer valor
			do {
				//Muevo el fecha2 al siguiente valor
				fecha2 = iterador.next();
				//Evaluo si son equivalentes (Con el metodo override equals que se hizo)
				if(fecha1.equals(fecha2)) {
					//Si son iguales sumo los valores y avanzo al siguiente objeto
					fecha1.setValor(fecha1.getValor()+fecha2.getValor());
				}else {
					//Si no son iguales, guardo el primer elemento, y avanzo con el iterador
					listaSinRepetidos.add(fecha1);
					fecha1 = fecha2;
				}
			}while(iterador.hasNext());
			listaSinRepetidos.add(fecha1);
		}else {
			//Si solo es un elemento
			return lista;
		}
		//Retorno la lista sin repetidos con valores sumados
		return listaSinRepetidos;
	}

	@Override
	public List<HuSectorDTO> huellaSector(Long idOrg) {
		Organizacion org = repo.findById(idOrg).get();
		List<HuSectorDTO> lista = new ArrayList<HuSectorDTO>();
		for(Sector unSector : org.getSectores()) {
			for(Miembro unMiembro : unSector.getMiembros()) {
				HuSectorDTO unHuMiembro = new HuSectorDTO();
				unHuMiembro.setNombreMiembro(unMiembro.obtenerNombre());
				unHuMiembro.setSector(unSector.getNombre());
				unHuMiembro.setValorHU(unMiembro.calcularHU());
				lista.add(unHuMiembro);
			}
		}
		return lista;
	}
}