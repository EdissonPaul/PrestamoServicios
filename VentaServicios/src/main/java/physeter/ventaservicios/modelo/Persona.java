package physeter.ventaservicios.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.New;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	
	@Column(name = "PER_APELLIDO")
	private String apellido;

	@Column(name = "PER_CEDULA")
	private String cedula;
	
	@Column(name = "PER_FOTO")
	@Lob
	private byte[] foto;
	
	@Column(name = "PER_TELEFONO")
	private String telefono;
	
	@Column(name = "PER_CORREO")
	private String correo;
	
	@Column(name = "PER_CONTRASENA")
	private String contrasena;
	
	@Column(name = "PER_EDAD")
	private Date edad;
	
	@Column(name = "PER_GENERO")
	private String genero;
	
	@OneToMany(mappedBy="persona",cascade=CascadeType.ALL)
	private List<Profesion> profesion = new ArrayList<Profesion>();
	
	@OneToMany(mappedBy="persona",cascade=CascadeType.ALL)
	private List<Servicio> servicio = new ArrayList<Servicio>();

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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
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

	

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public List<Profesion> getProfesion() {
		return profesion;
	}

	public void setProfesion(List<Profesion> profesion) {
		this.profesion = profesion;
	}

	public List<Servicio> getServicio() {
		return servicio;
	}

	public void setServicio(List<Servicio> servicio) {
		this.servicio = servicio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Date getEdad() {
		return edad;
	}

	public void setEdad(Date edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
}
