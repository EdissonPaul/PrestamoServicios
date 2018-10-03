package physeter.ventaservicios.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
}
