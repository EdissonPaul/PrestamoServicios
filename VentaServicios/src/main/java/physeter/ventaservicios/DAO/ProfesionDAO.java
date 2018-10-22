package physeter.ventaservicios.DAO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import physeter.ventaservicios.modelo.Profesion;

@Stateless
public class ProfesionDAO {

	@Inject
	private EntityManager em;
	
	/**
	 * 
	 * @param profesion
	 */
	public void guardar(Profesion profesion){
		if(em.find(Profesion.class, profesion.getId())==null)
			insertaraProfesion(profesion);
		else
			actualizarProfesion(profesion);
	}
	
	/**
	 * 
	 * @param profesion
	 */
	public void insertaraProfesion(Profesion profesion){
		em.persist(profesion);
	}
	
	/**
	 * 
	 * @param profesion
	 */
	public void actualizarProfesion(Profesion profesion){
		em.merge(profesion);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void borrarProfesion(int id){
		Profesion profesion = em.find(Profesion.class, id);
		em.remove(profesion);
		
	}
}
