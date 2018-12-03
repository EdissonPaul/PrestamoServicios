package physeter.ventaservicios.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;



import physeter.ventaservicios.modelo.Revision;
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

	
	public List<Servicio> listadoServicio(String ciu, String cat){
		String jpql = "Select p.* From Servicio p";
		Query query = em.createNativeQuery(jpql,Servicio.class);
		List<Servicio> listado = query.getResultList();
		System.out.println(listado.size());
		return listado;
	}
	
	public Servicio leer(int id){
		Servicio s = em.find(Servicio.class, id);
		s.getCategoria();
		s.getCiudad();
		return s;
	}
	
	public List<Revision> leer2(int ids) {
		String jpql = "Select r From Revision r, Servicio s where s.id = r.servicio and s.id = :ids";
				Query query = em.createQuery(jpql,Revision.class);

				query.setParameter("ids", ids);
				List<Revision> listado =query.getResultList();
				System.out.println(listado.size());
				return listado;
	}
	
	public List<Servicio> listServicio(){
		
		
		String jpql = "Select p.* From Servicio p";
		Query query = em.createNativeQuery(jpql,Servicio.class);
		List<Servicio> listado = query.getResultList();
		System.out.println(listado.size());
		return listado;
	}
	
	public List<Servicio> getServicio(int id){
		
		
		Query query = em.createQuery("SELECT a FROM Servicio a WHERE id = :id",Servicio.class);
		
		query.setParameter("id", id);
		
		
		List<Servicio> p=  query.getResultList();
		
		
		return p;
	}
	
	
	
}
