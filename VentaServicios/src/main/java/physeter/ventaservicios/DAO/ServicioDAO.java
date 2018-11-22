package physeter.ventaservicios.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


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
	
	public List<Servicio> listServicio(){
		String jpql = "Select p.* From Servicio p";
		Query query = em.createNativeQuery(jpql,Servicio.class);
		List<Servicio> listado = query.getResultList();
		System.out.println(listado.size());
		return listado;
	}
	
	public List<Servicio> getServicio(int id){
		String jpql = "Select p From Servicio p where p.id LIKE :id_servicio";
		Query query = em.createNativeQuery(jpql,Servicio.class);
		query.setParameter("id_servicio", id);
		List<Servicio> listado = query.getResultList();
		System.out.println(listado.size());
		return listado;
	}
}
