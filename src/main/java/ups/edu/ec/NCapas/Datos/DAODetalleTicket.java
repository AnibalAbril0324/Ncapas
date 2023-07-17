package ups.edu.ec.NCapas.Datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.NCapas.Modelo.DetalleTicket;
import ups.edu.ec.NCapas.Modelo.Persona;

@Stateless
public class DAODetalleTicket implements Serializable{

	@PersistenceContext
	private EntityManager em;
	
	public void insertar(DetalleTicket detalleticket){
		em.persist(detalleticket);
	}
	
	public void update(Persona persona) {
		
		em.merge(persona);
		}
		
		public DetalleTicket read(int codigo) {
			DetalleTicket est = em.find(DetalleTicket.class, codigo);
			return est;
		}
		
		public void delete (int codigo) {
			DetalleTicket est = em.find(DetalleTicket.class, codigo);
			em.remove(est);
		}
		
		public List<DetalleTicket> getAll(){
			
			String jpql="SELECT e From Estacionamiento e";
			Query q=em.createQuery(jpql);
			return q.getResultList();
		}	
}