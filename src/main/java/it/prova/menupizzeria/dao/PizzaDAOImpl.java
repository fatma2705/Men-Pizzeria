package it.prova.menupizzeria.dao;

import java.util.List;

import it.prova.menupizzeria.model.Ingrediente;
import it.prova.menupizzeria.model.Pizza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class PizzaDAOImpl implements PizzaDAO {
	
	EntityManager entityManager;
	
	 @Override
	    public void setEntityManager(EntityManager entityManager) {
			this.entityManager = entityManager;
		}


    @Override
    public List<Pizza> list() throws Exception {
        try {
            entityManager = EntityManagerUtil.getEntityManager();
            return entityManager.createQuery("from Pizza", Pizza.class).getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public Pizza get(Long id) throws Exception {
        try {
            entityManager = EntityManagerUtil.getEntityManager();
            return entityManager.find(Pizza.class, id);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void update(Pizza pizzaInstance) throws Exception {
        try {
            entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            if (pizzaInstance == null) {
                throw new Exception("Impossibile eseguire l'update nel DB. Input non valido");
            }
            entityManager.merge(pizzaInstance);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void insert(Pizza pizzaInstance) throws Exception {
        try {
            entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            if (pizzaInstance == null) {
                throw new Exception("Errore valore input");
            }
            entityManager.persist(pizzaInstance);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void delete(Pizza pizzaInstance) throws Exception {
        try {
            entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            if (pizzaInstance == null) {
                throw new Exception("Impossibile eseguire la delete nel DB. Input non valido");
            }
            entityManager.remove(entityManager.merge(pizzaInstance));
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean exist(Pizza pizzaInstance) throws Exception {
        try {
            entityManager = EntityManagerUtil.getEntityManager();
            Query query = entityManager.createQuery(
                    "SELECT COUNT(p) FROM Pizza p WHERE p.nome = :nomePizza AND p.custom = :customPizza",
                    Long.class);
            query.setParameter("nomePizza", pizzaInstance.getNome());
            query.setParameter("customPizza", pizzaInstance.isCustom());
            Long result = (Long) query.getSingleResult();
            System.out.println("----------result " + result);
            return result > 0;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    @Override
   	public void insertIngrediente(Pizza pizza,Ingrediente ingrediente) throws Exception {
   		if (ingrediente == null) {
   			throw new Exception("Errore valore input");
   		}

   		Query query = entityManager.createNativeQuery(
   		    "INSERT INTO pizza_ingrediente (id_ingrediente, id_pizza) VALUES (:idIngrediente, :idPizza)");
   		query.setParameter("idIngrediente", ingrediente.getId());
   		query.setParameter("idPizza", pizza.getId());
   		int rowsUpdated = query.executeUpdate();
  

   	}

   
   
}
