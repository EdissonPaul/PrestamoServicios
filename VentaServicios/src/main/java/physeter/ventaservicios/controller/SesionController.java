package physeter.ventaservicios.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import physeter.ventaservicios.DAO.PersonaDAO;
import physeter.ventaservicios.modelo.Persona;

@ManagedBean
@SessionScoped
public class SesionController implements Serializable{
	
	
	// Para la Persona
	private String correo;
	private String contrasena;
	
	@Inject
	private Persona persona;
	
	@Inject
	private PersonaDAO personaDAO;
	
	private List<Persona> listPersonas;
	
	
	@PostConstruct
	public void init() {
		
		listPersonas = new ArrayList<Persona>();
		persona = new Persona();
		
	}	
	
	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String logeoPersona(){
		
		System.out.println(correo);
		System.out.println(contrasena);
		
		persona = personaDAO.buscarPersona(correo, contrasena);
		if(persona!=null){
			System.out.println("entro");
			return "perfilUsuario.jsf?faces-redirect=true";
			
		}
	
		return null;
	}

	public String cerrarSesion(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", "Sesión finalizada satisfactoriamente!!"));
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index.jsf?faces-redirect=true";
	}
}
