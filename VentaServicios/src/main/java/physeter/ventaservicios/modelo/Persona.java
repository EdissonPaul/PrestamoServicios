package physeter.ventaservicios.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	
}
