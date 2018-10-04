package physeter.ventaservicios.controller;

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
	
	
	public String logeoPersona(){
	
		return null;
	}

}
