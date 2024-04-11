package it.prova.menupizzeria.test;

import java.util.List;

import it.prova.menupizzeria.model.Pizza;
import it.prova.menupizzeria.service.IngredienteService;
import it.prova.menupizzeria.service.MyServiceFactory;
import it.prova.menupizzeria.service.PizzaService;

public class TestMenuPizzeria {

	public static void main(String[] args) {
		
		PizzaService pizzaServiceInstance = MyServiceFactory.getpizzaServiceInstance();
		IngredienteService ingredienteServiceInstance = MyServiceFactory.getIngredienteServiceInstance(); 

		
		getAllPizze(pizzaServiceInstance);
		
		
		

	}
	
	
	public static void getAllPizze(PizzaService pizzaInstance) {
		
		System.out.println(" ----------- Stampa tutte le pizze presenti nel database -------------");
		
		try {
			List<Pizza> pizza =pizzaInstance.listAll();
			for (Pizza i : pizza) {
				System.out.println(i.toString());
				}
			
			
		} catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
