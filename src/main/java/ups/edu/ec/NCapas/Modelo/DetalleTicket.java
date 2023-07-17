package ups.edu.ec.NCapas.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class DetalleTicket {
	@Id
	@GeneratedValue
	@Column(name="det_codigo")
	private int codigo;
	
	@Column(name="veh_hentrada")
	private String hentrada;
	
	@Column(name="veh_shsalida")
	private String hsalida;
	
	@OneToOne
	@JoinColumn(name="est_codigo")
	private Estacionamiento estacionamiento;
	
	@OneToOne
	@JoinColumn(name="veh_codigo")
	private Vehiculo vehiculo;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getHentrada() {
		return hentrada;
	}

	public void setHentrada(String hentrada) {
		this.hentrada = hentrada;
	}

	public String getHsalida() {
		return hsalida;
	}

	public void setHsalida(String hsalida) {
		this.hsalida = hsalida;
	}

	
	public Estacionamiento getEstacionamiento() {
		return estacionamiento;
	}

	public void setEstacionamiento(Estacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	@Override
	public String toString() {
		return "DetalleTicket [codigo=" + codigo + ", hentrada=" + hentrada + ", hsalida=" + hsalida
				+ ", estacionamiento=" + estacionamiento + ", vehiculo=" + vehiculo + "]";
	}
	
	
}
