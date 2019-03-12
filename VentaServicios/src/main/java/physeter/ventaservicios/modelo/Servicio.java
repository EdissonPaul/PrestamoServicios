package physeter.ventaservicios.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	@JoinColumn(name="PER_ID",nullable=false)
	private Persona persona;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CIU_ID")
	@JsonIgnore
	private Ciudad ciudad;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="CAT_ID")
	private Categorias categoria;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="servicio",cascade=CascadeType.ALL)
	private List<Revision> revision;

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

	
	

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Revision> getRevision() {
		return revision;
	}

	public void setRevision(List<Revision> revision) {
		this.revision = revision;
	}

	
	
	
}
