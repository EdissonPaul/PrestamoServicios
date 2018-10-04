package physeter.ventaservicios.DAO;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import physeter.ventaservicios.modelo.Persona;

public class LoginDAO {
	
	@Inject
	private EntityManager em;
	
	public Persona verificarPersonaCorreo(String correo){
		
		try{
			String sql = "SELECT log FROM Persona log " +
					"WHERE log.correo LIKE :mi_usuario";
			Query q = em.createQuery(sql, Persona.class);
			q.setParameter("mi_usuario", correo);
			return (Persona)q.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
