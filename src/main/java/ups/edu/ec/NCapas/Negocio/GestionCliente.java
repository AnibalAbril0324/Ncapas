package ups.edu.ec.NCapas.Negocio;


import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import ups.edu.ec.NCapas.Datos.DAOPersona;
import ups.edu.ec.NCapas.Modelo.Persona;



@Stateless
public class GestionCliente {
	
	@Inject 
	private DAOPersona daopersona;

	public void guardarCliente(Persona persona) throws Exception {
		if (!this.validarCedula(persona.getCedula()))
				throw new Exception("Cedula incorrecta");
		
		if(daopersona.read(persona.getCedula())==null) {
			try {
				daopersona.insertar(persona);
			} catch (Exception e) {
				
				throw new Exception("error la guardar"+e.getMessage());
			}
		}
		else {
		
			try {
				daopersona.update(persona);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	private boolean validarCedula(String cedula) {
		
		return cedula.length()==10;
		
	}
	public void eliminar(String cedula){
		daopersona.delete(cedula);
	}
	public void guardarCliente(String cedula, String nombre, String direccion) {
		
	}
	
	public List<Persona>listadopersonas() {
		List<Persona>personas=daopersona.getAll();
		return personas;
	}
	
}
