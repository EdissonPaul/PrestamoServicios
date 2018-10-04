package physeter.ventaservicios.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ciudad implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CIU_ID")
	private int id;
	
	@Column(name = "CIU_NOMBRE")
	private String nombre;
	
	@OneToMany(mappedBy="ciudad",cascade=CascadeType.ALL)
	private Set<Servicio> servicio;
}
