package ups.edu.ec.NCapas.Services;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Status;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.NCapas.Datos.DAOPersona;
import ups.edu.ec.NCapas.Modelo.Persona;
import ups.edu.ec.NCapas.Negocio.GestionCliente;

@Path("clientes")
public class GClienteService {
	
	@Inject
	private GestionCliente gestioncliente;
	
	@GET
	@Path("saludo")
	public String Saludo() {
		return "hola mundo 123";
	}

	@GET
	@Path("suma")
	public String suma(@QueryParam("a") int a ,@QueryParam("b") int b) {
		return "c= "+a + b ;
	}
	
	@GET
	@Path("multiplicacion/{a}/{b}")
	public String multiplicacion(@PathParam("a") int a,
			@PathParam("b") int b) {
		
		return " R = " + (a * b);
	}
	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Persona misdatos() {
		Persona p= new Persona();
		p.setCedula("0123456789");
		p.setNombre("anibal abril");
		return p;
	}
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Persona persona) {
		try {
			gestioncliente.guardarCliente(persona);
			return Response.status(Response.Status.OK).entity(persona).build();
		} catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setError(99);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}

	@GET
	@Path("eliminar")
	public String elimiminar(@QueryParam("cedula")String cedula) {
		gestioncliente.eliminar(cedula);
		return "se elimino";
	}
	
	@GET
	@Path("listado")
	@Produces("application/json")
	public List<Persona>listadopersonas() {
		List<Persona>personas=gestioncliente.listadopersonas();
		return personas;
	}
	
	@GET
	@Path("all")
	@Produces("application/json")
	public Response getClientes() {
		List<Persona> listado = gestioncliente.listadopersonas();

		return Response.status(Response.Status.OK).entity(listado).build();
	}
}