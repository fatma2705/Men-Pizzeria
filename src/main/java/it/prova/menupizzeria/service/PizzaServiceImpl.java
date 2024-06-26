package it.prova.menupizzeria.service;

import java.util.List;
import java.util.Set;

import it.prova.menupizzeria.dao.EntityManagerUtil;
import it.prova.menupizzeria.dao.IngredienteDAO;
import it.prova.menupizzeria.dao.PizzaDAO;
import it.prova.menupizzeria.model.Ingrediente;
import it.prova.menupizzeria.model.Pizza;
import jakarta.persistence.EntityManager;

public class PizzaServiceImpl implements PizzaService {

	private PizzaDAO pizzaDAOInstance;
	private IngredienteDAO ingredienteDAOInstance;

	@Override
	public List<Pizza> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			pizzaDAOInstance.setEntityManager(entityManager);
			if (pizzaDAOInstance.list().isEmpty()) {
				System.out.println("Database vuoto nulla da stampare");
				System.exit(0);
			}
			return pizzaDAOInstance.list();
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
			if (id == null) {
				System.out.println("ID non inserito");
				System.exit(0);
			}
			pizzaDAOInstance.setEntityManager(entityManager);
			if (pizzaDAOInstance.get(id) == null) {
				System.out.println("Non esiste una pizza con questo id");
				System.exit(0);
			}
			return pizzaDAOInstance.get(id);
		} catch (Exception e) {
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
			if (pizzaInstance == null) {
				System.out.println("ERRORE: id pizza non inserito");
				System.exit(0);
			}
			entityManager.getTransaction().begin();

			pizzaDAOInstance.setEntityManager(entityManager);
			Pizza existingPizza = pizzaDAOInstance.get(pizzaInstance.getId());
			if (existingPizza == null) {
				System.out.println("ERRORE: Non esiste una pizza con questo id ");
				System.exit(0);
			}
			pizzaDAOInstance.deletPizzaIngredienteAssociazione(existingPizza);
			System.out.println("Associazione tra pizza e ingrediente rimossa");

			ingredienteDAOInstance.deleteIngredienti(existingPizza.getIngredienti());
			System.out.println("Ingredienti rimossi");

			pizzaDAOInstance.delete(pizzaInstance);
			System.out.println("Pizza rimossa con successo");

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
	public void aggiorna(Pizza pizzaInstance, List<String> listaIngredienti) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			if (pizzaInstance.equals(null)) {
				System.out.println("ERRORE: dati pizza non inseriti");
				System.exit(0);
			}
			entityManager.getTransaction().begin();

			pizzaDAOInstance.setEntityManager(entityManager);
			if (pizzaDAOInstance.get(pizzaInstance.getId()) == null) {
				System.out.println("ERRORE: Non esiste una pizza con questi dati ");
				System.exit(0);
			}
			pizzaDAOInstance.deletPizzaIngredienteAssociazione(pizzaInstance);
			System.out.println("relazione tra pizza e ingrediente eliminata");
			pizzaDAOInstance.update(pizzaInstance);
			System.out.println("pizza aggiornta");
			for (String nome : listaIngredienti) {
				if (ingredienteDAOInstance.getByNome(nome) == null) {
					Ingrediente ingrediente = new Ingrediente(null, nome, true);
					ingredienteDAOInstance.insert(ingrediente);
					pizzaDAOInstance.setEntityManager(entityManager);
					pizzaDAOInstance.insertIngrediente(pizzaInstance, ingrediente);
				} else {
					pizzaDAOInstance.setEntityManager(entityManager);
					pizzaDAOInstance.insertIngrediente(pizzaInstance, ingredienteDAOInstance.getByNome(nome));
					System.out.println("Pizza inserita con successo");
				}
			}

			System.out.println("Pizza aggiornata con successo");

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
	public void inserieciElemento(Pizza pizzaInstance, List<String> listaIngredienti) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			if (pizzaInstance.equals(null)) {
				System.out.println("ERRORE: dati pizza non inseriti");
				System.exit(0);
			}
			if (pizzaInstance.getId() != null) {
				System.out.println("ERRORE: id non  null");
				System.exit(0);
			}
			entityManager.getTransaction().begin();

			if (pizzaDAOInstance.exist(pizzaInstance)) {
				System.out.println("ERRORE: già esiste una pizza con gli stessi dati");
				System.exit(0);
			}
			pizzaDAOInstance.insert(pizzaInstance);
			for (String nome : listaIngredienti) {
				if (ingredienteDAOInstance.getByNome(nome) == null) {
					Ingrediente ingrediente = new Ingrediente(null, nome, true);
					ingredienteDAOInstance.insert(ingrediente);
					pizzaDAOInstance.setEntityManager(entityManager);
					pizzaDAOInstance.insertIngrediente(pizzaInstance, ingrediente);
				} else {
					pizzaDAOInstance.setEntityManager(entityManager);
					pizzaDAOInstance.insertIngrediente(pizzaInstance, ingredienteDAOInstance.getByNome(nome));
					System.out.println("Pizza inserita con successo");
				}
			}

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
