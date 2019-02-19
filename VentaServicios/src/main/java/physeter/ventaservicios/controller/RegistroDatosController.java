package physeter.ventaservicios.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import physeter.ventaservicios.DAO.CategoriaDao;
import physeter.ventaservicios.DAO.PersonaDAO;
import physeter.ventaservicios.DAO.ProfesionDAO;
import physeter.ventaservicios.DAO.ProvinciaDAO;
import physeter.ventaservicios.DAO.ServicioDAO;
import physeter.ventaservicios.modelo.Categorias;
import physeter.ventaservicios.modelo.Ciudad;
import physeter.ventaservicios.modelo.Persona;
import physeter.ventaservicios.modelo.Profesion;
import physeter.ventaservicios.modelo.Provincia;
import physeter.ventaservicios.modelo.Servicio;

@ManagedBean(name="registroDatosController")
@ViewScoped
public class RegistroDatosController {

	
	
	@Inject
	private SesionRegistroController sesionRegistroController;
	
	@ManagedProperty("#{sesionController}")
	private SesionController sesionController;
	
	@Inject
	private Profesion profesion;
	
	@Inject
	private Servicio servicio;
	
	@Inject
	private CategoriaDao categoriaDAO;
	
	@Inject
	private ProvinciaDAO provinciaDAO;
	
	@Inject
	private PersonaDAO personaDAO;
	
	@Inject
	private ProfesionDAO profesionDAO;
	
	@Inject
	private ServicioDAO servicioDAO;
	/*
	 * Listas y campos para manejar los combos
	 * 
	 */
	private List<SelectItem> listaProvincias;
	private String provincia;
	
	private List<SelectItem> listaCategorias;
	private String categoria;
	
	private List<SelectItem> listaCiudades;
	private String ciudades;
	
	private List<Categorias> categoriasDeBase;
	private List<Provincia> provinciasDeBase;
	
	private Provincia provinciaa;
	
	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	public SesionRegistroController getSesionRegistroController() {
		return sesionRegistroController;
	}

	public void setSesionRegistroController(SesionRegistroController sesionRegistroController) {
		this.sesionRegistroController = sesionRegistroController;
	}
	
	public List<SelectItem> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<SelectItem> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	public List<SelectItem> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<SelectItem> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public List<SelectItem> getListaCiudades() {
		return listaCiudades;
	}

	public void setListaCiudades(List<SelectItem> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}
	
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCiudades() {
		return ciudades;
	}

	public void setCiudades(String ciudades) {
		this.ciudades = ciudades;
	}
	
	public SesionController getSesionController() {
		return sesionController;
	}

	public void setSesionController(SesionController sesionController) {
		this.sesionController = sesionController;
	}

	@PostConstruct
	public void init(){
		cargarCategorias();
		cargarProvincias();

	}

	public String probar(){
		
		
		try{
			profesion.setPersona(sesionRegistroController.getUser());
			servicio.setPersona(sesionRegistroController.getUser());
			personaDAO.insertar(sesionRegistroController.getUser());
			profesionDAO.insertaraProfesion(profesion);
			servicioDAO.insertaraServicio(servicio);
			return "login";
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public String probar1(){
		System.out.println("etnto ... .. .. .");
		
		System.out.println(sesionController.getPersona().getNombre());
		System.out.println(servicio.getCategoria().getNombre());
		profesion.setPersona(sesionController.getPersona());
		servicio.setPersona(sesionController.getPersona());
		profesionDAO.insertaraProfesion(profesion);
		servicioDAO.insertaraServicio(servicio);
		//System.out.println(sesionController.getPersona().getApellido());
		return null;
	}
	
	public void cargarCategorias(){
		listaCategorias = new ArrayList<SelectItem>();
		categoriasDeBase = categoriaDAO.listadoCategoria();
		listaCategorias.add(new SelectItem("vacio","SELECCIONA LA CATEGORIA"));
		for (int i = 0; i < categoriasDeBase.size(); i++) {
			listaCategorias.add(new SelectItem(categoriasDeBase.get(i).getNombre(),categoriasDeBase.get(i).getNombre()));
		}
		
	}
	
	public void seleccionarCategoriasCombo(){
		System.out.println("entro seleccion categorias "+categoriasDeBase.size());
		try{
			for (int i = 0; i < categoriasDeBase.size(); i++) {
				if(categoriasDeBase.get(i).getNombre().equals(categoria)){
					
					servicio.setCategoria(categoriasDeBase.get(i));
					sesionRegistroController.setService(servicio);
					System.out.println(servicio.getCategoria().getNombre());
				}
			}
		}catch(Exception e){
			
		}
		
	}
	
	public void cargarProvincias(){
		listaProvincias = new ArrayList<SelectItem>();
		provinciasDeBase = provinciaDAO.listaProvincias();
		listaProvincias.add(new SelectItem("vacio","SELECCIONA LA PROVINCIA"));
		for (int i = 0; i < provinciasDeBase.size(); i++) {
			listaProvincias.add(new SelectItem(provinciasDeBase.get(i).getNombre(),provinciasDeBase.get(i).getNombre()));
		}
		
	}
	
	public void agregarProvinciaCiudadCombo(){
		
			provinciaa = provinciaDAO.getProvincias(provincia).get(0);
			if(provinciaa.getCiudad()!=null){
				cargarCiudades(provinciaa.getCiudad());
			}
	}
	
	public void cargarCiudades(List<Ciudad> ciu){
		
		listaCiudades = new ArrayList<SelectItem>();
		listaCiudades.add(new SelectItem("vacio","SELECCIONA LA CIUDAD"));
		
		if(ciu != null && ciu.size() > 0){
			for (int i = 0; i < ciu.size(); i++) {
				listaCiudades.add(new SelectItem(ciu.get(i).getNombre(),ciu.get(i).getNombre()));
			}
		}
		
	}
	
	public void seleccionarCiudadCombo(){
		try{
			for(int i = 0;i<provinciaa.getCiudad().size();i++){
				if(provinciaa.getCiudad().get(i).getNombre().equals(ciudades)){
					System.out.println(provinciaa.getCiudad().get(i).getNombre());
					servicio.setCiudad(provinciaa.getCiudad().get(i));
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
