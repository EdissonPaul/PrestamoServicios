package physeter.ventaservicios.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;

import physeter.ventaservicios.DAO.LoginDAO;
import physeter.ventaservicios.DAO.PersonaDAO;
import physeter.ventaservicios.modelo.Persona;
import physeter.ventaservicios.modelo.Profesion;

@ManagedBean(name="personaController")
@SessionScoped
public class PersonaController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Persona persona;
	
	@Inject
	private Profesion Profesion;
	
	@Inject
	private SesionRegistroController sesionRegistroController;
	
	@ManagedProperty("#{sesionController}")
	private SesionController sesionController;
	
	@Inject
	private PersonaDAO personaDAO;
	
	@Inject
	private LoginDAO loginDAO;
	
	
	private String errCorreo;
	private String errCedula;
	private String contraseñaInsertada;
	private String errClave;
	private String errorMsg;
	
	
	
	private Part file;
	
	public Profesion getProfesion() {
		return Profesion;
	}

	public void setProfesion(Profesion profesion) {
		Profesion = profesion;
	}

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
	
	public SesionRegistroController getSesionRegistroController() {
		return sesionRegistroController;
	}

	public void setSesionRegistroController(SesionRegistroController sesionRegistroController) {
		this.sesionRegistroController = sesionRegistroController;
	}
	
	
	
	

	public SesionController getSesionController() {
		return sesionController;
	}

	public void setSesionController(SesionController sesionController) {
		this.sesionController = sesionController;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	@PostConstruct
	public void init(){
		persona = new Persona();
		
	}

	/**
	 * Validar Datos de Registri Correo y Contraseña
	 * @return
	 */
	public String validarDatosRegistro(){
		
		errCorreo = "";
		errClave = "";
		errCedula="";
		
		//validamos correo de la persona
		String idUsuario = persona.getCorreo();
		Persona comprobar = (Persona)loginDAO.verificarPersonaCorreo(idUsuario);
		if(comprobar!=null){
			errCorreo = "Error, usuario ya registrado.";
			errorMsg="Error,usuario ya registrado";
			System.out.println(errorMsg);
		}
		
		//validamos la contraseña
		String idContraseña = persona.getContrasena();
		if(!idContraseña.equals(contraseñaInsertada)&&idContraseña.length()>0&&contraseñaInsertada.length()>0){
			errClave = "Contraseñas no coinciden";
			errorMsg="Contraseñas no coinciden.";
			System.out.println(errClave);
		}
		
		// validamos cedula
		String idCedula = persona.getCedula();
		if(idCedula.length()!=10){
			errCedula = "Error, cantidad de digitos incorrectos en la cedula.";
			errorMsg="Error, cedula incorrecta.";
		}else{
			Persona personaCedula = personaDAO.verificarCedula(idCedula);
			if(personaCedula!=null){
				errorMsg="Error, cedula ya registrada.";
				errCedula="Error, cedula ya registrada.";
			}
			if(!validarCedula(idCedula)){
				errorMsg="Error, cedula incorrecta.";
				errCedula="Error, cedula incorrecta.";
			}
		}	
		if(errCorreo.equals("")&&errClave.equals("")&&errCedula.equals("")){
			//profesionController.validarDatosRegistro(persona);
			System.out.println(persona.getCorreo()+" .. uno");
			sesionRegistroController.setUser(persona);
			return "probar1";
			//String pagina = registrarPersona();
			//return pagina;
			//System.out.println("entro");
		}
		return null;
	}
	
	
	public String registrarPersona(){
		boolean res;
		
		res = personaDAO.insertarPersona(persona);
		if(res){
			System.out.println("Persona insertado");
			errorMsg="Registro exitoso";
			return "registrodatos";
		}else{
			System.out.println("Persona NO insertado");
		}
		return null;
	}
	
	
	public boolean validarCedula(String cedula) {
	    int suma=0;
	    if(cedula.length()==9){
	      System.out.println("Ingrese su cedula de 10 digitos");
	      return false;
	    }else{
	      int a[]=new int [cedula.length()/2];
	      int b[]=new int [(cedula.length()/2)];
	      int c=0;
	      int d=1;
	      for (int i = 0; i < cedula.length()/2; i++) {
	        a[i]=Integer.parseInt(String.valueOf(cedula.charAt(c)));
	        c=c+2;
	        if (i < (cedula.length()/2)-1) {
	          b[i]=Integer.parseInt(String.valueOf(cedula.charAt(d)));
	          d=d+2;
	        }
	      }
	    
	      for (int i = 0; i < a.length; i++) {
	        a[i]=a[i]*2;
	        if (a[i] >9){
	          a[i]=a[i]-9;
	        }
	        suma=suma+a[i]+b[i];
	      } 
	      int aux=suma/10;
	      int dec=(aux+1)*10;
	      if ((dec - suma) == Integer.parseInt(String.valueOf(cedula.charAt(cedula.length()-1))))
	        return true;
	      else
	        if(suma%10==0 && cedula.charAt(cedula.length()-1)=='0'){
	          return true;
	        }else{
	          return false;
	        }  
	    }
	    }
	
	public String actualizar(int id){
		persona = personaDAO.leer(id);
		System.out.println(persona.getCedula()+"   ....  ....");
		return "editarPersona";
	}
	
	public String editarPersona(){
		personaDAO.guardar(persona);
		sesionController.setPersona(persona);
		init();
		return null;
	}
	
	public String logout(){
		persona = null;
		return null;
	}
	
	public String cargarImagen() throws IOException{
		InputStream input;
		
		input = file.getInputStream();
		byte[] b = new byte[(int) file.getSize()];
		file.getInputStream().read(b);
		persona.setFoto(b);
		
		return null;
	}
}
