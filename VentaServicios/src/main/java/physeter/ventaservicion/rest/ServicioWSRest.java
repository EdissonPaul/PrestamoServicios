package physeter.ventaservicion.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import physeter.ventaservicios.DAO.CategoriaDao;
import physeter.ventaservicios.DAO.CiudadDao;
import physeter.ventaservicios.DAO.PersonaDAO;
import physeter.ventaservicios.DAO.ServicioDAO;
import physeter.ventaservicios.modelo.Categorias;
import physeter.ventaservicios.modelo.Ciudad;
import physeter.ventaservicios.modelo.Persona;
import physeter.ventaservicios.modelo.Servicio;

@Path("/servicios")
public class ServicioWSRest {
	
	
	@Inject
	private ServicioDAO servicioDao;
	
	@Inject
	private PersonaDAO personaDao;
	
	@Inject
	private CategoriaDao categoriaDao;
	
	@Inject
	private CiudadDao ciudadDao;
	
	@Inject
	private Servicio servicio;
	
	
	/**
	 * Obtenemos todos los servicios
	 * @return
	 */
	@GET
	@Path("/listarservicios")
	@Produces("application/json")
	@Consumes("application/json")
	public List<Servicio> getServicios(){
		return servicioDao.listadoServicio();
	}
	
	/**
	 * registramos el servicio
	 * @param descripcion
	 * @param direccion
	 * @param experiencia
	 * @param habilidades
	 * @param telefono
	 * @param idCategoria
	 * @param idCiudad
	 * @param idPersona
	 * @return
	 */
	@POST
	@Path("/registroServicio")
	@Produces("application/json")
	@Consumes("application/json")
	public boolean registrarServicio(@QueryParam("descripcion") String descripcion,@QueryParam("direccion") String direccion,
									@QueryParam("experiencia") String experiencia,@QueryParam("habilidades") String habilidades,
									@QueryParam("telefono") String telefono,@QueryParam("id_categoria") int idCategoria,
									@QueryParam("id_ciudad") int idCiudad,@QueryParam("id_persona") int idPersona){
		
		boolean insert = false;
		
		servicio.setDescripcion(descripcion);
		servicio.setDireccion(direccion);
		servicio.setExperiencia(experiencia);
		servicio.setHablidades(habilidades);
		servicio.setTelefono(telefono);
		
		Persona persona = personaDao.leer(idPersona);
		Categorias categoria = categoriaDao.leer(idCategoria);
		Ciudad ciudad = ciudadDao.getCiudad(idCiudad);
		
		servicio.setCategoria(categoria);
		servicio.setCiudad(ciudad);
		servicio.setPersona(persona);
		
		try {
			servicioDao.guardar(servicio);
			insert = true;
		} catch (Exception e) {
			// TODO: handle exception
			insert = false;
		}
		
		
		
		return insert;
	}

}
