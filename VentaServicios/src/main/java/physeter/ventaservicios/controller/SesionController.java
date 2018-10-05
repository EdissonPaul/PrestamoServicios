package physeter.ventaservicios.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import physeter.ventaservicios.DAO.PersonaDAO;
import physeter.ventaservicios.modelo.Persona;

@ManagedBean
@SessionScoped
public class SesionController {
	
	
	// Para la Persona
	private String usuario;
	private String contraseña;
	
	private Persona persona;
	
	@Inject
	private PersonaDAO personaDAO;
	
	private List<Persona> listPersonas;
	
	@PostConstruct
	public void init() {
		
		listPersonas = new ArrayList<Persona>();
		
	}
	
	
	public String logeoPersona(){
	
		return null;
	}

}
