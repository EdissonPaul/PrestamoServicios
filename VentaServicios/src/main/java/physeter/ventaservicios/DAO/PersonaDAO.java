package physeter.ventaservicios.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import physeter.ventaservicios.modelo.Persona;


@Stateless
public class PersonaDAO {
	
	@Inject
	EntityManager em;
	
	public boolean insertarPersona(Persona per){
		try{
			em.persist(per);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * metodo de guardar o actualizar nuevo Persona
	 */
	public void guardar (Persona persona) {
		
		Persona p =leer(persona.getId());
		
		if(p==null)
			insertar(persona);
		else
			actualizar(persona);
	}
	

	/*
	 * metodo de insertar nuevo Persona
	 */
	public void insertar(Persona persona) {
		em.persist(persona);
	}
	
	/*
	 * metodo de  actualizar nuevo Persona
	 */
	public void actualizar (Persona persona) {
		em.merge(persona);
	}
	
	/*
	 * metodo de buscar Persona
	 */
	public Persona leer (int codigo) {
		Persona p = em.find(Persona.class, codigo);
		return p;
	}
	
	
	
	/**
	 * Metodo para verificar si existe la cedula en la B.D
	 * @param cedula
	 * @return
	 */
	public Persona verificarCedula(String cedula){
		try{
			String sql = "SELECT ter FROM Persona ter " +
					"WHERE ter.cedula LIKE :mi_cedula";
			Query q = em.createQuery(sql, Persona.class);
			q.setParameter("mi_cedula", cedula);
			return (Persona) q.getSingleResult();
		}catch (Exception e) {
			//System.out.println("error cedula ya existe en la base");
			return null;
		}
		
	}
	
	/**
	 * Metodo para Login
	 * @param correo
	 * @param contraseña
	 * @return
	 */
	public Persona buscarPersona(String correo, String contrasena) {
		
		
		try {
			Query query = em.createQuery("SELECT a FROM Persona a WHERE correo = :correo AND contrasena = :contrasena",Persona.class);
			
			query.setParameter("correo", correo);
			query.setParameter("contrasena", contrasena);
			
			Persona p= (Persona)query.getSingleResult();
			
			if (p!= null){
				return  p;
			}
				
			return null;
		}
		catch (Exception e){
			
		}
		
		return null;
	}

}
