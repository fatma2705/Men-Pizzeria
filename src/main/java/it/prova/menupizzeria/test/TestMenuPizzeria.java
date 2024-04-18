package it.prova.menupizzeria.test;

import java.util.List;

import it.prova.menupizzeria.model.Ingrediente;
import it.prova.menupizzeria.model.Pizza;
import it.prova.menupizzeria.service.IngredienteService;
import it.prova.menupizzeria.service.PizzaService;

public class TestMenuPizzeria {

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

	public static void inserisciPizza(PizzaService pizzaInstance, Pizza pizza,List<String> ingredienti) {
		System.out.println(" ----------- Test Inserisci pizza -------------");

		try {
			pizzaInstance.inserieciElemento(pizza,ingredienti);

			System.out.println(" ----------- Test Pizza inserita con successo ----");

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

	public static void getAllIngredienti(IngredienteService ingredienteInstance) {
		System.out.println(" ----------- Stampa tutti gli ingredienti presenti nel database -------------");

		try {
			List<Ingrediente> ingredienti = ingredienteInstance.listAll();
			for (Ingrediente i : ingredienti) {
				System.out.println(i.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void inserisciIngrediente(IngredienteService ingredienteInstance, Ingrediente ingrediente) {
		System.out.println(" ----------- Inserisci Ingrediente -------------");

		try {
			ingredienteInstance.inserisciElemento(ingrediente);
			System.out.println(" ----------- Ingrediente inserito con successo ----");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void aggiornaIngrediente(IngredienteService ingredienteInstance, Ingrediente ingrediente) {
		System.out.println(" -------------- Aggiorna Ingrediente  -----------");

		try {
			ingredienteInstance.aggiorna(ingrediente);
			System.out.println(" ----------- Ingrediente aggiornato con successo ----");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rimuoviIngrediente(IngredienteService ingredienteInstance, Ingrediente ingrediente) {
		System.out.println(" -----------------------Rimuovi Ingrediente ----------------");

		try {
			ingredienteInstance.rimuovi(ingrediente);
			System.out.println(" ----------- Ingrediente rimosso con successo ----");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getIngrediente(IngredienteService ingredienteInstance, Long id) {
		System.out.println(" -----------------------Stampa Ingrediente con l' id : " + id + " ----------------");

		try {
			System.out.println(ingredienteInstance.listElemento(id));
			System.out.println(" --------------------------------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
