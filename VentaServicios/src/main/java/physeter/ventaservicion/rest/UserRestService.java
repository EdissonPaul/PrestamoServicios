package physeter.ventaservicion.rest;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


import physeter.ventaservicios.DAO.PersonaDAO;
import physeter.ventaservicios.modelo.Persona;

@Path("/user")
@RequestScoped
public class UserRestService {
	
	@Inject
	private PersonaDAO personaDao;
	
	/*
	 * WS para registrar una cuenta 
	 */
	@POST
	@Path("/register")
	@Produces("application/json")
	@Consumes("application/json")
	public boolean register(Persona user) {
		Response.ResponseBuilder builder = null;
		//Response rs= new Response();
		
		try {
			
			// Validates member using bean validation
					//	System.out.println(user.getPassword().toString());
						//user.setPassword(new Sha256Hash(user.getPassword()).toHex());
						System.out.println(user.toString());
					//	validateUser(user);
			personaDao.guardar(user);
			
			return true;
				
		}catch (ConstraintViolationException ce) {
            // Handle bean validation issues
			return false;
            //builder = createViolationResponse(ce.getConstraintViolations());
        } catch (ValidationException e) {
            // Handle the unique constrain violation
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("email", "Este email ya se encuentra en uso");
            builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
            return false;
        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<>();
            return false;
            //responseObj.put("error", e.getMessage());
            //builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
	}

}
