package physeter.ventaservicion.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


import physeter.ventaservicios.DAO.PersonaDAO;
import physeter.ventaservicios.modelo.Persona;

@Path("/personas")
public class PersonaWSRest {
	
	@Inject
	PersonaDAO personaDao;
	
	
	@GET
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public Persona loginResponse(@QueryParam("email") String email, @QueryParam("password") String password){
		
		
		try{
			System.out.println(email +"   "+password);
			Persona persona = personaDao.buscarPersona(email, password);
			
			if(persona!=null){
				System.out.println("usuario logeado");
				return persona;
			}else{
				System.out.println("usuario no logeado");
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
			
	}

}
