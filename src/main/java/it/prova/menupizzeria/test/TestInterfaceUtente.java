package it.prova.menupizzeria.test;

import java.util.Scanner;

import it.prova.menupizzeria.model.Pizza;
import it.prova.menupizzeria.service.MyServiceFactory;
import it.prova.menupizzeria.service.PizzaService;

public class TestInterfaceUtente {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("Benvenuto nella tua interfaccia utente. Scegli un'opzione:");
			System.out.println("1. Creare una pizza");
			System.out.println("2. Leggere una pizza");
			System.out.println("3. Aggiornare una pizza");
			System.out.println("4. Eliminare una pizza");
			System.out.println("5. Uscire");

			int choice = scanner.nextInt();
			scanner.nextLine();

			PizzaService pizzaServiceInstance = MyServiceFactory.getpizzaServiceInstance();

			switch (choice) {
			case 1:
				System.out.println("Ha scelto il primo comando per creare una pizza");
				System.out.println("Inserisci il prezzo della pizza da creare:");
				float prezzo = scanner.nextFloat();
				scanner.nextLine(); 

				System.out.println("Inserisci il nome della pizza da creare:");
				String nome = scanner.nextLine();

				System.out.println("Inserisci true se la pizza è custom, false se non lo è:");
				boolean custom = scanner.nextBoolean();
				scanner.nextLine(); 

				Pizza pizza = new Pizza(null, prezzo, nome, custom);
				TestMenuPizzeria.inserisciPizza(pizzaServiceInstance, pizza);

				break;
			case 2:
				System.out.println("Ha scelto il secondo comando per stampare una pizza");
				System.out.println("Inserisci L'id  della pizza da leggere:");
				Long id = scanner.nextLong();
				scanner.nextLine();
				TestMenuPizzeria.getPizza(pizzaServiceInstance, id);
				
			case 3:
				System.out.println("Ha scelto il terzo comando per aggiornare una pizza");
				System.out.println("Inserisci L'id  della pizza da aggiornare:");
				Long idP = scanner.nextLong();
				scanner.nextLine();
				System.out.println("Inserisci il prezzo della pizza da aggiornare:");
				float prezzoP = scanner.nextFloat();
				scanner.nextLine(); 

				System.out.println("Inserisci il nome della pizza da aggiornare:");
				String nomeP = scanner.nextLine();

				System.out.println("Inserisci true se la pizza è custom, false se non lo è:");
				boolean customP = scanner.nextBoolean();
				scanner.nextLine(); 

				Pizza pizzaP = new Pizza(idP, prezzoP, nomeP, customP);
				TestMenuPizzeria.aggiornaPizza(pizzaServiceInstance, pizzaP);

				break;
			case 4:
				System.out.println("Ha scelto il quarto comando per eliminare una pizza");
				System.out.println("Inserisci L'id  della pizza da eliminare:");
				Long idp = scanner.nextLong();
				scanner.nextLine();
				Pizza pizzap = new Pizza(idp);
				TestMenuPizzeria.rimuoviPizza(pizzaServiceInstance, pizzap);

				break;
			case 5:
				exit = true;
				break;
			default:
				System.out.println("Opzione non valida. Riprova.");
			}
		}

		System.out.println("Grazie per aver usato l'interfaccia utente. Arrivederci!");
		scanner.close();
	}

}
