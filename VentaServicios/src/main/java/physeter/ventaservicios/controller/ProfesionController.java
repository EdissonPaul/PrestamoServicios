package physeter.ventaservicios.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Init;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import physeter.ventaservicios.DAO.ProfesionDAO;
import physeter.ventaservicios.DAO.ServicioDAO;
import physeter.ventaservicios.modelo.Persona;
import physeter.ventaservicios.modelo.Profesion;
import physeter.ventaservicios.modelo.Servicio;

@ManagedBean
public class ProfesionController implements Serializable{

	@Inject
	private Persona persona;
	
	@Inject
	private Profesion profesion;
	
	@Inject
	private Servicio servicio;
	
	@Inject
	private SesionRegistroController sesionRegistroController;
	
	private String errUsuario;
	
	@Inject
	private ProfesionDAO profesionDAO;
	
	@Inject
	private ServicioDAO servicioDAO;
	
	private Date date2;
	
	private String anos;
	
	SimpleDateFormat formateador ;
	
	private SelectItem[] opciones = new SelectItem[]{new SelectItem("01", "Enero"),
	        new SelectItem("02", "Febrero"),
	        new SelectItem("03", "Marzo"),
	        new SelectItem("04", "Abril"),
	        new SelectItem("05", "Mayo"),
	        new SelectItem("06", "Junio"),
	        new SelectItem("07", "Julio"),
	        new SelectItem("08", "Agosto"),
	        new SelectItem("09", "Septiembre"),
	        new SelectItem("10", "Octubre"),
	        new SelectItem("11", "Noviembre"),
	        new SelectItem("12", "Diciembre")};
	
	
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
	
	

	public SelectItem[] getOpciones() {
		return opciones;
	}

	public void setOpciones(SelectItem[] opciones) {
		this.opciones = opciones;
	}

	@Init
	public void init(){
		profesion =new Profesion();
		servicio = new Servicio();
		persona = new Persona();
		persona.getProfesion().add(profesion);
	}
	
	/**
	 * Metodo para validar datos de profesion
	 * @return
	 */
	public String validarDatosRegistro(){
	
		errUsuario = "";
		String fecha ="";
		
		/*
		
		StringBuilder result = new StringBuilder();
		Calendar c = new GregorianCalendar();
		c.setTime(date2);
		Calendar fn= c;
		Calendar fechaActual = Calendar.getInstance();
		
		int diferenciaAños = fechaActual.get(Calendar.YEAR) -fn.get(Calendar.YEAR);
		int diferenciaMeses = fechaActual.get(Calendar.MONTH) -fn.get(Calendar.MONTH);
		int diferenciaDias = fechaActual.get(Calendar.DAY_OF_MONTH) -fn.get(Calendar.DAY_OF_MONTH);
		
		
		if(diferenciaMeses <0 || (diferenciaMeses == 0 && diferenciaDias <0)){
			diferenciaAños = diferenciaAños - 1;
		}
		System.out.println(diferenciaAños);
		*/
		
		/**
		
		fecha = formateador.format(date2);
		
		LocalDate ahora = LocalDate.now();
		String fechaActual = ahora+"";
		System.out.println(fechaActual);
	
		
		System.out.println(fecha);
		*/
		if(errUsuario.equals("")){
			
			System.out.println(personaController.getPersona().getCorreo());
			System.out.println(servicio.getDescripcion());
			profesion.setPersona(personaController.getPersona());
			servicio.setPersona(personaController.getPersona());
			personaController.registrarPersona();
			profesionDAO.insertaraProfesion(profesion);
			servicioDAO.insertaraServicio(servicio);
			init();
		}
		
		return null;
	}
}
