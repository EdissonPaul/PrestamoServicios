package physeter.ventaservicios.services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import physeter.ventaservicios.DAO.PersonaDAO;
import physeter.ventaservicios.modelo.Persona;

@Stateless
public class UserService {
	
	@Inject
	private PersonaDAO personaDAO;
	
	
	@PersistenceContext
	private EntityManager em;
	
	public Persona find (int id) {
		return em.find(Persona.class, id);
	}
	
	public void delete(Persona user) {
		em.remove(em.contains(user) ? user : em.merge(user));
	}
	
	public void update(Persona user) {
		em.merge(user);
	}

}
