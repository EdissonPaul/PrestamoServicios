package physeter.ventaservicion.rest;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


import physeter.ventaservicios.DAO.PersonaDAO;
import physeter.ventaservicios.modelo.Persona;

@Path("/personas")
public class PersonaWSRest {
	
	@Inject
	PersonaDAO personaDao;
	
	/**
	 * Login de usuario
	 * se obtiene una lista con todos los parametros de la pesona
	 * @param email
	 * @param password
	 * @return
	 */
	
	
	@GET
	@Path("/logintest")
	@Produces("application/json")
	@Consumes("application/json")
	public List<Persona> loginPerson(@QueryParam("email") String email, @QueryParam("password") String password){
		try{
			List<Persona> persona = personaDao.getPersona(email, password);
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
	
	/**
	 * Registro de la entidad persona
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param contrasena
	 * @param telefono
	 * @param correo
	 * @param edad
	 * @param genero
	 * @return
	 */
	
	@POST
	@Path("/registroPersona")
	@Produces("application/json")
	@Consumes("application/json")
	public boolean registerPerson(@QueryParam("nombre") String nombre,@QueryParam("apellido") String apellido,
									@QueryParam("cedula") String cedula,@QueryParam("contrasena") String contrasena,
									@QueryParam("telefono") String telefono,@QueryParam("correo") String correo,
									@QueryParam("edad") Date edad,@QueryParam("genero") String genero){
		

		boolean insert = false;
		
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setCedula(cedula);
		persona.setTelefono(telefono);
		persona.setCorreo(correo);
		persona.setEdad(edad);
		persona.setGenero(genero);
		persona.setContrasena(contrasena);
		
		
		try {
			
			personaDao.insertar(persona);
			insert = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			insert = false;
		}
		return insert;
	}

}
