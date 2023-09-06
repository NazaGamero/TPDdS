package dds.grupo3.api.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dds.grupo3.api.dto.request.DistanciaDTO;
import dds.grupo3.api.dto.request.LineaDTO;
import dds.grupo3.api.dto.request.ParadaDTO;
import dds.grupo3.api.dto.request.TramoDTO;
import dds.grupo3.api.dto.request.TrayectoDTO;
import dds.grupo3.api.feignclient.GeoddsClient;
import dds.grupo3.api.repository.RepoFactorEmision;
import dds.grupo3.api.repository.RepoLinea;
import dds.grupo3.api.repository.RepoMiembro;
import dds.grupo3.api.repository.RepoTrayecto;
import dds.grupo3.api.service.TrayectoService;
import dds.grupo3.clases.medible.FactorEmision;
import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.trayectos.Punto;
import dds.grupo3.clases.trayectos.Tramo;
import dds.grupo3.clases.trayectos.Trayecto;
import dds.grupo3.clases.trayectos.transporte.Fisico;
import dds.grupo3.clases.trayectos.transporte.Linea;
import dds.grupo3.clases.trayectos.transporte.Parada;
import dds.grupo3.clases.trayectos.transporte.ServicioContratado;
import dds.grupo3.clases.trayectos.transporte.TransportePublico;
import dds.grupo3.clases.trayectos.transporte.VehiculoParticular;

@Service
public class TrayectoServiceImpl implements TrayectoService {

	@Autowired
	RepoLinea repoLinea;
	
	@Autowired
	RepoFactorEmision repoFactor;
	
	@Autowired
	RepoMiembro repoMiembro;
	
	@Autowired
	GeoddsClient apiDistancia;
	
	@Autowired
	RepoTrayecto repoTrayecto;
	
