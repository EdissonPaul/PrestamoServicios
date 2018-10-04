package physeter.ventaservicios.controller;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import physeter.ventaservicios.DAO.LoginDAO;
import physeter.ventaservicios.DAO.PersonaDAO;
import physeter.ventaservicios.modelo.Persona;

@ManagedBean
public class PersonaController {

	@Inject
	private Persona persona;
	
	@Inject
	private PersonaDAO personaDAO;
	
	@Inject
	private LoginDAO loginDAO;
	
	private String errCorreo;
	private String errCedula;
	private String contraseñaInsertada;
	private String errClave;
	private String errorMsg;
	
	
	
	public String getContraseñaInsertada() {
		return contraseñaInsertada;
	}

	public void setContraseñaInsertada(String contraseñaInsertada) {
		this.contraseñaInsertada = contraseñaInsertada;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public String validarDatosRegistro(){
		
		errCorreo = "";
		errCedula ="";
		errClave = "";
		System.out.println("entro");
		//System.out.println(persona.getCorreo());
		//System.out.println(persona.getContraseña());
		
		
		//validamos correo de la persona
		String idUsuario = persona.getCorreo();
		System.out.println(idUsuario);
		Persona comprobar = (Persona)loginDAO.verificarPersonaCorreo(idUsuario);
		if(comprobar!=null){
			errCorreo = "Error, usuario ya registrado.";
			errorMsg="Error,usuario ya registrado";
			System.out.println(errorMsg);
		}
		
		String idContraseña = persona.getContraseña();
		if(!idContraseña.equals(contraseñaInsertada)&&idContraseña.length()>0&&contraseñaInsertada.length()>0){
			errClave = "Contraseñas no coinciden";
			errorMsg="Contraseñas no coinciden.";
			System.out.println(errClave);
		}
		
		
		if(errCorreo.equals("")&&errClave.equals("")){
			System.out.println("entro");
			
		}
		
		return null;
	}
	
	public String registrarPersona(){
		boolean res;
		
		res = personaDAO.insertarPersona(persona);
		if(res){
			System.out.println("Persona insertado");
			errorMsg="Registro exitoso";
		}else{
			System.out.println("Persona NO insertado");
		}
		
		return null;
	}
}
