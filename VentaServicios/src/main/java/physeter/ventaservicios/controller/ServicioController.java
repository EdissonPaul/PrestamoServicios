package physeter.ventaservicios.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import physeter.ventaservicios.DAO.ServicioDAO;
import physeter.ventaservicios.modelo.Categorias;
import physeter.ventaservicios.modelo.Ciudad;
import physeter.ventaservicios.modelo.Persona;
import physeter.ventaservicios.modelo.Profesion;
import physeter.ventaservicios.modelo.Provincia;
import physeter.ventaservicios.modelo.Servicio;

@ManagedBean(name="serviciobean")
@SessionScoped
public class ServicioController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//@ManagedProperty("#{sesionController}")
	////private SesionController sesionController;
	
	@Inject
	private ServicioDAO servicioDAO;
	
	private List<Servicio> servicioFiltrado;
	
	private List<Servicio> listServicio;
	
	private List<Servicio> listServicio1;
	
	
	private Servicio servicio;
	
	@Inject
	private Profesion profesion;
	
	public List<Servicio> getServicioFiltrado() {
		return servicioFiltrado;
	}

	public void setServicioFiltrado(List<Servicio> servicioFiltrado) {
		this.servicioFiltrado = servicioFiltrado;
	}

	public List<Servicio> getAllData(){
		return servicioDAO.listServicio();
	}

	public List<Servicio> getListServicio() {
		return listServicio;
	}

	public void setListServicio(List<Servicio> listServicio) {
		this.listServicio = listServicio;
	}
	
	/*public SesionController getSesionController() {
		return sesionController;
	}

	public void setSesionController(SesionController sesionController) {
		this.sesionController = sesionController;
	}
*/
	
	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}
	

	public List<Servicio> getListServicio1() {
		return listServicio1;
	}

	public void setListServicio1(List<Servicio> listServicio1) {
		this.listServicio1 = listServicio1;
	}

	@PostConstruct
	public void init(){
		loadServicio();
	}
	
	private void loadServicio(){
		System.out.println("entro ..a.a.a.a..");
		listServicio1 = servicioDAO.listadoServicio("Cuenca", "Docencia");
		for (int i = 0; i < listServicio1.size(); i++) {
			System.out.println(listServicio1.get(i).getCiudad().getNombre());
		}
	}
	
	
	/*
	public String obternerInfoServicioPersona(int id){
		System.out.println("entro...........");
		System.out.println(id);
		listServicio = servicioDAO.getServicio(id);
		for (int i = 0; i < listServicio.size(); i++) {
			System.out.println(listServicio.get(i).getExperiencia());
		}
		
		return null;
	}
	*/
	
	public String porbar(){
		
		System.out.println(servicio.getExperiencia());
		//System.out.println(sesionController.getPersona().getNombre());
		
		//System.out.println(servicio.getCiudad().getProvincia().getNombre());
		//System.out.println(profesion.getProfesion());
		return null;
	}

}
