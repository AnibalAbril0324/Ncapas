package ups.edu.ec.NCapas.Modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Estacionamiento {

	@Id
	@GeneratedValue
	@Column(name="est_codigo")
	private int codigo;
	
	@Column(name="est_espacio")
	private String espacio;
	
	@Column(name="est_descipcion")
	private String descripcion;


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String isEspacio() {
		return espacio;
	}

	public void setEspacio(String espacio) {
		this.espacio = espacio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Estacionamiento [codigo=" + codigo + ", espacio=" + espacio + ", descripcion=" + descripcion + "]";
	}	
	
}
