package physeter.ventaservicios.controller;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import physeter.ventaservicios.DAO.LoginDAO;
import physeter.ventaservicios.DAO.PersonaDAO;
import physeter.ventaservicios.modelo.Persona;

@ManagedBean
public class PersonaController {

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
		
		
		//validamos correo de la persona
		String idUsuario = persona.getCorreo();
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
