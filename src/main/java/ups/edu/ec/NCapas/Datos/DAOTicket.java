package ups.edu.ec.NCapas.Datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.NCapas.Modelo.Ticket;

@Stateless
public class DAOTicket implements Serializable{

	@PersistenceContext
	private EntityManager em;
	
	public void insertar(Ticket ticket){
		em.persist(ticket);
	}
	
	public void update(Ticket ticket) {
		
	em.merge(ticket);
	}
	
	public Ticket read(int codigo) {
		Ticket c = em.find(Ticket.class, codigo);
		return c;
	}
	
	public void delete (int codigo) {
		Ticket c = em.find(Ticket.class, codigo);
		em.remove(c);
	}
	
	public List<Ticket> getAll(){
		
		String jpql="SELECT t From Ticket t";
		Query q=em.createQuery(jpql);
		return q.getResultList();
	}	
}
