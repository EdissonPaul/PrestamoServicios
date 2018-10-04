package physeter.ventaservicios.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@OneToMany
	@JoinColumn(name="CIU_ID")
	private Set<Ciudad> ciudad;
	
}
