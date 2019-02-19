package physeter.ventaservicios.services;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import physeter.ventaservicios.DAO.ProfesionDAO;
import physeter.ventaservicios.DAO.RevisionDAO;
import physeter.ventaservicios.DAO.ServicioDAO;

@Path("/servicio")
public class Servicio {

	@Inject
	private ProfesionDAO profesionDAO;
	
	@Inject
	private ServicioDAO servicioDAO;
	
	@Inject
	private RevisionDAO revisionDAO;
	
	
}
