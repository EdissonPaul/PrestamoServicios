package physeter.ventaservicios.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Servicio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SER_ID")
	private int id;
	
	@Column(name = "SER_DESCRIPCION")
	private String descripcion;
	
	@Column(name = "SER_EXPERIENCIA")
	private String experiencia;
	
	@Column(name = "SER_HABILIDADES")
	private String hablidades;
	
	@Column(name = "SER_TELEFONO")
	private String telefono;
	
	@Column(name = "SER_DIRECCION")
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name="PER_ID")
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name="CIU_ID")
	private Provincia ciudad;
	
	@ManyToOne
	@JoinColumn(name="CAT_ID")
	private Categorias categoria;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getHablidades() {
		return hablidades;
	}

	public void setHablidades(String hablidades) {
		this.hablidades = hablidades;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Provincia getCiudad() {
		return ciudad;
	}

	public void setCiudad(Provincia ciudad) {
		this.ciudad = ciudad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
