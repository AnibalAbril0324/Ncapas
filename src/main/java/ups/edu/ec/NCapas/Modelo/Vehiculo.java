/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.NCapas.Modelo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

/**
 *
 * @author ASUS
 */
@Entity
public class Vehiculo {
	
	@Id
	@GeneratedValue
	@Column(name="veh_codigo")
	private int codigo;
	
	@Column(name="veh_placa")
	private String placa;
	
	@Column(name="veh_color")
	private String color;
	
	@Column(name="veh_marca")
	private String marca;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "Vehiculo [codigo=" + codigo + ", placa=" + placa + ", color=" + color + ", marca=" + marca + "]";
	}
	
	
}
