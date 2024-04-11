package it.prova.menupizzeria.service;

import java.util.List;

import it.prova.menupizzeria.dao.EntityManagerUtil;
import it.prova.menupizzeria.dao.IngredienteDAO;
import it.prova.menupizzeria.dao.PizzaDAO;
import it.prova.menupizzeria.model.Ingrediente;
import jakarta.persistence.EntityManager;

public class IngredienteServiceImpl implements IngredienteService  {
	
	private IngredienteDAO ingredienteDAO;

	@Override
	public List<Ingrediente> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			ingredienteDAO.setEntityManager(entityManager);
			
			return ingredienteDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}


	@Override
	public Ingrediente listElemento(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			ingredienteDAO.setEntityManager(entityManager);
			
			return ingredienteDAO.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	

	@Override
	public void inserisciElemento(Ingrediente ingredienteInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			ingredienteDAO.setEntityManager(entityManager);
			
			ingredienteDAO.insert(ingredienteInstance);
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
	public void rimuovi(Ingrediente ingredienteInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			ingredienteDAO.setEntityManager(entityManager);
			
			ingredienteDAO.delete(ingredienteInstance);
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
	public void setIngredienteDAO(IngredienteDAO ingredienteInstance) throws Exception {
		this.ingredienteDAO = ingredienteInstance; 
	}


	@Override
	public void aggiorna(Ingrediente ingredienteInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			ingredienteDAO.setEntityManager(entityManager);
			
			ingredienteDAO.update(ingredienteInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}


	

}
