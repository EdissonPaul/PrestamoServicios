package physeter.ventaservicios.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import physeter.ventaservicios.modelo.Categorias;



@Stateless
public class CategoriaDao {
	
	@Inject
	private EntityManager em;
	
	/*
	 * metodo de guardar o actualizar nuevo categoria
	 */
	public void save( Categorias cat){
		System.out.println("Categoria "+cat.getId());
		if(em.find(Categorias.class, cat.getId())==null)
			insertar(cat);
		else
			actualizar(cat);
	}
	
	/*
	 * metodo de insertar nuevo categoria
	 */
	public void insertar(Categorias categoria) {	
		em.persist(categoria);
	}
	
	/*
	 * metodo de actualizar  categoria
	 */
	public void actualizar(Categorias categoria) {
		em.merge(categoria);
	}

	/*
	 * metodo de eliminar  categoria
	 */
	public void eliminar(int codigo) {
		em.remove(leer(codigo));
	}
	
	/*
	 * metodo de buscar categoria
	 */
	public Categorias leer(int codigo) {
		Categorias c=em.find(Categorias.class, codigo);
		return c;
	}
	
	/*
	 * metodo de leer todas las categorias
	 */
	public List<Categorias> listadoCategoria(){
		String jpql = "Select p From Categorias p";// p es un alias
		Query query = em.createQuery(jpql,Categorias.class);
		List<Categorias> listado = query.getResultList();
		
		
		System.out.println(listado.size());
		return listado;
		
	}
	
	public List<Categorias> getCategorias2(){
		String jpql = "SELECT distinct c FROM Categorias c";
		Query query = em.createQuery(jpql, Categorias.class);
		List<Categorias> categorias = query.getResultList();
		return categorias;
	}
	

	public Categorias read(int id){
		Categorias categoria = em.find(Categorias.class, id);
		categoria.getServicio().size();
		return categoria;
	}
	

}
