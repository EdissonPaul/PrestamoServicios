package physeter.ventaservicios.DAO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import physeter.ventaservicios.modelo.Revision;

@Stateless
public class RevisionDAO {
	
	@Inject
	private EntityManager em;
	
	/*
	 * metodo de guardar o actualizar
	 */
	public void save(Revision revision){
		if(em.find(Revision.class, revision.getId())==null)
			insertar(revision);
		else
			actualizar(revision);
	}
	
	/*
	 * metodo de insertar nuevo 
	 */
	public void insertar(Revision revision){
		em.persist(revision);
	}
	
	/*
	 * metodo de actualizar  
	 */
	public void actualizar(Revision revision){
		em.merge(revision);
	}

	/*
	 * metodo de eliminar
	 */
	public void borrar(int id){
		Revision com = em.find(Revision.class, id);
		em.remove(com);
	}
}
