package it.prova.menupizzeria.dao;

import java.util.List;

import it.prova.menupizzeria.model.Ingrediente;
import it.prova.menupizzeria.model.Pizza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class IngredienteDAOImpl implements IngredienteDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Ingrediente> list() throws Exception {
		return entityManager.createQuery("from Ingrediente", Ingrediente.class).getResultList();
	}

	@Override
	public Ingrediente get(Long id) throws Exception {
		return entityManager.find(Ingrediente.class, id);
	}

	@Override
	public void update(Ingrediente ingredienteInstance) throws Exception {
		if (ingredienteInstance == null) {
			throw new Exception("Impossibile eseguire l' update nel DB. Input non valido");
		}
		ingredienteInstance = entityManager.merge(ingredienteInstance);

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
		}
		entityManager.remove(entityManager.merge(ingredienteInstance));

	}

	@Override
	public boolean exist(Ingrediente ingredienteInstance) throws Exception {
		Query query = entityManager.createQuery(
				"SELECT COUNT(i) FROM Ingrediente i WHERE i.nome = :nomeIngrediente  AND i.disponibile = :DisponibileIngrediente",
				Long.class);
		query.setParameter("nomeIngrediente", ingredienteInstance.getNome());
		query.setParameter("customIngrediente", ingredienteInstance.isDisponibile());
		Long result = (Long) query.getSingleResult();
		if (result > Long.valueOf(0)) {
			return true;
		}
		return false;

	}
}
