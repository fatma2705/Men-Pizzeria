package it.prova.menupizzeria.dao;

import java.util.List;



import it.prova.menupizzeria.model.Pizza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class PizzaDAOImpl implements PizzaDAO{
	
	
	
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	@Override
	public List<Pizza> list() throws Exception {
		return entityManager.createQuery("from Pizza", Pizza.class).getResultList();	}

	@Override
	public Pizza get(Long id) throws Exception {
		return entityManager.find(Pizza.class, id);
	}

	@Override
	public void update(Pizza pizzaInstance) throws Exception {
		if (pizzaInstance == null) {
			throw new Exception("Impossibile eseguire l' update nel DB. Input non valido");
		} pizzaInstance = entityManager.merge(pizzaInstance);
			
	}

	@Override
	public void insert(Pizza pizzaInstance) throws Exception {
		if (pizzaInstance == null) {
			throw new Exception("Errore valore input");
		} 
		entityManager.persist(pizzaInstance);
		
	}

	@Override
	public void delete(Pizza pizzaInstance) throws Exception {
		if (pizzaInstance == null) {
			throw new Exception("Impossibile eseguire la delete nel DB. Input non valido");
		} entityManager.remove(entityManager.merge(pizzaInstance));
		
	}


	@Override
	public boolean exist(Pizza pizzaInstance) throws Exception {
		Query query = entityManager.createQuery("SELECT COUNT(p) FROM Pizza p WHERE p.nome = :nomePizza AND p.prezzo = :prezzoPizza AND p.custom = :customPizza");
		query.setParameter("nomePizza", pizzaInstance.getNome());
		 query.setParameter("prezzoPizza", pizzaInstance.getPrezzo());
		 query.setParameter("customPizza", pizzaInstance.isCustom());
		 if  (query.getSingleResult() != null) {
			 return true;
		 }
		 return false;
		 
	}


	


}
