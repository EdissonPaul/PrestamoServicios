package physeter.ventaservicion.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import physeter.ventaservicios.DAO.PersonaDAO;
import physeter.ventaservicios.DAO.ProfesionDAO;
import physeter.ventaservicios.modelo.Persona;
import physeter.ventaservicios.modelo.Profesion;

@Path("/Profesion")
public class ProfesionWSRest {
	
	@Inject
	private ProfesionDAO profesionDAO;
	
	@Inject
	private PersonaDAO personaDAO;
	
	@Inject
	private Profesion profesion; 
	
	/**
	 * Obtenemos las profesiones
	 * @return
	 */
	
	@GET
	@Path("/getProfesiones")
	@Produces("application/json")
	@Consumes("application/json")
	public List<Profesion> getProfesiones(){	
		return profesionDAO.getProfesiones();
	}
	
	/**
	 * Registro de la profesion
	 * @param cod_titulo
	 * @param profesion
	 * @param titulo
	 * @param id
	 * @return
	 */
	
	@POST
	@Path("/registroProfesion")
	@Produces("application/json")
	@Consumes("application/json")
	public boolean registrarProfesion(@QueryParam("cod_titulo") String cod_titulo,@QueryParam("profesion") String profesion,
									@QueryParam("titulo") String titulo,@QueryParam("id_persona") int id){
		
		boolean insert = false;
		
		Persona persona = personaDAO.leer(id);
		
		this.profesion.setCodigoTitulo(cod_titulo);
		this.profesion.setProfesion(profesion);
		this.profesion.setTitulo(titulo);
		this.profesion.setPersona(persona);
		
		try {
			profesionDAO.guardar(this.profesion);
			insert = true;
		} catch (Exception e) {
			// TODO: handle exception
			insert = false;
		}
		
		return insert;
	}

}
