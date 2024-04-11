package it.prova.menupizzeria.dao;

public class MyDAOFactory {
	
	
	private static PizzaDAO PizzaDaoInstance;
	private static IngredienteDAO IngredienteDaoInstance;
	
	public static PizzaDAO getPizzaDaoInstance() {
		if (PizzaDaoInstance == null ) {
			PizzaDaoInstance = new PizzaDAOImpl();
		}
		return PizzaDaoInstance;
		
	}
	
	
	public static IngredienteDAO getIngredienteDaoInstance() {
		if (IngredienteDaoInstance == null) {
			
			IngredienteDaoInstance = new IngredienteDAOImpl();
		}
		return IngredienteDaoInstance;
	}
	

}
