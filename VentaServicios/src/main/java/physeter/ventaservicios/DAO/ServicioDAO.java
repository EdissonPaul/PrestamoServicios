package physeter.ventaservicios.DAO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import physeter.ventaservicios.modelo.Profesion;
import physeter.ventaservicios.modelo.Servicio;

@Stateless
public class ServicioDAO {
	
	@Inject
	private EntityManager em;
	

	/**
	 * 
	 * @param profesion
	 */
	public void guardar(Servicio servicio){
		if(em.find(Servicio.class, servicio.getId())==null)
			insertaraServicio(servicio);
		else
			actualizarSerivio(servicio);
	}
	
	/**
	 * 
	 * @param servicio
	 */
	public void insertaraServicio(Servicio servicio){
		em.persist(servicio);
	}
	
	/**
	 * 
	 * @param servicio
	 */
	public void actualizarSerivio(Servicio servicio){
		em.merge(servicio);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void borrarSerivicio(int id){
		Servicio servicio = em.find(Servicio.class, id);
		em.remove(servicio);
		
	}

}
