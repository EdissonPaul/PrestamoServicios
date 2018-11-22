package physeter.ventaservicios.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAI_ID")
	private int id;
	
	@Column(name = "PAI_NOMBRE")
	private String nombre;
	
	@OneToMany(mappedBy="pais",cascade=CascadeType.ALL)
	private List<Provincia> provincia;
	
}
