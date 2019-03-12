package physeter.ventaservicios.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import physeter.ventaservicios.modelo.Persona;
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
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Profesion getProfesion(int id){
		Profesion aux = em.find(Profesion.class,id);
		
		try {
			return aux;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public List<Profesion> getProfesiones(){
		String jpql = "Select p From Profesion p";
		Query q = em.createQuery(jpql,Profesion.class);
		List<Profesion> listProfesion = q.getResultList();
		for(Profesion pro:listProfesion){
			for(Profesion per:pro.getPersona().getProfesion()){
//				System.out.println(per.getPersona().getApellido());
			}
			
		}
		return listProfesion;
	}
	
	
}
