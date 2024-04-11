package it.prova.menupizzeria.service;

import java.util.List;

import it.prova.menupizzeria.dao.EntityManagerUtil;
import it.prova.menupizzeria.dao.IngredienteDAO;
import it.prova.menupizzeria.dao.PizzaDAO;
import it.prova.menupizzeria.model.Pizza;
import jakarta.persistence.EntityManager;

public class PizzaServiceImpl implements PizzaService{
	
	private IngredienteDAO ingredienteDAOInstance;
	private PizzaDAO pizzaDAOInstance;

	@Override
	public List<Pizza> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			pizzaDAOInstance.setEntityManager(entityManager);
			
			return 			pizzaDAOInstance.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Pizza listElemento(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			pizzaDAOInstance.setEntityManager(entityManager);
			
			return 			pizzaDAOInstance.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	
	@Override
	public void inserieciElemento(Pizza pizzaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			pizzaDAOInstance.setEntityManager(entityManager);
			
			pizzaDAOInstance.insert(pizzaInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}
	@Override
	public void rimuovi(Pizza pizzaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			pizzaDAOInstance.setEntityManager(entityManager);
			
			pizzaDAOInstance.delete(pizzaInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void aggiorna(Pizza pizzaInstance) throws Exception {
	EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			pizzaDAOInstance.setEntityManager(entityManager);
			
			pizzaDAOInstance.update(pizzaInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}
	@Override
	public void setPizzaDAO(PizzaDAO pizzaInstance) throws Exception {
		this.pizzaDAOInstance = pizzaInstance;
		
	}

	@Override
	public void setIngredienteDAO(IngredienteDAO ingredienteInstance) throws Exception {
		this.ingredienteDAOInstance = ingredienteInstance; 
	}



}