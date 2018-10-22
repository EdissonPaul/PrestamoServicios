package physeter.ventaservicios.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Provincia implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_ID")
	private int id;
	
	@Column(name = "PRO_NOMBRE")
	private String nombre;
	
	@OneToMany(mappedBy="ciudad",cascade=CascadeType.ALL)
	private Set<Servicio> servicio;
	
	@ManyToOne
	@JoinColumn(name="PAI_ID")
	private Pais pais;
}
