package ups.edu.ec.NCapas.Negocio;

import java.util.Date;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.NCapas.Datos.DAODetalleTicket;
import ups.edu.ec.NCapas.Datos.DAOEstacionamiento;
import ups.edu.ec.NCapas.Datos.DAOPersona;
import ups.edu.ec.NCapas.Datos.DAOTicket;
import ups.edu.ec.NCapas.Datos.DAOVehiculo;
import ups.edu.ec.NCapas.Modelo.DetalleTicket;
import ups.edu.ec.NCapas.Modelo.Estacionamiento;
import ups.edu.ec.NCapas.Modelo.Persona;
import ups.edu.ec.NCapas.Modelo.Ticket;
import ups.edu.ec.NCapas.Modelo.Vehiculo;

@Startup
@Singleton
public class DatosDemo {

	@Inject
	private DAOPersona daopersona;
	
	@Inject
	private DAOVehiculo daovehiculo;
	
	@Inject
	private DAOEstacionamiento daoestacionamiento;
	
	@Inject
	private DAODetalleTicket daodetalleticket;
	
	@Inject
	private DAOTicket daoticket;
	
	@PostConstruct
	public void init()  {
		
		System.out.println("hola ups");
		
		Persona c= new Persona ();
		//c.setCodigo(1);
		c.setCedula("0105541510");
		c.setNombre("anibal abril");
		c.setDireccion("cuenca"); 
		daopersona.insertar(c);
		//daocliente.read("0105541510");
		
		Persona c1= new Persona ();
		//c.setCodigo(1);
		c1.setCedula("0123456789");
		c1.setNombre("Freddy Mercury");
		c1.setDireccion("baños"); 
		daopersona.insertar(c1);
		
		Persona c2= new Persona ();
		//c.setCodigo(1);
		c2.setCedula("9876543210");
		c2.setNombre("bob");
		c2.setDireccion("azuay"); 
		daopersona.insertar(c2);
		
		Persona c3= new Persona ();
		//c.setCodigo(1);
		c3.setCedula("9876543211");
		c3.setNombre("Silvia Loja");
		c3.setDireccion("San Roque"); 
		daopersona.insertar(c3);
		
		Vehiculo veh=new Vehiculo();
		veh.setColor("Rojo");
		veh.setMarca("Chevrolet");
		veh.setPlaca("AAA-123");
		daovehiculo.insertar(veh);
		
		Vehiculo veh1=new Vehiculo();
		veh1.setColor("Plomo");
		veh1.setMarca("Chevrolet");
		veh1.setPlaca("AAA-5677");
		daovehiculo.insertar(veh1);
		
		Vehiculo veh2=new Vehiculo();
		veh2.setColor("Negro");
		veh2.setMarca("Nissan");
		veh2.setPlaca("ABC-3444");
		daovehiculo.insertar(veh2);
		
		Vehiculo veh3=new Vehiculo();
		veh3.setColor("Blanco");
		veh3.setMarca("Hyundai");
		veh3.setPlaca("ACF-9878");
		daovehiculo.insertar(veh3);
		
		Estacionamiento est=new Estacionamiento();
		est.setEspacio("Vacio");
		est.setDescripcion("*******");
		daoestacionamiento.insertar(est);
		
		Estacionamiento est1=new Estacionamiento();
		est1.setEspacio("Vacio");
		est1.setDescripcion("Arrendado");
		daoestacionamiento.insertar(est1);
		
		Estacionamiento est2=new Estacionamiento();
		est2.setEspacio("Vacio");
		est2.setDescripcion("*******");
		daoestacionamiento.insertar(est2);
		
		Ticket tic =new Ticket();
		tic.setNumero("001-001-0001");
		tic.setFecha(new Date());
		tic.setCliente(c);
		
		DetalleTicket det= new DetalleTicket();
		det.setEstacionamiento(est2);
		det.setVehiculo(veh3);
		det.setHentrada("8:00");
		det.setHsalida("17:00");
		daodetalleticket.insertar(det);
		
		tic.addDetalle(det);
		daoticket.insertar(tic);
		
		//ticket numero 2
		
		Ticket tic1 =new Ticket();
		tic1.setNumero("002-002-0002");
		tic1.setFecha(new Date());
		tic1.setCliente(c1);
		
		DetalleTicket det1= new DetalleTicket();
		det1.setEstacionamiento(est1);
		det1.setVehiculo(veh2);
		det1.setHentrada("12:00");
		det1.setHsalida("17:00");
		daodetalleticket.insertar(det1);
		
		tic1.addDetalle(det1);
		daoticket.insertar(tic1);
		
		
		List<Vehiculo>vehiculos=daovehiculo.getAll();
		for(Vehiculo vehi:vehiculos) {
			System.out.println(vehi);
		}
		
		List<Estacionamiento>estacionamientos=daoestacionamiento.getAll();
		for(Estacionamiento esta:estacionamientos) {
			System.out.println(esta);
		}
		
		List<Ticket> tickets = daoticket.getAll();
		for(Ticket ti: tickets) {
			System.out.println("codigo: "+ti.getCodigo() + "ticket #: " + ti.getNumero() + "nombre cli " + ti.getCliente().getNombre() + 
					" detalles: " +" "+ti.getDetalles());
		}
		
	}
	
}
