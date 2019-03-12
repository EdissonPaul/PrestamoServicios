package physeter.ventaservicios.DAO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import physeter.ventaservicios.modelo.Ciudad;

@Stateless
public class CiudadDao {

	@Inject
	private EntityManager em;
	
	
	public Ciudad getCiudad(int id){
		return em.find(Ciudad.class, id);
	}
}
