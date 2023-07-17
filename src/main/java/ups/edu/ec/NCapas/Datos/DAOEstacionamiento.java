package ups.edu.ec.NCapas.Datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.NCapas.Modelo.Estacionamiento;
import ups.edu.ec.NCapas.Modelo.Persona;



@Stateless
public class DAOEstacionamiento implements Serializable {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insertar(Estacionamiento estacionamiento){
		em.persist(estacionamiento);
	}
	
	public void update(Persona persona) {
		
		em.merge(persona);
		}
		
		public Estacionamiento read(int codigo) {
			Estacionamiento est = em.find(Estacionamiento.class, codigo);
			return est;
		}
		
		public void delete (int codigo) {
			Estacionamiento est = em.find(Estacionamiento.class, codigo);
			em.remove(est);
		}
		
		public List<Estacionamiento> getAll(){
			
			String jpql="SELECT e From Estacionamiento e";
			Query q=em.createQuery(jpql);
			return q.getResultList();
		}	
}