	@Override
	public List<Trayecto> buscarTrayectos(Long miembroId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearTrayecto(TrayectoDTO trayecto) throws Exception {
		Trayecto nuevoTrayecto = new Trayecto();
		if(trayecto.getParticipantes().size()<1){throw new Exception("Se necesita al menos un participante");}
		List<Tramo> listaTramos = new ArrayList<Tramo>();
		nuevoTrayecto.setTramos(listaTramos);
		nuevoTrayecto.setMiembros(new HashSet<Miembro>());
		//Creamos los Tramos
		for(TramoDTO unTramo : trayecto.getTramos()) {
			Tramo nuevoTramo = new Tramo();
			//Dependiendo de si existe alguno de los datos de transporte
			//Se identifica si se tiene uno u otro
			//----------Transporte---------
			if(unTramo.getTransporte().getPublico() != null) {
				// Creacion del transporte - Solo en el transporte publico se ignora el dato del json "inicio llegada"
				Linea laLinea = repoLinea.findByNombre(unTramo.getTransporte().getPublico().getLinea()).get();
				TransportePublico publico = new TransportePublico();
				FactorEmision fe = repoFactor.findByNombre(unTramo.getTransporte().getFactorEmision()).get();
				publico.setConsumo(fe);
				publico.setLinea(laLinea);
				publico.setNombreTransporte(unTramo.getTransporte().getNombreTransporte());
				publico.setTipoVehiculo(unTramo.getTransporte().getNombreTransporte());
				//----------Puntos-------------
				Parada paradaInicio = laLinea.getParadas().stream().filter(p -> p.getIdParada() == unTramo.getTransporte().getPublico().getIdParadaOrigen()).findFirst().get();
				Parada paradaFin = laLinea.getParadas().stream().filter(p -> p.getIdParada() == unTramo.getTransporte().getPublico().getIdParadaOrigen()).findFirst().get();
				nuevoTramo.setPuntoInicio(paradaInicio.getDireccionParada());
				nuevoTramo.setPuntoDeLlegada(paradaFin.getDireccionParada());
				nuevoTramo.setTransporte(publico);
			}else {
				//----------Puntos-------------
				//Para todos los otros medios de transporte se guardan los datos del json
				Punto puntoInicioTramo = new Punto(unTramo.getCalleOrigen(),
										unTramo.getAlturaOrigen(),
										56L);
				Punto puntoFinTramo = new Punto(unTramo.getCalleDestino(),
										unTramo.getAlturaOrigen(),
										56L);
				nuevoTramo.setPuntoInicio(puntoInicioTramo);
				nuevoTramo.setPuntoDeLlegada(puntoFinTramo);
				//-----------Transportes no-publicos-------------
				//-----------Alerta por codigo horrible-----------
				if(unTramo.getTransporte().getVehiculo() != null) {
					//Si hay Vehiculo es porque es contratado
					ServicioContratado unServicio = new ServicioContratado();
					FactorEmision fe = repoFactor.findByNombre(unTramo.getTransporte().getFactorEmision()).get();
					unServicio.setConsumo(fe);
					unServicio.setNombreTransporte(unTramo.getTransporte().getNombreTransporte());
					unServicio.setNombreServicio(unTramo.getTransporte().getVehiculo().getNombreServicio());
					nuevoTramo.setTransporte(unServicio);
				}else if(unTramo.getTransporte().getFactorEmision() != null) {
					//Si no hay vehiculo pero hay factor emision, es un vehiculo particular
					VehiculoParticular particular = new VehiculoParticular();
					FactorEmision fe = repoFactor.findByNombre(unTramo.getTransporte().getFactorEmision()).get();
					particular.setConsumo(fe);
					particular.setNombreTransporte(unTramo.getTransporte().getNombreTransporte());
					nuevoTramo.setTransporte(particular);
				}else {
					//Si no hay ninguno de esos datos, es un medio fisico ya que no hay emision
					Fisico fisico = new Fisico();
					fisico.setConsumo(null);
					fisico.setNombreTransporte(unTramo.getTransporte().getNombreTransporte());
					nuevoTramo.setTransporte(fisico);
				}
			}
			//--------Calculo de distancia-------
			DistanciaDTO distancia = apiDistancia.distancia("Bearer P4xemTT9vHB943jjArFX6IMXq+gxQqRdzFKmE0bkZao=",1,
															nuevoTramo.getPuntoInicio().getLocalidadId(),
															nuevoTramo.getPuntoInicio().getCalle(),
															nuevoTramo.getPuntoInicio().getAltura(), 
															nuevoTramo.getPuntoDeLlegada().getLocalidadId(),
															nuevoTramo.getPuntoDeLlegada().getCalle(),
															nuevoTramo.getPuntoDeLlegada().getAltura());
			distancia.setValor(distancia.getValor().replaceAll("\\.", ""));
			nuevoTramo.setDistancia(Long.valueOf(distancia.getValor()));
			nuevoTrayecto.getTramos().add(nuevoTramo);
		}
		repoTrayecto.save(nuevoTrayecto);
		//----------Carga de participantes del trayecto--------
		for(Long documento : trayecto.getParticipantes()) {
			Miembro unMiembro = repoMiembro.findByNroDoc(documento).get();
			unMiembro.agregarUnTrayecto(nuevoTrayecto);
			nuevoTrayecto.getMiembros().add(unMiembro);
			repoMiembro.save(unMiembro);
		}
		
	}


	@Override
	public void crearLinea(LineaDTO linea) {
		Linea nuevaLinea = new Linea();
		nuevaLinea.setNombre(linea.getNombreLinea().toUpperCase());
		HashSet<Parada> listaParadas = new HashSet<Parada>();
		for(ParadaDTO parada : linea.getParada()) {
			Parada nuevaParada = new Parada();
			Punto puntoParada = new Punto();
			puntoParada.setAltura(parada.getAltura());
			puntoParada.setCalle(parada.getCalle());
			puntoParada.setLocalidadId(56L);
			nuevaParada.setDireccionParada(puntoParada);
			nuevaParada.setNombreParada(parada.getNombre());
			listaParadas.add(nuevaParada);
		}
		nuevaLinea.setParadas(listaParadas);
		repoLinea.save(nuevaLinea);
	}

}
