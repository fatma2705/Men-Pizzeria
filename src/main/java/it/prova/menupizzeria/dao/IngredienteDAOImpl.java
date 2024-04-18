package it.prova.menupizzeria.dao;

import java.util.List;

import it.prova.menupizzeria.model.Ingrediente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class IngredienteDAOImpl implements IngredienteDAO {

	EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Ingrediente> list() throws Exception {

		try {
			entityManager = EntityManagerUtil.getEntityManager();
			return entityManager.createQuery("from Ingrediente", Ingrediente.class).getResultList();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	@Override
	public Ingrediente get(Long id) throws Exception {
		try {
			entityManager = EntityManagerUtil.getEntityManager();
			return entityManager.find(Ingrediente.class, id);
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	@Override
	public void update(Ingrediente ingredienteInstance) throws Exception {
		try {
			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			if (ingredienteInstance == null) {
				throw new Exception("Impossibile eseguire l'update nel DB. Input non valido");
			}
			entityManager.merge(ingredienteInstance);
			entityManager.getTransaction().commit();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	@Override
	public void insert(Ingrediente ingredienteInstance) throws Exception {
		try {
			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			if (ingredienteInstance == null) {
				throw new Exception("Errore valore input");
			}
			entityManager.persist(ingredienteInstance);
			entityManager.getTransaction().commit();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	@Override
	public void delete(Ingrediente ingredienteInstance) throws Exception {
		try {
			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			if (ingredienteInstance == null) {
				throw new Exception("Impossibile eseguire la delete nel DB. Input non valido");
			}
			entityManager.remove(entityManager.merge(ingredienteInstance));
			entityManager.getTransaction().commit();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	@Override
	public boolean exist(Ingrediente ingredienteInstance) throws Exception {
		try {
			entityManager = EntityManagerUtil.getEntityManager();
			Query query = entityManager.createQuery(
					"SELECT COUNT(i) FROM Ingrediente i WHERE i.nome = :nomeIngrediente  AND i.disponibile = :DisponibileIngrediente",
					Long.class);
			query.setParameter("nomeIngrediente", ingredienteInstance.getNome());
			query.setParameter("customIngrediente", ingredienteInstance.isDisponibile());
			Long result = (Long) query.getSingleResult();
			return result > 0;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	@Override
	public Ingrediente getByNome(String nome) {
		try {
			entityManager = EntityManagerUtil.getEntityManager();
			return entityManager.createQuery("from Ingrediente i where i.nome = '" + nome + "'", Ingrediente.class)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

}
