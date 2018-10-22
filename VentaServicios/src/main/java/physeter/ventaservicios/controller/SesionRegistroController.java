package physeter.ventaservicios.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import physeter.ventaservicios.modelo.Persona;

@ManagedBean
@SessionScoped
public class SesionRegistroController implements Serializable {
	
	private Persona user;
	
	private List<Persona> listPersonas;

	public Persona getUser() {
		return user;
	}

	public void setUser(Persona user) {
		this.user = user;
	}

	public List<Persona> getListPersonas() {
		return listPersonas;
	}

	public void setListPersonas(List<Persona> listPersonas) {
		this.listPersonas = listPersonas;
	}
	
	

}
