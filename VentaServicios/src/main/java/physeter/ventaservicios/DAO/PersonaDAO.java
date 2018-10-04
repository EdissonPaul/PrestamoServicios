package physeter.ventaservicios.DAO;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import physeter.ventaservicios.modelo.Persona;

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

}
