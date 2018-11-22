package physeter.ventaservicios.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import physeter.ventaservicios.DAO.ServicioDAO;
import physeter.ventaservicios.modelo.Servicio;

@ManagedBean(name="serviciobean")
@RequestScoped
public class ServicioController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServicioDAO servicioDAO;
	
	private List<Servicio> servicioFiltrado;
	
	private List<Servicio> listServicio;
	
	public List<Servicio> getServicioFiltrado() {
		return servicioFiltrado;
	}

	public void setServicioFiltrado(List<Servicio> servicioFiltrado) {
		this.servicioFiltrado = servicioFiltrado;
	}

	public List<Servicio> getAllData(){
		return servicioDAO.listServicio();
	}
	
	public String obtenerInfoServicio(int idServicio){
		System.out.println(idServicio+" ..... ....... .......");
		listServicio = listServicio;
		return null;
	}
	
	

}
