package physeter.ventaservicios.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import physeter.ventaservicios.DAO.CategoriaDao;
import physeter.ventaservicios.DAO.ProfesionDAO;
import physeter.ventaservicios.DAO.ProvinciaDAO;
import physeter.ventaservicios.DAO.ServicioDAO;
import physeter.ventaservicios.modelo.Categorias;
import physeter.ventaservicios.modelo.Ciudad;
import physeter.ventaservicios.modelo.Persona;
import physeter.ventaservicios.modelo.Profesion;
import physeter.ventaservicios.modelo.Provincia;
import physeter.ventaservicios.modelo.Servicio;

@ManagedBean
@ViewScoped
@SessionScoped
public class ProfesionController implements Serializable{
	
	@Inject
	private SesionController sesionController;

	@Inject
	private Persona persona;
	
	@Inject
	private Profesion profesion;
	
	@Inject
	private Servicio servicio;
	
	private List<Servicio> listServicio;
	
	private Categorias categoriaa;
	
	private Provincia provinciaa;
	
	
	@Inject
	private SesionRegistroController sesionRegistroController;
	
	private String errUsuario;
	
	@Inject
	private ProfesionDAO profesionDAO;
	
	@Inject
	private ServicioDAO servicioDAO;
	
	@Inject
	private CategoriaDao categoriaDAO;
	
	@Inject
	private ProvinciaDAO provinciaDAO;
	
	private Date date2;
	
	private String anos;
	
	SimpleDateFormat formateador ;
	
	
	private List<Categorias> categoriasDeBase;
	private List<Provincia> provinciasDeBase;
	
	private Ciudad ciudad;
	
	private int id;

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
	
	private List<Ciudad> listCities;
	
	private String campoCiud="";
	private String campoCat="";
	

	public List<Ciudad> getListCities() {
		return listCities;
	}

	public void setListCities(List<Ciudad> listCities) {
		this.listCities = listCities;
	}

	
	public SesionRegistroController getSesionRegistroController() {
		return sesionRegistroController;
	}

	public void setSesionRegistroController(SesionRegistroController sesionRegistroController) {
		this.sesionRegistroController = sesionRegistroController;
	}

	@ManagedProperty("#{personaController}")
	private PersonaController personaController;
	
	public PersonaController getPersonaController() {
		return personaController;
	}

	public void setPersonaController(PersonaController personaController) {
		this.personaController = personaController;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

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

	
	
	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public String getAnos() {
		return anos;
	}

	public void setAnos(String anos) {
		this.anos = anos;
	}
	
	
	public List<SelectItem> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<SelectItem> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<SelectItem> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<SelectItem> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Categorias getCategoriaa() {
		return categoriaa;
	}

	public void setCategoriaa(Categorias categoriaa) {
		this.categoriaa = categoriaa;
	}

	public String getCiudades() {
		return ciudades;
	}

	public void setCiudades(String ciudades) {
		this.ciudades = ciudades;
	}
	
	public List<SelectItem> getListaCiudades() {
		return listaCiudades;
	}

	public void setListaCiudades(List<SelectItem> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}
	
	public void loadDatosEditar(int id){
		servicio = servicioDAO.leer(id);
	}

	public List<Servicio> getListServicio() {
		return listServicio;
	}

	public void setListServicio(List<Servicio> listServicio) {
		this.listServicio = listServicio;
	}

	@PostConstruct
	public void init(){
		profesion =new Profesion();
		servicio = new Servicio();
		categoriaa = new Categorias();
		ciudad = new Ciudad();
		persona = new Persona();
		provinciaa = new Provincia();
		persona.getProfesion().add(profesion);
		listaCiudades = new ArrayList<SelectItem>();
		
		cargarCategorias();
		cargarProvincias();
		
		loadServicio();
	}
	
	
	/**
	 * Metodo para validar datos de profesion
	 * @return
	 */
	public String validarDatosRegistro(){
	
		errUsuario = "";
		
		
		if(errUsuario.equals("")){
			System.out.println(servicio.getCiudad().getNombre());
			System.out.println(servicio.getCiudad().getProvincia().getNombre());
			/*
			
			System.out.println(sesionRegistroController.getUser().getGenero());
			System.out.println(sesionRegistroController.getUser().getCedula());
			System.out.println(profesion.getTitulo());
			
			profesion.setPersona(sesionRegistroController.getUser());
			servicio.setPersona(sesionRegistroController.getUser());
			servicio.setCategoria(sesionRegistroController.getService().getCategoria());
			
			System.out.println(servicio.getPersona().getCedula());
			System.out.println(servicio.getCategoria().getNombre());
			System.out.println(ciudades);
			*/
			
			
			
		//	System.out.println(servicio.getCiudad().getNombre());
			
			
			
			
			 // personaController.registrarPersona();
			 // profesionDAO.insertaraProfesion(profesion);
			 // servicioDAO.insertaraServicio(servicio);
			 // init();
			
			System.out.println(personaController.getPersona().getCorreo());
			System.out.println(servicio.getDescripcion());
			//System.out.println(servicio.getCategoria().getNombre());
			
			profesion.setPersona(personaController.getPersona());
			servicio.setPersona(personaController.getPersona());
			
			personaController.registrarPersona();
			profesionDAO.insertaraProfesion(profesion);
			servicioDAO.insertaraServicio(servicio);
			init();
		
		}
		
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
					servicio.setCiudad(provinciaa.getCiudad().get(i));
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	private void loadServicio(){
		listServicio = servicioDAO.listadoServicio("Cuenca", "Docencia");
		
	}
}
