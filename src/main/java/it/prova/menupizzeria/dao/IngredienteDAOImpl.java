package it.prova.menupizzeria.dao;

import java.util.List;

import it.prova.menupizzeria.model.Ingrediente;
import jakarta.persistence.EntityManager;

public class IngredienteDAOImpl implements IngredienteDAO{
	
	private EntityManager entityManager;
	
	

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	@Override
	public List<Ingrediente> list() throws Exception {
		return entityManager.createQuery("from ingrediente",Ingrediente.class).getResultList();
	}

	@Override
	public Ingrediente get(Long id) throws Exception {
		return entityManager.find(Ingrediente.class, id);
	}

	@Override
	public void update(Ingrediente ingredienteInstance) throws Exception {
		if (ingredienteInstance == null) {
			throw new Exception("Impossibile eseguire l' update nel DB. Input non valido");
		} ingredienteInstance = entityManager.merge(ingredienteInstance);
		
	}

	@Override
	public void insert(Ingrediente ingredienteInstance) throws Exception {
		if (ingredienteInstance == null) {
			throw new Exception("Errore valore input");
		} 
		entityManager.persist(ingredienteInstance);
	}

	@Override
	public void delete(Ingrediente ingredienteInstance) throws Exception {
		if (ingredienteInstance == null) {
			throw new Exception("Impossibile eseguire la delete nel DB. Input non valido");
		} entityManager.remove(entityManager.merge(ingredienteInstance));
		
	
	}

	

}
