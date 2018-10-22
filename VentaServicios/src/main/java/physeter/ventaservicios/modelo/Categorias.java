package physeter.ventaservicios.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorias implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAT_ID")
	private int id;
	
	@Column(name = "CAT_NOMBRE")
	private String nombre;
	
	@Column(name = "CAT_VISIBLE")
	private boolean visible;
	
	@OneToMany(mappedBy="categoria",cascade=CascadeType.ALL)
	private List<Servicio> servicio;

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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
