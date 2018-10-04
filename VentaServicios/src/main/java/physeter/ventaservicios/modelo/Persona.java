package physeter.ventaservicios.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PER_ID")
	private int id;
	
	@Column(name = "PER_NOMBRE")
	private String nombre;

	@Column(name = "PER_CEDULA")
	private String cedula;
	
	@Column(name = "PER_FOTO")
	private String foto;
	
	@Column(name = "PER_TELEFONO")
	private String telefono;
	
	@Column(name = "PER_CORREO")
	private String correo;
	
	@Column(name = "PER_CONTRASEÑA")
	private String contraseña;
	
	@OneToMany(mappedBy="persona",cascade=CascadeType.ALL)
	private Set<Profesion> profesion;
	
	@OneToMany(mappedBy="persona",cascade=CascadeType.ALL)
	private Set<Servicio> servicio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Set<Profesion> getProfesion() {
		return profesion;
	}

	public void setProfesion(Set<Profesion> profesion) {
		this.profesion = profesion;
	}

	public Set<Servicio> getServicio() {
		return servicio;
	}

	public void setServicio(Set<Servicio> servicio) {
		this.servicio = servicio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
