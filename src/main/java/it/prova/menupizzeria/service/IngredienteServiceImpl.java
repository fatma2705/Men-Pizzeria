package it.prova.menupizzeria.service;

import java.util.List;

import it.prova.menupizzeria.dao.EntityManagerUtil;
import it.prova.menupizzeria.dao.IngredienteDAO;
import it.prova.menupizzeria.dao.PizzaDAO;
import it.prova.menupizzeria.model.Ingrediente;
import jakarta.persistence.EntityManager;

public class IngredienteServiceImpl implements IngredienteService {

	private IngredienteDAO ingredienteDAO;

	@Override
	public List<Ingrediente> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			ingredienteDAO.setEntityManager(entityManager);
			if (ingredienteDAO.list().isEmpty()) {
				System.out.println(" Database vuoto nulla da stampare ");
				System.exit(0);
			}

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
			if (id == null) {
				System.out.println("ID non inserito");
				System.exit(0);
			}
			ingredienteDAO.setEntityManager(entityManager);
			if (ingredienteDAO.get(id) == null) {
				System.out.println("Non esiste un' ingrediente con questo id ");
				System.exit(0);
			}

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
			if (ingredienteInstance.equals(null)) {
				System.out.println("ERRORE: Dati Ingredienti non inseriti");
				System.exit(0);
			}
			if (ingredienteInstance.getId() != null) {
				System.out.println("ERRORE: Id non null");
				System.exit(0);
			}
			entityManager.getTransaction().begin();

			if (ingredienteDAO.exist(ingredienteInstance)) {
				System.out.println("ERRORE: già esiste un ' ingrediente con gli stessi dati");
				System.exit(0);
			}

			ingredienteDAO.setEntityManager(entityManager);

			ingredienteDAO.insert(ingredienteInstance);
			System.out.println("Ingrediente inserito con successo");
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
			if (ingredienteInstance.equals(null)) {
				System.out.println("ERRORE: id ingrediente non inserito");
				System.exit(0);
			}
			entityManager.getTransaction().begin();

			ingredienteDAO.setEntityManager(entityManager);
			if (ingredienteDAO.get(ingredienteInstance.getId()) == null) {
				System.out.println("ERRORE: Non esiste un' ingredientw con questo id ");
				System.exit(0);
			}
			ingredienteDAO.delete(ingredienteInstance);
			System.out.println("Ingrediente rimosso con successo");
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
	public void aggiorna(Ingrediente ingredienteInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			if (ingredienteInstance.equals(null)) {
				System.out.println("ERRORE: dati ingrediente non inseriti");
				System.exit(0);
			}
			entityManager.getTransaction().begin();

			ingredienteDAO.setEntityManager(entityManager);
			if (!(ingredienteDAO.exist(ingredienteInstance))) {
				System.out.println("ERRORE: Non esiste un' ingrediente con questi dati ");
				System.exit(0);
			}
			ingredienteDAO.update(ingredienteInstance);
			System.out.println(" Ingrediente aggiornato con succcesso");
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

}
