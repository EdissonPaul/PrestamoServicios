package physeter.ventaservicios.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Revision implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REV_ID")
	private int id;
	
	@Column(name = "REV_NOMBRE")
	private String nombre;
	
	@Column(name = "REV_CORREO")
	private String correo;
	
	@Column(name = "REV_COMENTARIO")
	private String comentario;
	
	@Column(name = "REV_ESTRELLAS")
	private int estrellas;
	
	@Column(name = "REV_FECHA")
	private Date fecha;
	
	@OneToMany(mappedBy="revision",cascade=CascadeType.ALL)
	private List<Servicio> servicio;
	
}
