package it.prova.menupizzeria.test;

import java.util.List;

import it.prova.menupizzeria.dao.EntityManagerUtil;
import it.prova.menupizzeria.model.Pizza;
import it.prova.menupizzeria.service.IngredienteService;
import it.prova.menupizzeria.service.MyServiceFactory;
import it.prova.menupizzeria.service.PizzaService;

public class TestMenuPizzeria {

	public static void main(String[] args) {

		System.out.println(" ---------- Inizio programma -------------");

		PizzaService pizzaServiceInstance = MyServiceFactory.getpizzaServiceInstance();
		IngredienteService ingredienteServiceInstance = MyServiceFactory.getIngredienteServiceInstance();
		Pizza pizza = new Pizza(1L);

		try {
			
			
//			getPizza(pizzaServiceInstance,20L);
			
			

//			getAllPizze(pizzaServiceInstance);

//			inserisciPizza(pizzaServiceInstance, pizza);

//			aggiornaPizza(pizzaServiceInstance, pizza);
//
			rimuoviPizza(pizzaServiceInstance, pizza);

		} catch (Throwable e) {

			e.printStackTrace();

		} finally {

			EntityManagerUtil.shutdown();
		}

		System.out.println(" --------------Fine programma pizza ----------------");

	}

	public static void getAllPizze(PizzaService pizzaInstance) {

		System.out.println(" ----------- Stampa tutte le pizze presenti nel database -------------");

		try {
			List<Pizza> pizza = pizzaInstance.listAll();
			for (Pizza i : pizza) {
				System.out.println(i.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void inserisciPizza(PizzaService pizzaInstance, Pizza pizza) {
		System.out.println(" ----------- Inserisci pizza -------------");

		try {
			pizzaInstance.inserieciElemento(pizza);
			System.out.println(" ----------- Pizza inserita con successo ----");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void aggiornaPizza(PizzaService pizzaInstance, Pizza pizza) {
		System.out.println(" -------------- Aggiorna Pizza  -----------");

		try {
			pizzaInstance.aggiorna(pizza);
			System.out.println(" ----------- Pizza aggiornata con successo ----");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rimuoviPizza(PizzaService pizzaInstance, Pizza pizza) {
		System.out.println(" -----------------------Rimuovi Pizza ----------------");

		try {
			pizzaInstance.rimuovi(pizza);
			System.out.println(" ----------- Pizza rimossa con successo ----");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void getPizza(PizzaService pizzaInstance, Long id) {
		System.out.println(" -----------------------Stampa Pizza con l' id : " + id + " ----------------");

		try {
			System.out.println(pizzaInstance.listElemento(id));
			System.out.println(" --------------------------------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
