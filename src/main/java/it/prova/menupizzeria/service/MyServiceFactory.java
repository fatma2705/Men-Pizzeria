package it.prova.menupizzeria.service;

import it.prova.menupizzeria.dao.MyDAOFactory;

public class MyServiceFactory {

	private static IngredienteService ingredienteServiceInstance;
	private static PizzaService pizzaServiceInstance;

	public static IngredienteService getIngredienteServiceInstance() {
		if (ingredienteServiceInstance == null)
			ingredienteServiceInstance = new IngredienteServiceImpl();

		try {
			ingredienteServiceInstance.setIngredienteDAO(MyDAOFactory.getIngredienteDaoInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ingredienteServiceInstance;

	}

	public static PizzaService getpizzaServiceInstance() {
		if (pizzaServiceInstance == null)
			pizzaServiceInstance = new PizzaServiceImpl();

		try {

			pizzaServiceInstance.setPizzaDAO(MyDAOFactory.getPizzaDaoInstance());
			pizzaServiceInstance.setIngredienteDAO(MyDAOFactory.getIngredienteDaoInstance());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return pizzaServiceInstance;
	}

}
