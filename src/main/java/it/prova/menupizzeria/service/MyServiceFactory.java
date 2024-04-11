package it.prova.menupizzeria.service;

import java.util.List;

import it.prova.menupizzeria.dao.IngredienteDAO;
import it.prova.menupizzeria.dao.MyDAOFactory;
import it.prova.menupizzeria.model.Ingrediente;

public class MyServiceFactory {
	
	private static IngredienteService ingredienteServiceInstance;
	private static PizzaService pizzaServiceInstance;
	
	
	public 	static IngredienteService getIngredienteServiceInstance() {
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
			ingredienteServiceInstance = new IngredienteServiceImpl();
		
		
		try {
			pizzaServiceInstance.setIngredienteDAO(MyDAOFactory.getIngredienteDaoInstance());
			pizzaServiceInstance.setPizzaDAO(MyDAOFactory.getPizzaDaoInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return pizzaServiceInstance;
	}

		
	}
	
	
	
		
		
		
	
	


