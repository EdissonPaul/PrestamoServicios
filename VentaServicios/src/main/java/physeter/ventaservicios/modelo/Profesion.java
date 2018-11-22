package physeter.ventaservicios.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Profesion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROF_ID")
	private int id;
	
	@Column(name = "PROF_TITULO")
	private String titulo;
	
	@Column(name = "PROF_CODIGO_TITULO")
	private String codigoTitulo;
	
	@Column(name = "PROF_PROFESION")
	private String profesion;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="PER_ID")
	private Persona persona;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getCodigoTitulo() {
		return codigoTitulo;
	}


	public void setCodigoTitulo(String codigoTitulo) {
		this.codigoTitulo = codigoTitulo;
	}


	public String getProfesion() {
		return profesion;
	}


	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
