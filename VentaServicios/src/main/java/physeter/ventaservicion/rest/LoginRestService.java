package physeter.ventaservicion.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import physeter.ventaservicios.DAO.PersonaDAO;
import physeter.ventaservicios.modelo.Persona;



@Path("/authentication")
public class LoginRestService {

	@Inject
	private PersonaDAO personaDao;
	
	private Persona persona;
	
	
	/*
	 * 
	 * WS para el inicio de session
	 */
	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public Persona loginResponse(
			@QueryParam("email")String email, //parametros del login 
			@QueryParam("pass") String password){
		
		Persona persona = personaDao.buscarPersona(email, password);

		if(persona!=null){
			System.out.println("Autenticado: " + persona.toString());
			System.out.println("authentication");
			return persona;
		}else{
			return null;
		}
		
	}
}
