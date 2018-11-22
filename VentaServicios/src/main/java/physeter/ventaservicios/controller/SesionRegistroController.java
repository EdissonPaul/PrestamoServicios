package physeter.ventaservicios.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import physeter.ventaservicios.modelo.Categorias;
import physeter.ventaservicios.modelo.Persona;
import physeter.ventaservicios.modelo.Servicio;

@ManagedBean
@SessionScoped
public class SesionRegistroController implements Serializable {
	
	private Persona user;
	
	private List<Persona> listPersonas;
	
	
	private Servicio service;
	
	private List<Servicio> listService;
	
	public Persona getUser() {
		return user;
	}

	public void setUser(Persona user) {
		this.user = user;
	}

	public List<Persona> getListPersonas() {
		return listPersonas;
	}

	public void setListPersonas(List<Persona> listPersonas) {
		this.listPersonas = listPersonas;
	}

	public Servicio getService() {
		return service;
	}

	public void setService(Servicio service) {
		this.service = service;
	}

	public List<Servicio> getListService() {
		return listService;
	}

	public void setListService(List<Servicio> listService) {
		this.listService = listService;
	}

	
	
	

}
