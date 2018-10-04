package physeter.ventaservicios.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Profesion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROF_ID")
	private int id;
	
	@Column(name = "PROF_TITULO")
	private String titulo;
	
	@Column(name = "PROF_CODIGO_TITULO")
	private String codigoTitulo;
	
	
	@ManyToOne
	@JoinColumn(name ="PER_ID")
	private Persona persona;
	
	
}
